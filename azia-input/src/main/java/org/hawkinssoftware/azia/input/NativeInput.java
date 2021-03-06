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
package org.hawkinssoftware.azia.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hawkinssoftware.azia.core.log.AziaLogging.Tag;
import org.hawkinssoftware.azia.input.key.HardwareKey;
import org.hawkinssoftware.azia.input.key.LogicalKey;
import org.hawkinssoftware.rns.core.log.Log;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class NativeInput
{
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public interface Listener
	{
		void mouseButtonEvent(int windowsEventId);

		void mouseMoveEvent(int x, int y);

		void keyboardEvent(boolean isKeyDown, int keyId);
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	private class ListenerThread extends Thread
	{
		public ListenerThread()
		{
			super("Azia-NativeInputListener");
		}

		@Override
		public void run()
		{
			startNativeEventHook();
		}
	}

	private static NativeInput INSTANCE;

	public static NativeInput getInstance()
	{
		synchronized (NativeInput.class)
		{
			if (INSTANCE == null)
			{
				INSTANCE = new NativeInput();
			}
			return INSTANCE;
		}
	}

	private final ListenerThread listenerThread = new ListenerThread();
	private final Listener[] listeners = new Listener[100];
	private int listenerCount = 0;

	private boolean running = false;
	private boolean nativeLibraryLoaded = false;

	public void addListener(Listener listener)
	{
		synchronized (NativeInput.class)
		{
			listeners[listenerCount] = listener;
			listenerCount++;

			if (!running)
			{
				startListenerThread();
			}
		}
	}

	public void removeListener(Listener listener)
	{
		synchronized (NativeInput.class)
		{
			int insertIndex = 0;
			for (int i = 0; i < listenerCount; i++)
			{
				if (listeners[i] != listener)
				{
					listeners[insertIndex] = listeners[i];
					insertIndex++;
				}
			}
			listenerCount--;
			if (listenerCount == 0)
			{
				stopListenerThread();
			}
		}
	}

	public void setMetaKeys(Set<LogicalKey> metaKeys)
	{
		int index = 0;
		for (LogicalKey key : metaKeys)
		{
			List<HardwareKey> synonymList = new ArrayList<HardwareKey>(key.getHardwareKeys());

			int keyCode1 = (synonymList.size() > 0) ? synonymList.get(0).keyCode : 0x0;
			int keyCode2 = (synonymList.size() > 1) ? synonymList.get(1).keyCode : 0x0;
			int keyCode3 = (synonymList.size() > 2) ? synonymList.get(2).keyCode : 0x0;

			defineMetaKey(index, keyCode1, keyCode2, keyCode3);
			index++;
		}
	}

	private void startListenerThread()
	{
		synchronized (NativeInput.class)
		{
			if (!nativeLibraryLoaded)
			{
				try
				{
					System.loadLibrary("NativeInput.x86");
					nativeLibraryLoaded = true;
				}
				catch (Throwable t)
				{
					Log.out(Tag.WARNING, "Warning: failed to load the x86 library (%s: %s). Trying the x64 library now...", t.getClass().getSimpleName(),
							t.getMessage());
				}

				if (!nativeLibraryLoaded)
				{
					System.loadLibrary("NativeInput.x64");
				}
			}

			listenerThread.start();
			running = true;
		}
	}

	private void stopListenerThread()
	{
		synchronized (NativeInput.class)
		{
			stopNativeEventHook();
			running = false;
		}
	}

	// beware: devours the thread until stopNativeEventHook is called
	private native void startNativeEventHook();

	private native void stopNativeEventHook();

	private native void defineMetaKey(int index, int keyCode1, int keyCode2, int keyCode3);

	private native void clearMetaKeys();

	// called from JNI
	public void mouseButtonEvent(int windowsEventId)
	{
		synchronized (NativeInput.class)
		{
			for (int i = 0; i < listenerCount; i++)
			{
				listeners[i].mouseButtonEvent(windowsEventId);
			}
		}
	}

	// called from JNI
	public void mouseMoveEvent(int x, int y)
	{
		for (int i = 0; i < listenerCount; i++)
		{
			listeners[i].mouseMoveEvent(x, y);
		}
	}

	// called from JNI
	public void keyboardEvent(boolean transitionState, int windowsEventId)
	{
		for (int i = 0; i < listenerCount; i++)
		{
			listeners[i].keyboardEvent(transitionState, windowsEventId);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			System.loadLibrary("NativeInput");

			NativeInput test = new NativeInput();
			test.startNativeEventHook();
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
}
