package org.hawkinssoftware.azia.input;

import java.util.Set;

import org.hawkinssoftware.azia.input.key.HardwareKey;

public class KeyboardInputEvent extends NativeInputEvent<KeyboardInputEvent>
{
	public enum State
	{
		UP,
		DOWN,
		REPEAT;
	}

	public final HardwareKey key;
	public final State state;
	public final Set<HardwareKey> pressedKeys;

	KeyboardInputEvent(HardwareKey key, State state, Set<HardwareKey> pressedKeys)
	{
		this.key = key;
		this.state = state;
		this.pressedKeys = pressedKeys;
	}

	private KeyboardInputEvent(long timestamp, HardwareKey key, State state, Set<HardwareKey> pressedKeys)
	{
		super(timestamp);

		this.key = key;
		this.state = state;
		this.pressedKeys = pressedKeys;
	}

	public boolean hasModifiers()
	{
		return (pressedKeys.contains(HardwareKey.RCONTROL) || pressedKeys.contains(HardwareKey.LCONTROL) || pressedKeys.contains(HardwareKey.RWIN)
				|| pressedKeys.contains(HardwareKey.LWIN) || pressedKeys.contains(HardwareKey.RMENU) || pressedKeys.contains(HardwareKey.LMENU));
	}

	public boolean isShifted()
	{
		return pressedKeys.contains(HardwareKey.SHIFT) || pressedKeys.contains(HardwareKey.LSHIFT) || pressedKeys.contains(HardwareKey.RSHIFT);
	}

	public boolean isCharacter()
	{
		if (hasModifiers())
		{
			return false;
		}

		if ((key.ordinal() >= HardwareKey.KEYBOARD0.ordinal()) && (key.ordinal() <= HardwareKey.Z.ordinal()))
		{
			return true;
		}
		if ((key.ordinal() >= HardwareKey.NUMPAD0.ordinal()) && (key.ordinal() <= HardwareKey.NUMPAD9.ordinal()))
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
		if (pressedKeys.contains(HardwareKey.RCONTROL) || pressedKeys.contains(HardwareKey.LCONTROL) || pressedKeys.contains(HardwareKey.RWIN)
				|| pressedKeys.contains(HardwareKey.LWIN) || pressedKeys.contains(HardwareKey.RMENU) || pressedKeys.contains(HardwareKey.LMENU))
		{
			return ' ';
		}

		if ((key.ordinal() >= HardwareKey.KEYBOARD0.ordinal()) && (key.ordinal() <= HardwareKey.KEYBOARD9.ordinal()))
		{
			if (isShifted())
			{
				switch (key)
				{
					case KEYBOARD0:
						return ')';
					case KEYBOARD1:
						return '!';
					case KEYBOARD2:
						return '@';
					case KEYBOARD3:
						return '#';
					case KEYBOARD4:
						return '$';
					case KEYBOARD5:
						return '%';
					case KEYBOARD6:
						return '^';
					case KEYBOARD7:
						return '&';
					case KEYBOARD8:
						return '*';
					case KEYBOARD9:
						return '(';
				}
			}
			else
			{
				return (char) ('0' + (key.ordinal() - HardwareKey.KEYBOARD0.ordinal()));
			}
		}

		if ((key.ordinal() >= HardwareKey.NUMPAD0.ordinal()) && (key.ordinal() <= HardwareKey.NUMPAD9.ordinal()))
		{
			return (char) ('0' + (key.ordinal() - HardwareKey.NUMPAD0.ordinal()));
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
		return new KeyboardInputEvent(timestamp, key, state, pressedKeys);
	}

	@Override
	public String describe()
	{
		return "(" + key + " " + state + " " + pressedKeys + ")";
	}
}
