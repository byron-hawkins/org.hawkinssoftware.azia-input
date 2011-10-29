/*
 * Copyright (c) 2011 HawkinsSoftware
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Byron Hawkins of HawkinsSoftware
 */
package org.hawkinssoftware.azia.input.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;

import org.hawkinssoftware.azia.core.log.AziaLogging.Tag;
import org.hawkinssoftware.rns.core.log.Log;
import org.hawkinssoftware.rns.core.publication.InvocationConstraint;
import org.hawkinssoftware.rns.core.role.CoreDomains.InitializationDomain;
import org.hawkinssoftware.rns.core.validation.ValidateRead;
import org.hawkinssoftware.rns.core.validation.ValidateWrite;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class ClipboardMonitor
{
	
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public interface Listener
	{
		void newClipboardContent(ClipboardContents contents);
	}

	public static void initialize()
	{
		INSTANCE = new ClipboardMonitor();
		INSTANCE.start();
	}

	public static ClipboardMonitor getInstance()
	{
		return INSTANCE;
	}

	private static ClipboardMonitor INSTANCE;

	private final Poll poll = new Poll();
	private final List<Listener> listeners = new ArrayList<Listener>();

	private void start()
	{
		poll.start();
	}

	public void addListener(Listener listener)
	{
		synchronized (listeners)
		{
			listeners.add(listener);
		}
	}

	public void removeListener(Listener listener)
	{
		synchronized (listeners)
		{
			listeners.remove(listener);
		}
	}

	public ClipboardContents getCurrentClipboardContents()
	{
		synchronized (poll.lock)
		{
			return poll.contents;
		}
	}

	public void putClipboardContents(ClipboardContents contents)
	{
		poll.systemClipboard.setContents(contents.contents, null);
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	@ValidateRead(validatorType = ClipboardMonitor.class, method = "holdsLock")
	@ValidateWrite(validatorType = ClipboardMonitor.class, method = "holdsLock")
	public class Poll extends Thread implements ClipboardOwner
	{
		private final Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		private final Object lock = new Object();

		private ClipboardContents contents = null;

		// synchronized under `lock
		private ClipboardContents putContents = null;

		Poll()
		{
			super("Azia-ClipboardPoll");

			setDaemon(true);
		}

		private void reportContentChange(ClipboardContents contents)
		{
			synchronized (listeners)
			{
				for (Listener listener : listeners)
				{
					listener.newClipboardContent(contents);
				}
			}
		}

		void putContents(ClipboardContents putContents)
		{
			synchronized (lock)
			{
				this.putContents = putContents;
				lock.notify();
			}
		}

		@Override
		public void run()
		{
			try
			{
				ClipboardContents broadcastContents;
				synchronized (lock)
				{
					this.contents = new ClipboardContents(systemClipboard.getContents(null));
					broadcastContents = this.contents;
				}
				reportContentChange(broadcastContents);
			}
			catch (Throwable t)
			{
				Log.out(Tag.CRITICAL, t, "Failed to get initial clipboard data.");
			}

			ClipboardContents broadcastContents;
			while (true)
			{
				try
				{
					broadcastContents = null;
					synchronized (lock)
					{
						if (putContents == null)
						{
							Transferable poll = systemClipboard.getContents(null);
							ClipboardContents pollContents = new ClipboardContents(poll);
							if (!contents.equals(pollContents))
							{
								contents = pollContents;
								broadcastContents = contents;
							}
						}
						else
						{
							systemClipboard.setContents(putContents.contents, this);
							contents = putContents;
							putContents = null;

							broadcastContents = contents;
						}
					}

					if (broadcastContents != null)
					{
						reportContentChange(broadcastContents);
					}

					try
					{
						synchronized (lock)
						{
							lock.wait(500L);
						}
					}
					catch (InterruptedException e)
					{
					}
				}
				catch (Throwable t)
				{
					Log.out(Tag.CRITICAL, t, "Exception on the clipboard poll.");
				}
			}
		}

		@Override
		public void lostOwnership(Clipboard clipboard, Transferable contents)
		{
			// pf
		}
	}

	public static void holdsLock(Object accessingEntity, Object fieldOwner, String fieldName)
	{
		if (!Thread.holdsLock(getInstance().poll.lock))
		{
			Log.out(Tag.WARNING, "Type %s attempted to access lock-protected field %s without hold the lock.", accessingEntity.getClass().getSimpleName(),
					fieldName);
		}
	}

	@InvocationConstraint(domains = InitializationDomain.class)
	public static void main(String[] args)
	{
		try
		{
			Log.addOutput(System.out);
			initialize();

			synchronized (getInstance())
			{
				getInstance().wait();
			}
		}
		catch (Throwable t)
		{
			Log.out(Tag.CRITICAL, t);
		}
	}
}
