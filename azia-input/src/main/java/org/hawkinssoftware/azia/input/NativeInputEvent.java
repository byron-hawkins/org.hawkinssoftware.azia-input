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

/**
 * DOC comment task awaits.
 * 
 * @param <Type>
 *            the generic type
 * @author Byron Hawkins
 */
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
