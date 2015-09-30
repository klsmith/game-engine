package com.pkw.game.swing;

import com.pkw.game.FluidTimeGame;
import com.pkw.game.engine.FluidTimeEngine;

public abstract class FluidTimeSwingGame extends SwingGame implements
		FluidTimeGame {

	protected FluidTimeSwingGame(String title, int width, int height) {
		super(title, width, height);
	}

	@Override
	public void run() {
		FluidTimeEngine.run(this);
	}

	@Override
	public void draw() {
		frame().repaint();
	}

}
