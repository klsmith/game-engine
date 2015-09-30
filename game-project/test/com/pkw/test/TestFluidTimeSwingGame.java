package com.pkw.test;

import java.awt.Graphics2D;

import com.pkw.game.swing.FluidTimeSwingGame;
import com.pkw.game.swing.util.TextGraphics;
import com.pkw.units.MilliSeconds;
import com.pkw.util.PerSecondCounter;

public class TestFluidTimeSwingGame extends FluidTimeSwingGame {
	private PerSecondCounter fpsCounter;

	protected TestFluidTimeSwingGame() {
		super("TestFluidTimeSwingGame", 480, 320);
		fpsCounter = PerSecondCounter.create();
	}

	@Override
	public void beforeStart() {
	}

	@Override
	public void afterStart() {
	}

	@Override
	public void step(MilliSeconds delta) {
	}

	@Override
	public void draw(Graphics2D graphics) {
		fpsCounter.count();
		graphics.drawString("FPS: " + fpsCounter.current(), 32, 32);
		TextGraphics.drawString(graphics,
				"This game engine will run with the highest\n"
						+ "fps possible while forcing the step event to\n"
						+ "update based on real time in ms.", 32, 64);
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
		(new TestFluidTimeSwingGame()).run();
	}
}
