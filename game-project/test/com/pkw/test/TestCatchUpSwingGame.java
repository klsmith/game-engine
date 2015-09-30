package com.pkw.test;

import java.awt.Graphics2D;

import com.pkw.game.swing.CatchUpSwingGame;
import com.pkw.game.swing.util.TextGraphics;
import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;
import com.pkw.util.PerSecondCounter;

public class TestCatchUpSwingGame extends CatchUpSwingGame {
	private static final FramesPerSecond TARGET_FPS = FramesPerSecond
			.ofValue(60);
	private PerSecondCounter fpsCounter;

	protected TestCatchUpSwingGame() {
		super("TestCatchUpSwingGame", 480, 320, TARGET_FPS);
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
	public void draw(Graphics2D graphics, MilliSeconds delta) {
		fpsCounter.count();
		graphics.drawString("FPS: " + fpsCounter.current(), 32, 32);
		TextGraphics
				.drawString(
						graphics,
						"This game engine executes the step and draw events\n"
								+ "asynchronosly to eachother and forces the draw event\n"
								+ "to 'Catch Up' with a delta value.\n"
								+ "Desired FPS:" + TARGET_FPS, 32, 64);
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
		// TODO: Remove this when TestCatchUpSwingGame is working.
		System.err.println("TestCatchUpSwingGame is not current working!");
		(new TestCatchUpSwingGame()).run();
	}

}
