package org.hawkinssoftware.azia.input;

import org.hawkinssoftware.azia.core.log.AziaLogging.Tag;
import org.hawkinssoftware.rns.core.log.Log;

public class NativeInput
{
	public interface Listener
	{
		void mouseButtonEvent(int windowsEventId);

		void mouseMoveEvent(int x, int y);

		void keyboardEvent(boolean isKeyDown, int keyId);
	}

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

	// devours the thread until stopNativeEventHook is called
	private native void startNativeEventHook();

	private native void stopNativeEventHook();

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
