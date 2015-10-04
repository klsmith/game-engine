package com.pkw.test;

import static com.pkw.units.FramesPerSecond.fps;

import java.awt.Color;

import com.pkw.game.swing.DelaySwingGame;
import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.test.player.TestPlayer;
import com.pkw.units.FramesPerSecond;
import com.pkw.util.FramesPerSecondCounter;

public class TestDelaySwingGame extends DelaySwingGame {
	private static final FramesPerSecond TARGET_FPS = fps(60);
	private FramesPerSecondCounter fpsCounter;
	private TestPlayer player;

	protected TestDelaySwingGame() {
		super("TestAFAPSwingGame", 480, 320, TARGET_FPS);
		fpsCounter = FramesPerSecondCounter.create();
		player = TestPlayer.createAt(128, 128, 32, 32);
		frame().addKeyListener(player.keyListener());
	}

	@Override
	public void beforeStart() {
	}

	@Override
	public void afterStart() {
	}

	@Override
	public void step() {
		player.step();
	}

	@Override
	public void draw(ExpandedGraphics graphics) {
		player.draw(graphics);
		graphics.unexpanded().setColor(Color.BLACK);
		fpsCounter.count();
		graphics.drawString(fpsCounter.currentFPS().toString(), 32, 32);
		graphics.drawString("This game engine 'Delays' after step and draw\n"
				+ "events complete to reach the desired FPS.\n"
				+ "Desired FPS: " + TARGET_FPS + "\n(" + player.x() + ", "
				+ player.y() + ")", 32, 64);
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
