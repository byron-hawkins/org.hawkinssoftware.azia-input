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
package org.hawkinssoftware.azia.input.test;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hawkinssoftware.azia.input.KeyboardInputEvent;
import org.hawkinssoftware.azia.input.MouseInputEvent;
import org.hawkinssoftware.azia.input.NativeInputSpool;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class NativeInputTest
{
	
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	private static class SpoolSpy extends JFrame implements NativeInputSpool.Listener
	{
		private final JPanel contentPanel = new JPanel();
		private final JLabel positionLabel = new JLabel("(-,-)");
		private final JLabel velocityLabel = new JLabel("@-");
		private final JLabel buttonsLabel = new JLabel("[RIGHT_BUTTON, BUTTON]");
		private final JLabel changesLabel = new JLabel("[RIGHT_BUTTON, RIGHT_BUTTON, RIGHT_BUTTON]");

		SpoolSpy()
		{
			super("Spool Spy");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setAlwaysOnTop(true);
		}

		void assemble()
		{
			contentPanel.setLayout(new GridLayout(4, 1));
			contentPanel.add(positionLabel);
			contentPanel.add(velocityLabel);
			contentPanel.add(buttonsLabel);
			contentPanel.add(changesLabel);
			add(contentPanel);
			pack();
		}

		@Override
		public void keyboardStateChanged(KeyboardInputEvent event)
		{
		}

		@Override
		public void mouseStateChanged(MouseInputEvent event)
		{
			positionLabel.setText("(" + event.x() + ", " + event.y() + ")");
			velocityLabel.setText("@" + event.velocity());
			buttonsLabel.setText(event.buttonsDown().toString());
			changesLabel.setText(event.changes().toString());
		}
	}

	public static void main(String[] args)
	{
		try
		{
			NativeInputSpool spool = new NativeInputSpool();

			SpoolSpy spy = new SpoolSpy();
			spy.assemble();
			spool.addListener(spy);
			spy.setVisible(true);

			spool.start();

			synchronized (spool)
			{
				spool.wait();
			}
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
}
