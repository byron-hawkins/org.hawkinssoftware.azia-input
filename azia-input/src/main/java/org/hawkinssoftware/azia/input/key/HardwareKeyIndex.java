package org.hawkinssoftware.azia.input.key;

/**
 * Key codes taken from WinUser.h on Windows 7 x64 SP1.
 * 
 * @author b
 */
public class HardwareKeyIndex
{
	public static final int VK_BACK = 0x08;
	public static final int VK_TAB = 0x09;

	/*
	 * 0x0A - 0x0B : reserved
	 */

	public static final int VK_CLEAR = 0x0C;
	public static final int VK_RETURN = 0x0D;

	public static final int VK_SHIFT = 0x10;
	public static final int VK_CONTROL = 0x11;
	public static final int VK_MENU = 0x12;
	public static final int VK_PAUSE = 0x13;
	public static final int VK_CAPITAL = 0x14;

	public static final int VK_KANA = 0x15;
	public static final int VK_HANGEUL = 0x15; /* old name - should be here for compatibility */
	public static final int VK_HANGUL = 0x15;
	public static final int VK_JUNJA = 0x17;
	public static final int VK_FINAL = 0x18;
	public static final int VK_HANJA = 0x19;
	public static final int VK_KANJI = 0x19;

	public static final int VK_ESCAPE = 0x1B;

	public static final int VK_CONVERT = 0x1C;
	public static final int VK_NONCONVERT = 0x1D;
	public static final int VK_ACCEPT = 0x1E;
	public static final int VK_MODECHANGE = 0x1F;

	public static final int VK_SPACE = 0x20;
	public static final int VK_PRIOR = 0x21;
	public static final int VK_NEXT = 0x22;
	public static final int VK_END = 0x23;
	public static final int VK_HOME = 0x24;
	public static final int VK_LEFT = 0x25;
	public static final int VK_UP = 0x26;
	public static final int VK_RIGHT = 0x27;
	public static final int VK_DOWN = 0x28;
	public static final int VK_SELECT = 0x29;
	public static final int VK_PRINT = 0x2A;
	public static final int VK_EXECUTE = 0x2B;
	public static final int VK_SNAPSHOT = 0x2C;
	public static final int VK_INSERT = 0x2D;
	public static final int VK_DELETE = 0x2E;
	public static final int VK_HELP = 0x2F;

	public static final int VK_0 = 0x30;
	public static final int VK_1 = 0x31;
	public static final int VK_2 = 0x32;
	public static final int VK_3 = 0x33;
	public static final int VK_4 = 0x34;
	public static final int VK_5 = 0x35;
	public static final int VK_6 = 0x36;
	public static final int VK_7 = 0x37;
	public static final int VK_8 = 0x38;
	public static final int VK_9 = 0x39;

	public static final int VK_A = 0x41;
	public static final int VK_B = 0x42;
	public static final int VK_C = 0x43;
	public static final int VK_D = 0x44;
	public static final int VK_E = 0x45;
	public static final int VK_F = 0x46;
	public static final int VK_G = 0x47;
	public static final int VK_H = 0x48;
	public static final int VK_I = 0x49;
	public static final int VK_J = 0x4A;
	public static final int VK_K = 0x4B;
	public static final int VK_L = 0x4C;
	public static final int VK_M = 0x4D;
	public static final int VK_N = 0x4E;
	public static final int VK_O = 0x4F;
	public static final int VK_P = 0x50;
	public static final int VK_Q = 0x51;
	public static final int VK_R = 0x52;
	public static final int VK_S = 0x53;
	public static final int VK_T = 0x54;
	public static final int VK_U = 0x55;
	public static final int VK_V = 0x56;
	public static final int VK_W = 0x57;
	public static final int VK_X = 0x58;
	public static final int VK_Y = 0x59;
	public static final int VK_Z = 0x5A;

	public static final int VK_LWIN = 0x5B;
	public static final int VK_RWIN = 0x5C;
	public static final int VK_APPS = 0x5D;

	/*
	 * 0x5E : reserved
	 */

	public static final int VK_SLEEP = 0x5F;

	public static final int VK_NUMPAD0 = 0x60;
	public static final int VK_NUMPAD1 = 0x61;
	public static final int VK_NUMPAD2 = 0x62;
	public static final int VK_NUMPAD3 = 0x63;
	public static final int VK_NUMPAD4 = 0x64;
	public static final int VK_NUMPAD5 = 0x65;
	public static final int VK_NUMPAD6 = 0x66;
	public static final int VK_NUMPAD7 = 0x67;
	public static final int VK_NUMPAD8 = 0x68;
	public static final int VK_NUMPAD9 = 0x69;
	public static final int VK_MULTIPLY = 0x6A;
	public static final int VK_ADD = 0x6B;
	public static final int VK_SEPARATOR = 0x6C;
	public static final int VK_SUBTRACT = 0x6D;
	public static final int VK_DECIMAL = 0x6E;
	public static final int VK_DIVIDE = 0x6F;
	public static final int VK_F1 = 0x70;
	public static final int VK_F2 = 0x71;
	public static final int VK_F3 = 0x72;
	public static final int VK_F4 = 0x73;
	public static final int VK_F5 = 0x74;
	public static final int VK_F6 = 0x75;
	public static final int VK_F7 = 0x76;
	public static final int VK_F8 = 0x77;
	public static final int VK_F9 = 0x78;
	public static final int VK_F10 = 0x79;
	public static final int VK_F11 = 0x7A;
	public static final int VK_F12 = 0x7B;
	public static final int VK_F13 = 0x7C;
	public static final int VK_F14 = 0x7D;
	public static final int VK_F15 = 0x7E;
	public static final int VK_F16 = 0x7F;
	public static final int VK_F17 = 0x80;
	public static final int VK_F18 = 0x81;
	public static final int VK_F19 = 0x82;
	public static final int VK_F20 = 0x83;
	public static final int VK_F21 = 0x84;
	public static final int VK_F22 = 0x85;
	public static final int VK_F23 = 0x86;
	public static final int VK_F24 = 0x87;

	/*
	 * 0x88 - 0x8F : unassigned
	 */

	public static final int VK_NUMLOCK = 0x90;
	public static final int VK_SCROLL = 0x91;

	/*
	 * NEC PC-9800 kbd definitions
	 */
	public static final int VK_OEM_NEC_EQUAL = 0x92; // '=' key on numpad

	/*
	 * Fujitsu/OASYS kbd definitions
	 */
	public static final int VK_OEM_FJ_JISHO = 0x92; // 'Dictionary' key
	public static final int VK_OEM_FJ_MASSHOU = 0x93; // 'Unregister word' key
	public static final int VK_OEM_FJ_TOUROKU = 0x94; // 'Register word' key
	public static final int VK_OEM_FJ_LOYA = 0x95; // 'Left OYAYUBI' key
	public static final int VK_OEM_FJ_ROYA = 0x96; // 'Right OYAYUBI' key

	/*
	 * 0x97 - 0x9F : unassigned
	 */

	/*
	 * VK_L* & VK_R* - left and right Alt, Ctrl and Shift virtual keys. Used only as parameters to GetAsyncKeyState()
	 * and GetKeyState(). No other API or message will distinguish left and right keys in this way.
	 */
	public static final int VK_LSHIFT = 0xA0;
	public static final int VK_RSHIFT = 0xA1;
	public static final int VK_LCONTROL = 0xA2;
	public static final int VK_RCONTROL = 0xA3;
	public static final int VK_LMENU = 0xA4;
	public static final int VK_RMENU = 0xA5;

	// #if(_WIN32_WINNT >= 0x0500)
	public static final int VK_BROWSER_BACK = 0xA6;
	public static final int VK_BROWSER_FORWARD = 0xA7;
	public static final int VK_BROWSER_REFRESH = 0xA8;
	public static final int VK_BROWSER_STOP = 0xA9;
	public static final int VK_BROWSER_SEARCH = 0xAA;
	public static final int VK_BROWSER_FAVORITES = 0xAB;
	public static final int VK_BROWSER_HOME = 0xAC;

	public static final int VK_VOLUME_MUTE = 0xAD;
	public static final int VK_VOLUME_DOWN = 0xAE;
	public static final int VK_VOLUME_UP = 0xAF;
	public static final int VK_MEDIA_NEXT_TRACK = 0xB0;
	public static final int VK_MEDIA_PREV_TRACK = 0xB1;
	public static final int VK_MEDIA_STOP = 0xB2;
	public static final int VK_MEDIA_PLAY_PAUSE = 0xB3;
	public static final int VK_LAUNCH_MAIL = 0xB4;
	public static final int VK_LAUNCH_MEDIA_SELECT = 0xB5;
	public static final int VK_LAUNCH_APP1 = 0xB6;
	public static final int VK_LAUNCH_APP2 = 0xB7;

	// #endif /* _WIN32_WINNT >= 0x0500 */

	/*
	 * 0xB8 - 0xB9 : reserved
	 */

	public static final int VK_OEM_1 = 0xBA; // ';:' for US
	public static final int VK_OEM_PLUS = 0xBB; // '+' any country
	public static final int VK_OEM_COMMA = 0xBC; // ',' any country
	public static final int VK_OEM_MINUS = 0xBD; // '-' any country
	public static final int VK_OEM_PERIOD = 0xBE; // '.' any country
	public static final int VK_OEM_2 = 0xBF; // '/?' for US
	public static final int VK_OEM_3 = 0xC0; // '`~' for US

	/*
	 * 0xC1 - 0xD7 : reserved
	 */

	/*
	 * 0xD8 - 0xDA : unassigned
	 */

	public static final int VK_OEM_4 = 0xDB; // '[{' for US
	public static final int VK_OEM_5 = 0xDC; // '\|' for US
	public static final int VK_OEM_6 = 0xDD; // ']}' for US
	public static final int VK_OEM_7 = 0xDE; // ''"' for US
	public static final int VK_OEM_8 = 0xDF;

	/*
	 * 0xE0 : reserved
	 */

	/*
	 * Various extended or enhanced keyboards
	 */
	public static final int VK_OEM_AX = 0xE1; // 'AX' key on Japanese AX kbd
	public static final int VK_OEM_102 = 0xE2; // "<>" or "\|" on RT 102-key kbd.
	public static final int VK_ICO_HELP = 0xE3; // Help key on ICO
	public static final int VK_ICO_00 = 0xE4; // 00 key on ICO

	public static final int VK_ICO_CLEAR = 0xE6;

	public static HardwareKey lookup(int keyCode)
	{
		switch (keyCode)
		{
			case VK_BACK:
				return HardwareKey.BACK;
			case VK_TAB:
				return HardwareKey.TAB;

				/*
				 * 0x0A - 0x0B : reserved
				 */

			case VK_CLEAR:
				return HardwareKey.CLEAR;
			case VK_RETURN:
				return HardwareKey.RETURN;

			case VK_SHIFT:
				return HardwareKey.SHIFT;
			case VK_CONTROL:
				return HardwareKey.CONTROL;
			case VK_MENU:
				return HardwareKey.MENU;
			case VK_PAUSE:
				return HardwareKey.PAUSE;
			case VK_CAPITAL:
				return HardwareKey.CAPITAL;

			case VK_KANA:
				return HardwareKey.KANA;
			case VK_JUNJA:
				return HardwareKey.JUNJA;
			case VK_FINAL:
				return HardwareKey.FINAL;
			case VK_HANJA:
				return HardwareKey.HANJA;

			case VK_ESCAPE:
				return HardwareKey.ESCAPE;

			case VK_CONVERT:
				return HardwareKey.CONVERT;
			case VK_NONCONVERT:
				return HardwareKey.NONCONVERT;
			case VK_ACCEPT:
				return HardwareKey.ACCEPT;
			case VK_MODECHANGE:
				return HardwareKey.MODECHANGE;

			case VK_SPACE:
				return HardwareKey.SPACE;
			case VK_PRIOR:
				return HardwareKey.PRIOR;
			case VK_NEXT:
				return HardwareKey.NEXT;
			case VK_END:
				return HardwareKey.END;
			case VK_HOME:
				return HardwareKey.HOME;
			case VK_LEFT:
				return HardwareKey.LEFT;
			case VK_UP:
				return HardwareKey.UP;
			case VK_RIGHT:
				return HardwareKey.RIGHT;
			case VK_DOWN:
				return HardwareKey.DOWN;
			case VK_SELECT:
				return HardwareKey.SELECT;
			case VK_PRINT:
				return HardwareKey.PRINT;
			case VK_EXECUTE:
				return HardwareKey.EXECUTE;
			case VK_SNAPSHOT:
				return HardwareKey.SNAPSHOT;
			case VK_INSERT:
				return HardwareKey.INSERT;
			case VK_DELETE:
				return HardwareKey.DELETE;
			case VK_HELP:
				return HardwareKey.HELP;

			case VK_0:
				return HardwareKey.KEYBOARD0;
			case VK_1:
				return HardwareKey.KEYBOARD1;
			case VK_2:
				return HardwareKey.KEYBOARD2;
			case VK_3:
				return HardwareKey.KEYBOARD3;
			case VK_4:
				return HardwareKey.KEYBOARD4;
			case VK_5:
				return HardwareKey.KEYBOARD5;
			case VK_6:
				return HardwareKey.KEYBOARD6;
			case VK_7:
				return HardwareKey.KEYBOARD7;
			case VK_8:
				return HardwareKey.KEYBOARD8;
			case VK_9:
				return HardwareKey.KEYBOARD9;

			case VK_A:
				return HardwareKey.A;
			case VK_B:
				return HardwareKey.B;
			case VK_C:
				return HardwareKey.C;
			case VK_D:
				return HardwareKey.D;
			case VK_E:
				return HardwareKey.E;
			case VK_F:
				return HardwareKey.F;
			case VK_G:
				return HardwareKey.G;
			case VK_H:
				return HardwareKey.H;
			case VK_I:
				return HardwareKey.I;
			case VK_J:
				return HardwareKey.J;
			case VK_K:
				return HardwareKey.K;
			case VK_L:
				return HardwareKey.L;
			case VK_M:
				return HardwareKey.M;
			case VK_N:
				return HardwareKey.N;
			case VK_O:
				return HardwareKey.O;
			case VK_P:
				return HardwareKey.P;
			case VK_Q:
				return HardwareKey.Q;
			case VK_R:
				return HardwareKey.R;
			case VK_S:
				return HardwareKey.S;
			case VK_T:
				return HardwareKey.T;
			case VK_U:
				return HardwareKey.U;
			case VK_V:
				return HardwareKey.V;
			case VK_W:
				return HardwareKey.W;
			case VK_X:
				return HardwareKey.X;
			case VK_Y:
				return HardwareKey.Y;
			case VK_Z:
				return HardwareKey.Z;

			case VK_LWIN:
				return HardwareKey.LWIN;
			case VK_RWIN:
				return HardwareKey.RWIN;
			case VK_APPS:
				return HardwareKey.APPS;

				/*
				 * 0x5E : reserved
				 */

			case VK_SLEEP:
				return HardwareKey.SLEEP;

			case VK_NUMPAD0:
				return HardwareKey.NUMPAD0;
			case VK_NUMPAD1:
				return HardwareKey.NUMPAD1;
			case VK_NUMPAD2:
				return HardwareKey.NUMPAD2;
			case VK_NUMPAD3:
				return HardwareKey.NUMPAD3;
			case VK_NUMPAD4:
				return HardwareKey.NUMPAD4;
			case VK_NUMPAD5:
				return HardwareKey.NUMPAD5;
			case VK_NUMPAD6:
				return HardwareKey.NUMPAD6;
			case VK_NUMPAD7:
				return HardwareKey.NUMPAD7;
			case VK_NUMPAD8:
				return HardwareKey.NUMPAD8;
			case VK_NUMPAD9:
				return HardwareKey.NUMPAD9;
			case VK_MULTIPLY:
				return HardwareKey.MULTIPLY;
			case VK_ADD:
				return HardwareKey.ADD;
			case VK_SEPARATOR:
				return HardwareKey.SEPARATOR;
			case VK_SUBTRACT:
				return HardwareKey.SUBTRACT;
			case VK_DECIMAL:
				return HardwareKey.DECIMAL;
			case VK_DIVIDE:
				return HardwareKey.DIVIDE;
			case VK_F1:
				return HardwareKey.F1;
			case VK_F2:
				return HardwareKey.F2;
			case VK_F3:
				return HardwareKey.F3;
			case VK_F4:
				return HardwareKey.F4;
			case VK_F5:
				return HardwareKey.F5;
			case VK_F6:
				return HardwareKey.F6;
			case VK_F7:
				return HardwareKey.F7;
			case VK_F8:
				return HardwareKey.F8;
			case VK_F9:
				return HardwareKey.F9;
			case VK_F10:
				return HardwareKey.F10;
			case VK_F11:
				return HardwareKey.F11;
			case VK_F12:
				return HardwareKey.F12;
			case VK_F13:
				return HardwareKey.F13;
			case VK_F14:
				return HardwareKey.F14;
			case VK_F15:
				return HardwareKey.F15;
			case VK_F16:
				return HardwareKey.F16;
			case VK_F17:
				return HardwareKey.F17;
			case VK_F18:
				return HardwareKey.F18;
			case VK_F19:
				return HardwareKey.F19;
			case VK_F20:
				return HardwareKey.F20;
			case VK_F21:
				return HardwareKey.F21;
			case VK_F22:
				return HardwareKey.F22;
			case VK_F23:
				return HardwareKey.F23;
			case VK_F24:
				return HardwareKey.F24;

				/*
				 * 0x88 - 0x8F : unassigned
				 */

			case VK_NUMLOCK:
				return HardwareKey.NUMLOCK;
			case VK_SCROLL:
				return HardwareKey.SCROLL;

				/*
				 * Fujitsu/OASYS kbd definitions
				 */
			case VK_OEM_FJ_JISHO:
				return HardwareKey.OEM_FJ_JISHO; // 'Dictionary' key
			case VK_OEM_FJ_MASSHOU:
				return HardwareKey.OEM_FJ_MASSHOU; // 'Unregister word' key
			case VK_OEM_FJ_TOUROKU:
				return HardwareKey.OEM_FJ_TOUROKU; // 'Register word' key
			case VK_OEM_FJ_LOYA:
				return HardwareKey.OEM_FJ_LOYA; // 'Left OYAYUBI' key
			case VK_OEM_FJ_ROYA:
				return HardwareKey.OEM_FJ_ROYA; // 'Right OYAYUBI' key

				/*
				 * 0x97 - 0x9F : unassigned
				 */

				/*
				 * VK_L* & VK_R* - left and right Alt, Ctrl and Shift virtual keys. Used only as parameters to
				 * GetAsyncKeyState() and GetKeyState(). No other API or message will distinguish left and right keys in
				 * this way.
				 */
			case VK_LSHIFT:
				return HardwareKey.LSHIFT;
			case VK_RSHIFT:
				return HardwareKey.RSHIFT;
			case VK_LCONTROL:
				return HardwareKey.LCONTROL;
			case VK_RCONTROL:
				return HardwareKey.RCONTROL;
			case VK_LMENU:
				return HardwareKey.LMENU;
			case VK_RMENU:
				return HardwareKey.RMENU;

				// #if(_WIN32_WINNT >= 0x0500)
			case VK_BROWSER_BACK:
				return HardwareKey.BROWSER_BACK;
			case VK_BROWSER_FORWARD:
				return HardwareKey.BROWSER_FORWARD;
			case VK_BROWSER_REFRESH:
				return HardwareKey.BROWSER_REFRESH;
			case VK_BROWSER_STOP:
				return HardwareKey.BROWSER_STOP;
			case VK_BROWSER_SEARCH:
				return HardwareKey.BROWSER_SEARCH;
			case VK_BROWSER_FAVORITES:
				return HardwareKey.BROWSER_FAVORITES;
			case VK_BROWSER_HOME:
				return HardwareKey.BROWSER_HOME;

			case VK_VOLUME_MUTE:
				return HardwareKey.VOLUME_MUTE;
			case VK_VOLUME_DOWN:
				return HardwareKey.VOLUME_DOWN;
			case VK_VOLUME_UP:
				return HardwareKey.VOLUME_UP;
			case VK_MEDIA_NEXT_TRACK:
				return HardwareKey.MEDIA_NEXT_TRACK;
			case VK_MEDIA_PREV_TRACK:
				return HardwareKey.MEDIA_PREV_TRACK;
			case VK_MEDIA_STOP:
				return HardwareKey.MEDIA_STOP;
			case VK_MEDIA_PLAY_PAUSE:
				return HardwareKey.MEDIA_PLAY_PAUSE;
			case VK_LAUNCH_MAIL:
				return HardwareKey.LAUNCH_MAIL;
			case VK_LAUNCH_MEDIA_SELECT:
				return HardwareKey.LAUNCH_MEDIA_SELECT;
			case VK_LAUNCH_APP1:
				return HardwareKey.LAUNCH_APP1;
			case VK_LAUNCH_APP2:
				return HardwareKey.LAUNCH_APP2;

				// #endif /* _WIN32_WINNT >= 0x0500 */

				/*
				 * 0xB8 - 0xB9 : reserved
				 */

			case VK_OEM_1:
				return HardwareKey.SEMICOLON;// :' for US
			case VK_OEM_PLUS:
				return HardwareKey.OEM_PLUS; // '+' any country
			case VK_OEM_COMMA:
				return HardwareKey.OEM_COMMA; // ',' any country
			case VK_OEM_MINUS:
				return HardwareKey.OEM_MINUS; // '-' any country
			case VK_OEM_PERIOD:
				return HardwareKey.OEM_PERIOD; // '.' any country
			case VK_OEM_2:
				return HardwareKey.SLASH; // '/?' for US
			case VK_OEM_3:
				return HardwareKey.BACKTICK; // '`~' for US

				/*
				 * 0xC1 - 0xD7 : reserved
				 */

				/*
				 * 0xD8 - 0xDA : unassigned
				 */

			case VK_OEM_4:
				return HardwareKey.BRACKET_OPEN; // '[{' for US
			case VK_OEM_5:
				return HardwareKey.BACKSLASH; // '\|' for US
			case VK_OEM_6:
				return HardwareKey.BRACKET_CLOSED; // ']}' for US
			case VK_OEM_7:
				return HardwareKey.QUOTE; // ''"' for US
			case VK_OEM_8:
				return HardwareKey.BANG;

				/*
				 * 0xE0 : reserved
				 */

				/*
				 * Various extended or enhanced keyboards
				 */
			case VK_OEM_AX:
				return HardwareKey.OEM_AX; // 'AX' key on Japanese AX kbd
			case VK_OEM_102:
				return HardwareKey.OEM_102; // "<>" or "\|" on RT 102-key kbd.
			case VK_ICO_HELP:
				return HardwareKey.ICO_HELP; // Help key on ICO
			case VK_ICO_00:
				return HardwareKey.ICO_00; // 00 key on ICO

			case VK_ICO_CLEAR:
				return HardwareKey.ICO_CLEAR;
		}

		throw new IllegalArgumentException("Unknown key code " + keyCode);
	}
}