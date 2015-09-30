package com.pkw.test;

import java.awt.Graphics2D;

import com.pkw.game.swing.AFAPSwingGame;
import com.pkw.util.PerSecondCounter;

final public class TestAFAPSwingGame extends AFAPSwingGame {

	private PerSecondCounter fpsCounter;

	protected TestAFAPSwingGame() {
		super("TestAFAPSwingGame", 480, 320);
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
