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
package org.hawkinssoftware.azia.input.key;

import java.util.EnumSet;
import java.util.Set;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public enum HardwareKey
{
	BACK(HardwareKeyIndex.VK_BACK, LogicalKey.BACK),
	TAB(HardwareKeyIndex.VK_TAB, LogicalKey.TAB),
	CLEAR(HardwareKeyIndex.VK_CLEAR, LogicalKey.CLEAR),
	RETURN(HardwareKeyIndex.VK_RETURN, LogicalKey.RETURN),
	SHIFT(HardwareKeyIndex.VK_SHIFT, LogicalKey.SHIFT),
	CONTROL(HardwareKeyIndex.VK_CONTROL, LogicalKey.CONTROL),
	MENU(HardwareKeyIndex.VK_MENU, LogicalKey.MENU),
	PAUSE(HardwareKeyIndex.VK_PAUSE, LogicalKey.PAUSE),
	CAPITAL(HardwareKeyIndex.VK_CAPITAL, LogicalKey.CAPITAL),
	KANA(HardwareKeyIndex.VK_KANA, LogicalKey.KANA),
	HANGEUL(HardwareKeyIndex.VK_HANGEUL, LogicalKey.HANGEUL),
	HANGUL(HardwareKeyIndex.VK_HANGUL, LogicalKey.HANGUL),
	JUNJA(HardwareKeyIndex.VK_JUNJA, LogicalKey.JUNJA),
	FINAL(HardwareKeyIndex.VK_FINAL, LogicalKey.FINAL),
	HANJA(HardwareKeyIndex.VK_HANJA, LogicalKey.HANJA),
	KANJI(HardwareKeyIndex.VK_KANJI, LogicalKey.KANJI),
	ESCAPE(HardwareKeyIndex.VK_ESCAPE, LogicalKey.ESCAPE),
	CONVERT(HardwareKeyIndex.VK_CONVERT, LogicalKey.CONVERT),
	NONCONVERT(HardwareKeyIndex.VK_NONCONVERT, LogicalKey.NONCONVERT),
	ACCEPT(HardwareKeyIndex.VK_ACCEPT, LogicalKey.ACCEPT),
	MODECHANGE(HardwareKeyIndex.VK_MODECHANGE, LogicalKey.MODECHANGE),
	SPACE(HardwareKeyIndex.VK_SPACE, LogicalKey.SPACE),
	PRIOR(HardwareKeyIndex.VK_PRIOR, LogicalKey.PRIOR),
	NEXT(HardwareKeyIndex.VK_NEXT, LogicalKey.NEXT),
	END(HardwareKeyIndex.VK_END, LogicalKey.END),
	HOME(HardwareKeyIndex.VK_HOME, LogicalKey.HOME),
	LEFT(HardwareKeyIndex.VK_LEFT, LogicalKey.LEFT),
	UP(HardwareKeyIndex.VK_UP, LogicalKey.UP),
	RIGHT(HardwareKeyIndex.VK_RIGHT, LogicalKey.RIGHT),
	DOWN(HardwareKeyIndex.VK_DOWN, LogicalKey.DOWN),
	SELECT(HardwareKeyIndex.VK_SELECT, LogicalKey.SELECT),
	PRINT(HardwareKeyIndex.VK_PRINT, LogicalKey.PRINT),
	EXECUTE(HardwareKeyIndex.VK_EXECUTE, LogicalKey.EXECUTE),
	SNAPSHOT(HardwareKeyIndex.VK_SNAPSHOT, LogicalKey.SNAPSHOT),
	INSERT(HardwareKeyIndex.VK_INSERT, LogicalKey.INSERT),
	DELETE(HardwareKeyIndex.VK_DELETE, LogicalKey.DELETE),
	HELP(HardwareKeyIndex.VK_HELP, LogicalKey.HELP),
	KEYBOARD0(HardwareKeyIndex.VK_0, LogicalKey.NUMBER0),
	KEYBOARD1(HardwareKeyIndex.VK_1, LogicalKey.NUMBER1),
	KEYBOARD2(HardwareKeyIndex.VK_2, LogicalKey.NUMBER2),
	KEYBOARD3(HardwareKeyIndex.VK_3, LogicalKey.NUMBER3),
	KEYBOARD4(HardwareKeyIndex.VK_4, LogicalKey.NUMBER4),
	KEYBOARD5(HardwareKeyIndex.VK_5, LogicalKey.NUMBER5),
	KEYBOARD6(HardwareKeyIndex.VK_6, LogicalKey.NUMBER6),
	KEYBOARD7(HardwareKeyIndex.VK_7, LogicalKey.NUMBER7),
	KEYBOARD8(HardwareKeyIndex.VK_8, LogicalKey.NUMBER8),
	KEYBOARD9(HardwareKeyIndex.VK_9, LogicalKey.NUMBER9),
	A(HardwareKeyIndex.VK_A, LogicalKey.A),
	B(HardwareKeyIndex.VK_B, LogicalKey.B),
	C(HardwareKeyIndex.VK_C, LogicalKey.C),
	D(HardwareKeyIndex.VK_D, LogicalKey.D),
	E(HardwareKeyIndex.VK_E, LogicalKey.E),
	F(HardwareKeyIndex.VK_F, LogicalKey.F),
	G(HardwareKeyIndex.VK_G, LogicalKey.G),
	H(HardwareKeyIndex.VK_H, LogicalKey.H),
	I(HardwareKeyIndex.VK_I, LogicalKey.I),
	J(HardwareKeyIndex.VK_J, LogicalKey.J),
	K(HardwareKeyIndex.VK_K, LogicalKey.K),
	L(HardwareKeyIndex.VK_L, LogicalKey.L),
	M(HardwareKeyIndex.VK_M, LogicalKey.M),
	N(HardwareKeyIndex.VK_N, LogicalKey.N),
	O(HardwareKeyIndex.VK_O, LogicalKey.O),
	P(HardwareKeyIndex.VK_P, LogicalKey.P),
	Q(HardwareKeyIndex.VK_Q, LogicalKey.Q),
	R(HardwareKeyIndex.VK_R, LogicalKey.R),
	S(HardwareKeyIndex.VK_S, LogicalKey.S),
	T(HardwareKeyIndex.VK_T, LogicalKey.T),
	U(HardwareKeyIndex.VK_U, LogicalKey.U),
	V(HardwareKeyIndex.VK_V, LogicalKey.V),
	W(HardwareKeyIndex.VK_W, LogicalKey.W),
	X(HardwareKeyIndex.VK_X, LogicalKey.X),
	Y(HardwareKeyIndex.VK_Y, LogicalKey.Y),
	Z(HardwareKeyIndex.VK_Z, LogicalKey.Z),
	LWIN(HardwareKeyIndex.VK_LWIN, LogicalKey.WIN),
	RWIN(HardwareKeyIndex.VK_RWIN, LogicalKey.WIN),
	APPS(HardwareKeyIndex.VK_APPS, LogicalKey.APPS),
	SLEEP(HardwareKeyIndex.VK_SLEEP, LogicalKey.SLEEP),
	NUMPAD0(HardwareKeyIndex.VK_NUMPAD0, LogicalKey.NUMBER0),
	NUMPAD1(HardwareKeyIndex.VK_NUMPAD1, LogicalKey.NUMBER1),
	NUMPAD2(HardwareKeyIndex.VK_NUMPAD2, LogicalKey.NUMBER2),
	NUMPAD3(HardwareKeyIndex.VK_NUMPAD3, LogicalKey.NUMBER3),
	NUMPAD4(HardwareKeyIndex.VK_NUMPAD4, LogicalKey.NUMBER4),
	NUMPAD5(HardwareKeyIndex.VK_NUMPAD5, LogicalKey.NUMBER5),
	NUMPAD6(HardwareKeyIndex.VK_NUMPAD6, LogicalKey.NUMBER6),
	NUMPAD7(HardwareKeyIndex.VK_NUMPAD7, LogicalKey.NUMBER7),
	NUMPAD8(HardwareKeyIndex.VK_NUMPAD8, LogicalKey.NUMBER8),
	NUMPAD9(HardwareKeyIndex.VK_NUMPAD9, LogicalKey.NUMBER9),
	MULTIPLY(HardwareKeyIndex.VK_MULTIPLY, LogicalKey.MULTIPLY),
	ADD(HardwareKeyIndex.VK_ADD, LogicalKey.PLUS),
	SEPARATOR(HardwareKeyIndex.VK_SEPARATOR, LogicalKey.SEPARATOR),
	SUBTRACT(HardwareKeyIndex.VK_SUBTRACT, LogicalKey.MINUS),
	DECIMAL(HardwareKeyIndex.VK_DECIMAL, LogicalKey.DECIMAL),
	DIVIDE(HardwareKeyIndex.VK_DIVIDE, LogicalKey.DIVIDE),
	F1(HardwareKeyIndex.VK_F1, LogicalKey.F1),
	F2(HardwareKeyIndex.VK_F2, LogicalKey.F2),
	F3(HardwareKeyIndex.VK_F3, LogicalKey.F3),
	F4(HardwareKeyIndex.VK_F4, LogicalKey.F4),
	F5(HardwareKeyIndex.VK_F5, LogicalKey.F5),
	F6(HardwareKeyIndex.VK_F6, LogicalKey.F6),
	F7(HardwareKeyIndex.VK_F7, LogicalKey.F7),
	F8(HardwareKeyIndex.VK_F8, LogicalKey.F8),
	F9(HardwareKeyIndex.VK_F9, LogicalKey.F9),
	F10(HardwareKeyIndex.VK_F10, LogicalKey.F10),
	F11(HardwareKeyIndex.VK_F11, LogicalKey.F11),
	F12(HardwareKeyIndex.VK_F12, LogicalKey.F12),
	F13(HardwareKeyIndex.VK_F13, LogicalKey.F13),
	F14(HardwareKeyIndex.VK_F14, LogicalKey.F14),
	F15(HardwareKeyIndex.VK_F15, LogicalKey.F15),
	F16(HardwareKeyIndex.VK_F16, LogicalKey.F16),
	F17(HardwareKeyIndex.VK_F17, LogicalKey.F17),
	F18(HardwareKeyIndex.VK_F18, LogicalKey.F18),
	F19(HardwareKeyIndex.VK_F19, LogicalKey.F19),
	F20(HardwareKeyIndex.VK_F20, LogicalKey.F20),
	F21(HardwareKeyIndex.VK_F21, LogicalKey.F21),
	F22(HardwareKeyIndex.VK_F22, LogicalKey.F22),
	F23(HardwareKeyIndex.VK_F23, LogicalKey.F23),
	F24(HardwareKeyIndex.VK_F24, LogicalKey.F24),
	NUMLOCK(HardwareKeyIndex.VK_NUMLOCK, LogicalKey.NUMLOCK),
	SCROLL(HardwareKeyIndex.VK_SCROLL, LogicalKey.SCROLL),
	OEM_NEC_EQUAL(HardwareKeyIndex.VK_OEM_NEC_EQUAL, LogicalKey.NEC_EQUAL),
	OEM_FJ_JISHO(HardwareKeyIndex.VK_OEM_FJ_JISHO, LogicalKey.FJ_JISHO),
	OEM_FJ_MASSHOU(HardwareKeyIndex.VK_OEM_FJ_MASSHOU, LogicalKey.FJ_MASSHOU),
	OEM_FJ_TOUROKU(HardwareKeyIndex.VK_OEM_FJ_TOUROKU, LogicalKey.FJ_TOUROKU),
	OEM_FJ_LOYA(HardwareKeyIndex.VK_OEM_FJ_LOYA, LogicalKey.FJ_LOYA),
	OEM_FJ_ROYA(HardwareKeyIndex.VK_OEM_FJ_ROYA, LogicalKey.FJ_ROYA),
	LSHIFT(HardwareKeyIndex.VK_LSHIFT, LogicalKey.SHIFT),
	RSHIFT(HardwareKeyIndex.VK_RSHIFT, LogicalKey.SHIFT),
	LCONTROL(HardwareKeyIndex.VK_LCONTROL, LogicalKey.CONTROL),
	RCONTROL(HardwareKeyIndex.VK_RCONTROL, LogicalKey.CONTROL),
	LMENU(HardwareKeyIndex.VK_LMENU, LogicalKey.MENU),
	RMENU(HardwareKeyIndex.VK_RMENU, LogicalKey.MENU),
	BROWSER_BACK(HardwareKeyIndex.VK_BROWSER_BACK, LogicalKey.BROWSER_BACK),
	BROWSER_FORWARD(HardwareKeyIndex.VK_BROWSER_FORWARD, LogicalKey.BROWSER_FORWARD),
	BROWSER_REFRESH(HardwareKeyIndex.VK_BROWSER_REFRESH, LogicalKey.BROWSER_REFRESH),
	BROWSER_STOP(HardwareKeyIndex.VK_BROWSER_STOP, LogicalKey.BROWSER_STOP),
	BROWSER_SEARCH(HardwareKeyIndex.VK_BROWSER_SEARCH, LogicalKey.BROWSER_SEARCH),
	BROWSER_FAVORITES(HardwareKeyIndex.VK_BROWSER_FAVORITES, LogicalKey.BROWSER_FAVORITES),
	BROWSER_HOME(HardwareKeyIndex.VK_BROWSER_HOME, LogicalKey.BROWSER_HOME),
	VOLUME_MUTE(HardwareKeyIndex.VK_VOLUME_MUTE, LogicalKey.VOLUME_MUTE),
	VOLUME_DOWN(HardwareKeyIndex.VK_VOLUME_DOWN, LogicalKey.VOLUME_DOWN),
	VOLUME_UP(HardwareKeyIndex.VK_VOLUME_UP, LogicalKey.VOLUME_UP),
	MEDIA_NEXT_TRACK(HardwareKeyIndex.VK_MEDIA_NEXT_TRACK, LogicalKey.MEDIA_NEXT_TRACK),
	MEDIA_PREV_TRACK(HardwareKeyIndex.VK_MEDIA_PREV_TRACK, LogicalKey.MEDIA_PREV_TRACK),
	MEDIA_STOP(HardwareKeyIndex.VK_MEDIA_STOP, LogicalKey.MEDIA_STOP),
	MEDIA_PLAY_PAUSE(HardwareKeyIndex.VK_MEDIA_PLAY_PAUSE, LogicalKey.MEDIA_PLAY_PAUSE),
	LAUNCH_MAIL(HardwareKeyIndex.VK_LAUNCH_MAIL, LogicalKey.LAUNCH_MAIL),
	LAUNCH_MEDIA_SELECT(HardwareKeyIndex.VK_LAUNCH_MEDIA_SELECT, LogicalKey.LAUNCH_MEDIA_SELECT),
	LAUNCH_APP1(HardwareKeyIndex.VK_LAUNCH_APP1, LogicalKey.LAUNCH_APP1),
	LAUNCH_APP2(HardwareKeyIndex.VK_LAUNCH_APP2, LogicalKey.LAUNCH_APP2),
	SEMICOLON(HardwareKeyIndex.VK_OEM_1, LogicalKey.SEMICOLON),
	OEM_PLUS(HardwareKeyIndex.VK_OEM_PLUS, LogicalKey.PLUS),
	OEM_COMMA(HardwareKeyIndex.VK_OEM_COMMA, LogicalKey.COMMA),
	OEM_MINUS(HardwareKeyIndex.VK_OEM_MINUS, LogicalKey.MINUS),
	OEM_PERIOD(HardwareKeyIndex.VK_OEM_PERIOD, LogicalKey.DECIMAL),
	SLASH(HardwareKeyIndex.VK_OEM_2, LogicalKey.DIVIDE),
	BACKTICK(HardwareKeyIndex.VK_OEM_3, LogicalKey.BACKTICK),
	BRACKET_OPEN(HardwareKeyIndex.VK_OEM_4, LogicalKey.BRACKET_OPEN),
	BACKSLASH(HardwareKeyIndex.VK_OEM_5, LogicalKey.BACKSLASH),
	BRACKET_CLOSED(HardwareKeyIndex.VK_OEM_6, LogicalKey.BRACKET_CLOSED),
	QUOTE(HardwareKeyIndex.VK_OEM_7, LogicalKey.QUOTE),
	BANG(HardwareKeyIndex.VK_OEM_8, LogicalKey.BANG),
	OEM_AX(HardwareKeyIndex.VK_OEM_AX, LogicalKey.AX),
	OEM_102(HardwareKeyIndex.VK_OEM_102, LogicalKey.OEM_102),
	ICO_HELP(HardwareKeyIndex.VK_ICO_HELP, LogicalKey.ICO_HELP),
	ICO_00(HardwareKeyIndex.VK_ICO_00, LogicalKey.ICO_00),
	ICO_CLEAR(HardwareKeyIndex.VK_ICO_CLEAR, LogicalKey.ICO_CLEAR);

	public final int keyCode;
	public final LogicalKey logicalKey;

	private HardwareKey(int keyCode, LogicalKey logicalKey)
	{
		this.keyCode = keyCode;
		this.logicalKey = logicalKey;
	}
	
	public static void initialize()
	{
		for (HardwareKey key : HardwareKey.values())
		{
			key.logicalKey.assignKey(key);
		}
	}

	public static Set<LogicalKey> getLogicalEquivalent(Set<HardwareKey> hardwareKeys)
	{
		Set<LogicalKey> logicalKeys = EnumSet.noneOf(LogicalKey.class);
		for (HardwareKey hardwareKey : hardwareKeys)
		{
			logicalKeys.add(hardwareKey.logicalKey);
		}
		return logicalKeys;
	}
}
