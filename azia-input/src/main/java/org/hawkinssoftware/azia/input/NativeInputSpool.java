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
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hawkinssoftware.azia.core.log.AziaLogging.Tag;
import org.hawkinssoftware.azia.input.KeyboardInputEvent.State;
import org.hawkinssoftware.azia.input.key.HardwareKey;
import org.hawkinssoftware.azia.input.key.HardwareKeyIndex;
import org.hawkinssoftware.rns.core.log.Log;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class NativeInputSpool
{
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	private class NativeEventReceiver implements NativeInput.Listener
	{
		private long lastMouseMove = 0L;
		private boolean doubleClickReady = false;
		private MouseInputEvent lastClick = new MouseInputEvent(0, 0, 0, EnumSet.noneOf(MouseInputEvent.Button.class),
				EnumSet.noneOf(MouseInputEvent.Change.class));

		private final Set<HardwareKey> pressedKeys = EnumSet.noneOf(HardwareKey.class);

		// TODO: can any of these mouse events arrive concurrently?
		@Override
		public void mouseButtonEvent(int windowsEventId)
		{
			MouseInputEvent.Button eventButton = null;
			MouseInputEvent.Change eventChange = null;
			MouseState.ButtonPosition eventState = null;
			switch (windowsEventId)
			{
				case MouseState.LEFT_BUTTON_UP:
					eventButton = MouseInputEvent.Button.LEFT;
					eventChange = MouseInputEvent.Change.LEFT_BUTTON;
					eventState = MouseState.ButtonPosition.UP;
					break;
				case MouseState.LEFT_BUTTON_DOWN:
					eventButton = MouseInputEvent.Button.LEFT;
					eventChange = MouseInputEvent.Change.LEFT_BUTTON;
					eventState = MouseState.ButtonPosition.DOWN;
					break;
				case MouseState.MIDDLE_BUTTON_UP:
					eventButton = MouseInputEvent.Button.MIDDLE;
					eventChange = MouseInputEvent.Change.MIDDLE_BUTTON;
					eventState = MouseState.ButtonPosition.UP;
					break;
				case MouseState.MIDDLE_BUTTON_DOWN:
					eventButton = MouseInputEvent.Button.MIDDLE;
					eventChange = MouseInputEvent.Change.MIDDLE_BUTTON;
					eventState = MouseState.ButtonPosition.DOWN;
					break;
				case MouseState.RIGHT_BUTTON_UP:
					eventButton = MouseInputEvent.Button.RIGHT;
					eventChange = MouseInputEvent.Change.RIGHT_BUTTON;
					eventState = MouseState.ButtonPosition.UP;
					break;
				case MouseState.RIGHT_BUTTON_DOWN:
					eventButton = MouseInputEvent.Button.RIGHT;
					eventChange = MouseInputEvent.Change.RIGHT_BUTTON;
					eventState = MouseState.ButtonPosition.DOWN;
					break;
			}

			switch (eventState)
			{
				case UP:
					mouseState.buttonsDown.remove(eventButton);
					break;
				case DOWN:
					mouseState.buttonsDown.add(eventButton);
					break;
			}

			MouseInputEvent event = new MouseInputEvent(mouseState.x, mouseState.y, 0, EnumSet.copyOf(mouseState.buttonsDown), EnumSet.of(eventChange,
					MouseInputEvent.Change.BUTTON));

			if (eventState == MouseState.ButtonPosition.DOWN)
			{
				if (doubleClickReady && lastClick.changes().contains(eventChange) && ((event.timestamp - lastClick.timestamp) < DOUBLE_CLICK_THRESHOLD))
				{
					event.changes().add(MouseInputEvent.Change.DOUBLE_CLICK);
					doubleClickReady = false;
				}
				else
				{
					doubleClickReady = true;
				}
			}

			synchronized (eventBuffer)
			{
				eventBuffer.add(event);
				eventBuffer.notify();
			}

			lastClick = event;
		}

		@Override
		public void mouseMoveEvent(int x, int y)
		{
			long now = System.currentTimeMillis();
			int velocity = -1;
			if (lastMouseMove > 0L)
			{
				int travel = Math.abs(mouseState.x - x) + Math.abs(mouseState.y - y);
				long elapsedTime = (now - lastMouseMove);

				int elapsedMoments = (int) ((elapsedTime / 2) + 1);

				if (travel == 0)
				{
					velocity = 0;
				}
				else
				{
					velocity = Math.max(1, travel / elapsedMoments);
				}
			}
			lastMouseMove = now;

			mouseState.x = x;
			mouseState.y = y;

			doubleClickReady = false;

			MouseInputEvent event = new MouseInputEvent(x, y, velocity, Collections.unmodifiableSet(EnumSet.copyOf(mouseState.buttonsDown)),
					Collections.unmodifiableSet(EnumSet.of(MouseInputEvent.Change.POSITION)));

			synchronized (eventBuffer)
			{
				eventBuffer.add(event);
				eventBuffer.notify();
			}
		}

		@Override
		public void keyboardEvent(boolean isKeyDown, int keyId)
		{
			HardwareKey key = HardwareKeyIndex.lookup(keyId);
			KeyboardInputEvent.State state;
			if (isKeyDown)
			{
				if (pressedKeys.add(key))
				{
					state = State.DOWN;
				}
				else
				{
					state = State.REPEAT;
				}
			}
			else
			{
				pressedKeys.remove(key);
				state = State.UP;
			}

			KeyboardInputEvent event = new KeyboardInputEvent(key, state, Collections.unmodifiableSet(EnumSet.copyOf(pressedKeys)));
			synchronized (eventBuffer)
			{
				eventBuffer.add(event);
				eventBuffer.notify();
			}
		}
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public interface Listener
	{
		void mouseStateChanged(MouseInputEvent event);

		void keyboardStateChanged(KeyboardInputEvent event);
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	private static class MouseState
	{
		
		/**
		 * DOC comment task awaits.
		 * 
		 * @author Byron Hawkins
		 */
		private enum ButtonPosition
		{
			UP,
			DOWN;
		}

		static final int LEFT_BUTTON_UP = 514;
		static final int LEFT_BUTTON_DOWN = 513;
		static final int MIDDLE_BUTTON_UP = -1;
		static final int MIDDLE_BUTTON_DOWN = -2;
		static final int RIGHT_BUTTON_UP = 517;
		static final int RIGHT_BUTTON_DOWN = 516;

		private final Set<MouseInputEvent.Button> buttonsDown = EnumSet.noneOf(MouseInputEvent.Button.class);
		private int x;
		private int y;
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	private class Spool extends Thread
	{
		public Spool()
		{
			super("Azia-NativeInputSpool");
		}

		@Override
		public void run()
		{
			NativeInputEvent<?> event;
			while (true)
			{
				try
				{
					synchronized (eventBuffer)
					{
						if (eventBuffer.isEmpty())
						{
							try
							{
								eventBuffer.wait();
							}
							catch (InterruptedException wakeup)
							{
							}
						}

						event = eventBuffer.remove(0);
					}

					synchronized (listeners)
					{
						for (Listener listener : listeners)
						{
							if (event instanceof MouseInputEvent)
							{
								listener.mouseStateChanged(((MouseInputEvent) event).copy());
							}
							else if (event instanceof KeyboardInputEvent)
							{
								listener.keyboardStateChanged(((KeyboardInputEvent) event).copy());
							}
						}
					}
				}
				catch (Throwable t)
				{
					Log.out(Tag.CRITICAL, t, "Exception on the native input spool.");
				}
			}
		}
	}

	private static final long DOUBLE_CLICK_THRESHOLD = 200L;

	private final List<NativeInputEvent<?>> eventBuffer = new LinkedList<NativeInputEvent<?>>();

	private final Spool spool = new Spool();
	private final NativeEventReceiver receiver = new NativeEventReceiver();

	private final MouseState mouseState = new MouseState();

	private final List<Listener> listeners = new ArrayList<Listener>();

	public void start()
	{
		spool.start();
		NativeInput.getInstance().addListener(receiver);
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
}
