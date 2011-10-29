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

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public enum HardwareKey
{
	BACK(HardwareKeyIndex.VK_BACK),
	TAB(HardwareKeyIndex.VK_TAB),
	CLEAR(HardwareKeyIndex.VK_CLEAR),
	RETURN(HardwareKeyIndex.VK_RETURN),
	SHIFT(HardwareKeyIndex.VK_SHIFT),
	CONTROL(HardwareKeyIndex.VK_CONTROL),
	MENU(HardwareKeyIndex.VK_MENU),
	PAUSE(HardwareKeyIndex.VK_PAUSE),
	CAPITAL(HardwareKeyIndex.VK_CAPITAL),
	KANA(HardwareKeyIndex.VK_KANA),
	HANGEUL(HardwareKeyIndex.VK_HANGEUL),
	HANGUL(HardwareKeyIndex.VK_HANGUL),
	JUNJA(HardwareKeyIndex.VK_JUNJA),
	FINAL(HardwareKeyIndex.VK_FINAL),
	HANJA(HardwareKeyIndex.VK_HANJA),
	KANJI(HardwareKeyIndex.VK_KANJI),
	ESCAPE(HardwareKeyIndex.VK_ESCAPE),
	CONVERT(HardwareKeyIndex.VK_CONVERT),
	NONCONVERT(HardwareKeyIndex.VK_NONCONVERT),
	ACCEPT(HardwareKeyIndex.VK_ACCEPT),
	MODECHANGE(HardwareKeyIndex.VK_MODECHANGE),
	SPACE(HardwareKeyIndex.VK_SPACE),
	PRIOR(HardwareKeyIndex.VK_PRIOR),
	NEXT(HardwareKeyIndex.VK_NEXT),
	END(HardwareKeyIndex.VK_END),
	HOME(HardwareKeyIndex.VK_HOME),
	LEFT(HardwareKeyIndex.VK_LEFT),
	UP(HardwareKeyIndex.VK_UP),
	RIGHT(HardwareKeyIndex.VK_RIGHT),
	DOWN(HardwareKeyIndex.VK_DOWN),
	SELECT(HardwareKeyIndex.VK_SELECT),
	PRINT(HardwareKeyIndex.VK_PRINT),
	EXECUTE(HardwareKeyIndex.VK_EXECUTE),
	SNAPSHOT(HardwareKeyIndex.VK_SNAPSHOT),
	INSERT(HardwareKeyIndex.VK_INSERT),
	DELETE(HardwareKeyIndex.VK_DELETE),
	HELP(HardwareKeyIndex.VK_HELP),
	KEYBOARD0(HardwareKeyIndex.VK_0),
	KEYBOARD1(HardwareKeyIndex.VK_1),
	KEYBOARD2(HardwareKeyIndex.VK_2),
	KEYBOARD3(HardwareKeyIndex.VK_3),
	KEYBOARD4(HardwareKeyIndex.VK_4),
	KEYBOARD5(HardwareKeyIndex.VK_5),
	KEYBOARD6(HardwareKeyIndex.VK_6),
	KEYBOARD7(HardwareKeyIndex.VK_7),
	KEYBOARD8(HardwareKeyIndex.VK_8),
	KEYBOARD9(HardwareKeyIndex.VK_9),
	A(HardwareKeyIndex.VK_A),
	B(HardwareKeyIndex.VK_B),
	C(HardwareKeyIndex.VK_C),
	D(HardwareKeyIndex.VK_D),
	E(HardwareKeyIndex.VK_E),
	F(HardwareKeyIndex.VK_F),
	G(HardwareKeyIndex.VK_G),
	H(HardwareKeyIndex.VK_H),
	I(HardwareKeyIndex.VK_I),
	J(HardwareKeyIndex.VK_J),
	K(HardwareKeyIndex.VK_K),
	L(HardwareKeyIndex.VK_L),
	M(HardwareKeyIndex.VK_M),
	N(HardwareKeyIndex.VK_N),
	O(HardwareKeyIndex.VK_O),
	P(HardwareKeyIndex.VK_P),
	Q(HardwareKeyIndex.VK_Q),
	R(HardwareKeyIndex.VK_R),
	S(HardwareKeyIndex.VK_S),
	T(HardwareKeyIndex.VK_T),
	U(HardwareKeyIndex.VK_U),
	V(HardwareKeyIndex.VK_V),
	W(HardwareKeyIndex.VK_W),
	X(HardwareKeyIndex.VK_X),
	Y(HardwareKeyIndex.VK_Y),
	Z(HardwareKeyIndex.VK_Z),
	LWIN(HardwareKeyIndex.VK_LWIN),
	RWIN(HardwareKeyIndex.VK_RWIN),
	APPS(HardwareKeyIndex.VK_APPS),
	SLEEP(HardwareKeyIndex.VK_SLEEP),
	NUMPAD0(HardwareKeyIndex.VK_NUMPAD0),
	NUMPAD1(HardwareKeyIndex.VK_NUMPAD1),
	NUMPAD2(HardwareKeyIndex.VK_NUMPAD2),
	NUMPAD3(HardwareKeyIndex.VK_NUMPAD3),
	NUMPAD4(HardwareKeyIndex.VK_NUMPAD4),
	NUMPAD5(HardwareKeyIndex.VK_NUMPAD5),
	NUMPAD6(HardwareKeyIndex.VK_NUMPAD6),
	NUMPAD7(HardwareKeyIndex.VK_NUMPAD7),
	NUMPAD8(HardwareKeyIndex.VK_NUMPAD8),
	NUMPAD9(HardwareKeyIndex.VK_NUMPAD9),
	MULTIPLY(HardwareKeyIndex.VK_MULTIPLY),
	ADD(HardwareKeyIndex.VK_ADD),
	SEPARATOR(HardwareKeyIndex.VK_SEPARATOR),
	SUBTRACT(HardwareKeyIndex.VK_SUBTRACT),
	DECIMAL(HardwareKeyIndex.VK_DECIMAL),
	DIVIDE(HardwareKeyIndex.VK_DIVIDE),
	F1(HardwareKeyIndex.VK_F1),
	F2(HardwareKeyIndex.VK_F2),
	F3(HardwareKeyIndex.VK_F3),
	F4(HardwareKeyIndex.VK_F4),
	F5(HardwareKeyIndex.VK_F5),
	F6(HardwareKeyIndex.VK_F6),
	F7(HardwareKeyIndex.VK_F7),
	F8(HardwareKeyIndex.VK_F8),
	F9(HardwareKeyIndex.VK_F9),
	F10(HardwareKeyIndex.VK_F10),
	F11(HardwareKeyIndex.VK_F11),
	F12(HardwareKeyIndex.VK_F12),
	F13(HardwareKeyIndex.VK_F13),
	F14(HardwareKeyIndex.VK_F14),
	F15(HardwareKeyIndex.VK_F15),
	F16(HardwareKeyIndex.VK_F16),
	F17(HardwareKeyIndex.VK_F17),
	F18(HardwareKeyIndex.VK_F18),
	F19(HardwareKeyIndex.VK_F19),
	F20(HardwareKeyIndex.VK_F20),
	F21(HardwareKeyIndex.VK_F21),
	F22(HardwareKeyIndex.VK_F22),
	F23(HardwareKeyIndex.VK_F23),
	F24(HardwareKeyIndex.VK_F24),
	NUMLOCK(HardwareKeyIndex.VK_NUMLOCK),
	SCROLL(HardwareKeyIndex.VK_SCROLL),
	OEM_NEC_EQUAL(HardwareKeyIndex.VK_OEM_NEC_EQUAL),
	OEM_FJ_JISHO(HardwareKeyIndex.VK_OEM_FJ_JISHO),
	OEM_FJ_MASSHOU(HardwareKeyIndex.VK_OEM_FJ_MASSHOU),
	OEM_FJ_TOUROKU(HardwareKeyIndex.VK_OEM_FJ_TOUROKU),
	OEM_FJ_LOYA(HardwareKeyIndex.VK_OEM_FJ_LOYA),
	OEM_FJ_ROYA(HardwareKeyIndex.VK_OEM_FJ_ROYA),
	LSHIFT(HardwareKeyIndex.VK_LSHIFT),
	RSHIFT(HardwareKeyIndex.VK_RSHIFT),
	LCONTROL(HardwareKeyIndex.VK_LCONTROL),
	RCONTROL(HardwareKeyIndex.VK_RCONTROL),
	LMENU(HardwareKeyIndex.VK_LMENU),
	RMENU(HardwareKeyIndex.VK_RMENU),
	BROWSER_BACK(HardwareKeyIndex.VK_BROWSER_BACK),
	BROWSER_FORWARD(HardwareKeyIndex.VK_BROWSER_FORWARD),
	BROWSER_REFRESH(HardwareKeyIndex.VK_BROWSER_REFRESH),
	BROWSER_STOP(HardwareKeyIndex.VK_BROWSER_STOP),
	BROWSER_SEARCH(HardwareKeyIndex.VK_BROWSER_SEARCH),
	BROWSER_FAVORITES(HardwareKeyIndex.VK_BROWSER_FAVORITES),
	BROWSER_HOME(HardwareKeyIndex.VK_BROWSER_HOME),
	VOLUME_MUTE(HardwareKeyIndex.VK_VOLUME_MUTE),
	VOLUME_DOWN(HardwareKeyIndex.VK_VOLUME_DOWN),
	VOLUME_UP(HardwareKeyIndex.VK_VOLUME_UP),
	MEDIA_NEXT_TRACK(HardwareKeyIndex.VK_MEDIA_NEXT_TRACK),
	MEDIA_PREV_TRACK(HardwareKeyIndex.VK_MEDIA_PREV_TRACK),
	MEDIA_STOP(HardwareKeyIndex.VK_MEDIA_STOP),
	MEDIA_PLAY_PAUSE(HardwareKeyIndex.VK_MEDIA_PLAY_PAUSE),
	LAUNCH_MAIL(HardwareKeyIndex.VK_LAUNCH_MAIL),
	LAUNCH_MEDIA_SELECT(HardwareKeyIndex.VK_LAUNCH_MEDIA_SELECT),
	LAUNCH_APP1(HardwareKeyIndex.VK_LAUNCH_APP1),
	LAUNCH_APP2(HardwareKeyIndex.VK_LAUNCH_APP2),
	SEMICOLON(HardwareKeyIndex.VK_OEM_1),
	OEM_PLUS(HardwareKeyIndex.VK_OEM_PLUS),
	OEM_COMMA(HardwareKeyIndex.VK_OEM_COMMA),
	OEM_MINUS(HardwareKeyIndex.VK_OEM_MINUS),
	OEM_PERIOD(HardwareKeyIndex.VK_OEM_PERIOD),
	SLASH(HardwareKeyIndex.VK_OEM_2),
	BACKTICK(HardwareKeyIndex.VK_OEM_3),
	BRACKET_OPEN(HardwareKeyIndex.VK_OEM_4),
	BACKSLASH(HardwareKeyIndex.VK_OEM_5),
	BRACKET_CLOSED(HardwareKeyIndex.VK_OEM_6),
	QUOTE(HardwareKeyIndex.VK_OEM_7),
	BANG(HardwareKeyIndex.VK_OEM_8),
	OEM_AX(HardwareKeyIndex.VK_OEM_AX),
	OEM_102(HardwareKeyIndex.VK_OEM_102),
	ICO_HELP(HardwareKeyIndex.VK_ICO_HELP),
	ICO_00(HardwareKeyIndex.VK_ICO_00),
	ICO_CLEAR(HardwareKeyIndex.VK_ICO_CLEAR);

	public final int keyCode;

	private HardwareKey(int keyCode)
	{
		this.keyCode = keyCode;
	}
}
