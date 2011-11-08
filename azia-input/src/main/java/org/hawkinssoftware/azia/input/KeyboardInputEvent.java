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

import java.util.Set;

import org.hawkinssoftware.azia.input.key.HardwareKey;
import org.hawkinssoftware.azia.input.key.LogicalKey;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class KeyboardInputEvent extends NativeInputEvent<KeyboardInputEvent>
{

	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public enum State
	{
		UP,
		DOWN,
		REPEAT;
	}

	public final HardwareKey key;
	public final State state;
	public final Set<HardwareKey> pressedHardwareKeys;
	public final Set<LogicalKey> pressedLogicalKeys;

	KeyboardInputEvent(HardwareKey key, State state, Set<HardwareKey> pressedKeys)
	{
		this.key = key;
		this.state = state;
		this.pressedHardwareKeys = pressedKeys;
		pressedLogicalKeys = HardwareKey.getLogicalEquivalent(pressedHardwareKeys);
	}

	private KeyboardInputEvent(long timestamp, HardwareKey key, State state, Set<HardwareKey> pressedKeys)
	{
		super(timestamp);

		this.key = key;
		this.state = state;
		this.pressedHardwareKeys = pressedKeys;
		pressedLogicalKeys = HardwareKey.getLogicalEquivalent(pressedHardwareKeys);
	}

	public boolean hasModifiers()
	{
		return (pressedLogicalKeys.contains(LogicalKey.CONTROL) || pressedLogicalKeys.contains(LogicalKey.WIN) || pressedLogicalKeys.contains(LogicalKey.MENU));
	}

	public boolean isShifted()
	{
		return pressedLogicalKeys.contains(LogicalKey.SHIFT);
	}

	public boolean isCharacter()
	{
		if (hasModifiers())
		{
			return false;
		}

		if ((key.logicalKey.ordinal() >= LogicalKey.NUMBER0.ordinal()) && (key.logicalKey.ordinal() <= LogicalKey.Z.ordinal()))
		{
			return true;
		}

		switch (key)
		{
			case SPACE:
			case SEPARATOR:
			case ADD:
			case MULTIPLY:
			case DIVIDE:
			case SUBTRACT:
			case OEM_COMMA:
			case OEM_PERIOD:
			case OEM_MINUS:
			case OEM_PLUS:
			case OEM_NEC_EQUAL:
			case SEMICOLON:
			case SLASH:
			case BACKTICK:
			case BACKSLASH:
			case BRACKET_CLOSED:
			case BRACKET_OPEN:
			case QUOTE:
			case BANG:
				return true;
		}

		return false;
	}

	public char getCharacter()
	{
		if (hasModifiers())
		{
			return ' ';
		}

		if ((key.logicalKey.ordinal() >= LogicalKey.NUMBER0.ordinal()) && (key.logicalKey.ordinal() <= LogicalKey.NUMBER9.ordinal()))
		{
			if (isShifted())
			{
				switch (key.logicalKey)
				{
					case NUMBER0:
						return ')';
					case NUMBER1:
						return '!';
					case NUMBER2:
						return '@';
					case NUMBER3:
						return '#';
					case NUMBER4:
						return '$';
					case NUMBER5:
						return '%';
					case NUMBER6:
						return '^';
					case NUMBER7:
						return '&';
					case NUMBER8:
						return '*';
					case NUMBER9:
						return '(';
				}
			}
			else
			{
				return (char) ('0' + (key.logicalKey.ordinal() - LogicalKey.NUMBER0.ordinal()));
			}
		}

		if ((key.logicalKey.ordinal() >= LogicalKey.NUMBER0.ordinal()) && (key.logicalKey.ordinal() <= LogicalKey.NUMBER9.ordinal()))
		{
			return (char) ('0' + (key.ordinal() - LogicalKey.NUMBER0.ordinal()));
		}

		if ((key.ordinal() >= HardwareKey.A.ordinal()) && (key.ordinal() <= HardwareKey.Z.ordinal()))
		{
			if (isShifted())
			{
				return (char) ('A' + (key.ordinal() - HardwareKey.A.ordinal()));
			}
			else
			{
				return (char) ('a' + (key.ordinal() - HardwareKey.A.ordinal()));
			}
		}

		// TODO: brackets, braces, `, ~, quotes, /, ?, :, ;, |, \

		switch (key)
		{
			case SPACE:
				return ' ';
			case ADD:
				return '+';
			case MULTIPLY:
				return '*';
			case DIVIDE:
				return '/';
			case SUBTRACT:
				return '-';
			case DECIMAL:
				return '.';
		}

		if (isShifted())
		{
			switch (key)
			{
				case SEPARATOR:
					return '|'; // fail
				case OEM_COMMA:
					return '<';
				case OEM_PERIOD:
					return '>';
				case OEM_MINUS:
					return '_';
				case OEM_PLUS:
					return '+';
				case OEM_NEC_EQUAL:
					return '=';
				case SEMICOLON:
					return ':';
				case SLASH:
					return '?';
				case BACKTICK:
					return '~';
				case BACKSLASH:
					return '|';
				case BRACKET_CLOSED:
					return '}';
				case BRACKET_OPEN:
					return '{';
				case QUOTE:
					return '"';
				case BANG:
					return '�';
			}
		}
		else
		{
			switch (key)
			{
				case SEPARATOR:
					return '\\'; // fail
				case OEM_COMMA:
					return ',';
				case OEM_PERIOD:
					return '.';
				case OEM_MINUS:
					return '-';
				case OEM_PLUS:
					return '=';
				case OEM_NEC_EQUAL:
					return '+';
				case SEMICOLON:
					return ';';
				case SLASH:
					return '/';
				case BACKTICK:
					return '`';
				case BACKSLASH:
					return '\\';
				case BRACKET_CLOSED:
					return ']';
				case BRACKET_OPEN:
					return '[';
				case QUOTE:
					return '\'';
				case BANG:
					return '!';
			}
		}

		return ' ';
	}

	@Override
	public KeyboardInputEvent copy()
	{
		return new KeyboardInputEvent(timestamp, key, state, pressedHardwareKeys);
	}

	@Override
	public String describe()
	{
		return "(" + key + " " + state + " " + pressedHardwareKeys + ")";
	}
}
