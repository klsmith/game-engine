package com.pkw.test;

import com.pkw.game.swing.AFAPSwingGame;
import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.util.FramesPerSecondCounter;

final public class TestAFAPSwingGame extends AFAPSwingGame {

	private FramesPerSecondCounter fpsCounter;

	protected TestAFAPSwingGame() {
		super("TestAFAPSwingGame", 480, 320);
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
		graphics.drawString("This game engine runs 'As Fast As Possible'.", 32,
				64);
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
		(new TestAFAPSwingGame()).run();
	}
}