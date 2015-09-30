package com.pkw.test;

import java.awt.Graphics2D;

import com.pkw.game.swing.DelaySwingGame;
import com.pkw.game.swing.util.TextGraphics;
import com.pkw.units.FramesPerSecond;
import com.pkw.util.PerSecondCounter;

public class TestDelaySwingGame extends DelaySwingGame {
	private static final FramesPerSecond TARGET_FPS = FramesPerSecond
			.ofValue(60);
	private PerSecondCounter fpsCounter;

	protected TestDelaySwingGame() {
		super("TestAFAPSwingGame", 480, 320, TARGET_FPS);
		fpsCounter = PerSecondCounter.create();
	}

	@Override
	public void beforeStart() {
	}

	@Override
	public void afterStart() {
	}

	@Override
	public void step() {
	}

	@Override
	public void draw(Graphics2D graphics) {
		fpsCounter.count();
		graphics.drawString("FPS: " + fpsCounter.current(), 32, 32);
		TextGraphics.drawString(graphics,
				"This game engine 'Delays' after step and draw\n"
						+ "events complete to reach the desired FPS.\n"
						+ "Desired FPS: " + TARGET_FPS, 32, 64);
	}

	@Override
	public void onStop() {
	}

	@Override
	public void beforeEnd() {
	}

	@Override
	public void afterEnd() {
	}

	public static void main(String[] args) {
		(new TestDelaySwingGame()).run();
	}
}
