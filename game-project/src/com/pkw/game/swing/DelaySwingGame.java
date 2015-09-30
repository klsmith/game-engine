package com.pkw.game.swing;

import com.pkw.game.DelayGame;
import com.pkw.game.engine.DelayEngine;
import com.pkw.units.FramesPerSecond;

public abstract class DelaySwingGame extends SwingGame implements DelayGame {

	protected FramesPerSecond targetFPS;

	protected DelaySwingGame(String title, int width, int height,
			FramesPerSecond targetFPS) {
		super(title, width, height);
		this.targetFPS = targetFPS;
	}

	public FramesPerSecond targetFPS() {
		return targetFPS;
	}

	@Override
	public void draw() {
		frame().repaint();
	}

	@Override
	public void run() {
		DelayEngine.run(this, targetFPS);
	}

}
