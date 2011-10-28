package org.hawkinssoftware.azia.input;

public abstract class NativeInputEvent<Type extends NativeInputEvent<Type>>
{
	long timestamp;
	
	NativeInputEvent()
	{
		this.timestamp = System.currentTimeMillis();
	}
	
	NativeInputEvent(long timestamp)
	{
		this.timestamp = timestamp;
	}

	public abstract Type copy();
	
	public abstract String describe();
}
