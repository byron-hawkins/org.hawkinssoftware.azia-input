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

import java.util.EnumSet;
import java.util.Set;

import org.hawkinssoftware.azia.core.layout.ScreenPosition;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class MouseInputEvent extends NativeInputEvent<MouseInputEvent> implements ScreenPosition
{
	
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public enum Button
	{
		LEFT,
		MIDDLE,
		RIGHT;
	}

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public enum Change
	{
		POSITION,
		LEFT_BUTTON(Button.LEFT),
		MIDDLE_BUTTON(Button.MIDDLE),
		RIGHT_BUTTON(Button.RIGHT),
		BUTTON,
		DOUBLE_CLICK;

		private final Button button;

		private Change()
		{
			this(null);
		}

		private Change(Button button)
		{
			this.button = button;
		}

		public static final Set<Change> INDIVIDUAL_BUTTONS = EnumSet.of(LEFT_BUTTON, MIDDLE_BUTTON, RIGHT_BUTTON);
	}

	private int x;
	private int y;
	private int velocity;
	private final Set<Button> buttonsDown;
	private final Set<Change> changes;

	MouseInputEvent(int x, int y, int velocity, Set<Button> buttonsDown, Set<Change> changes)
	{
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.buttonsDown = buttonsDown;
		this.changes = changes;
	}

	private MouseInputEvent(long timestamp, int x, int y, int velocity, Set<Button> buttonsDown, Set<Change> changes)
	{
		super(timestamp);

		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.buttonsDown = buttonsDown;
		this.changes = changes;
	}

	// TODO: restrict somehow
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public MouseInputEvent copy()
	{
		return new MouseInputEvent(timestamp, x, y, velocity, buttonsDown, changes);
	}

	@Override
	public int x()
	{
		return x;
	}

	@Override
	public int y()
	{
		return y;
	}

	public int velocity()
	{
		return velocity;
	}

	public Set<Button> buttonsDown()
	{
		return buttonsDown;
	}

	public Set<Change> changes()
	{
		return changes;
	}

	public Button getButtonPress()
	{
		if (changes.contains(Change.BUTTON))
		{
			for (Change button : Change.INDIVIDUAL_BUTTONS)
			{
				if (changes.contains(button) && buttonsDown.contains(button.button))
				{
					return button.button;
				}
			}
		}
		return null;
	}

	public Button getButtonRelease()
	{
		if (changes.contains(Change.BUTTON))
		{
			for (Change button : Change.INDIVIDUAL_BUTTONS)
			{
				if (changes.contains(button) && !buttonsDown.contains(button.button))
				{
					return button.button;
				}
			}
		}
		return null;
	}

	public boolean isDoubleClick()
	{
		return changes.contains(Change.DOUBLE_CLICK);
	}

	@Override
	public String describe()
	{
		return "(" + x + ", " + y + " @" + velocity + " " + buttonsDown + " " + changes + ")";
	}
}
