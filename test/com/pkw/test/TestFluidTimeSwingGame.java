package com.pkw.test;

import com.pkw.game.swing.FluidTimeSwingGame;
import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.units.MilliSeconds;
import com.pkw.util.FramesPerSecondCounter;

public class TestFluidTimeSwingGame extends FluidTimeSwingGame {
	private FramesPerSecondCounter fpsCounter;

	protected TestFluidTimeSwingGame() {
		super("TestFluidTimeSwingGame", 480, 320);
		fpsCounter = FramesPerSecondCounter.create();
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
	public void draw(ExpandedGraphics graphics) {
		fpsCounter.count();
		graphics.drawString(fpsCounter.current().toString(), 32, 32);
		graphics.drawString("This game engine will run with the highest\n"
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
