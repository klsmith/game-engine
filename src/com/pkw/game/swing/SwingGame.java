package com.pkw.game.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pkw.game.Game;
import com.pkw.game.swing.util.ExpandedGraphics;

public abstract class SwingGame implements Game {

	private boolean isRunning;
	private JFrame frame;

	protected SwingGame(String title, int width, int height) {
		isRunning = false;
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				stop();
			}
		});
		frame.setContentPane(new JPanel() {
			private static final long serialVersionUID = -1738407937098886469L;

			@Override
			public void paint(Graphics graphics) {
				draw(ExpandedGraphics.from((Graphics2D) graphics));
			}
		});
		frame.setVisible(true);
	}

	public abstract void draw(ExpandedGraphics graphics);

	final public JFrame frame() {
		return frame;
	}

	@Override
	final public boolean isRunning() {
		return isRunning;
	}

	@Override
	final public void stop() {
		isRunning = false;
		onStop();
	}

	public abstract void onStop();

	@Override
	final public void onStart() {
		beforeStart();
		isRunning = true;
		afterStart();
	}

	public abstract void beforeStart();

	public abstract void afterStart();

	@Override
	final public void onEnd() {
		beforeEnd();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		afterEnd();
	}

	public abstract void beforeEnd();

	public abstract void afterEnd();

}
