package com.pkw.test;

import com.pkw.game.swing.DelaySwingGame;
import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.units.FramesPerSecond;
import com.pkw.util.FramesPerSecondCounter;

public class TestDelaySwingGame extends DelaySwingGame {
	private static final FramesPerSecond TARGET_FPS = FramesPerSecond
			.ofValue(60);
	private FramesPerSecondCounter fpsCounter;

	protected TestDelaySwingGame() {
		super("TestAFAPSwingGame", 480, 320, TARGET_FPS);
		fpsCounter = FramesPerSecondCounter.create();
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
	public void draw(ExpandedGraphics graphics) {
		fpsCounter.count();
		graphics.drawString(fpsCounter.current().toString(), 32, 32);
		graphics.drawString("This game engine 'Delays' after step and draw\n"
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
