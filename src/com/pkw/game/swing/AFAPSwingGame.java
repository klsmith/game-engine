package com.pkw.game.swing;

import com.pkw.game.AFAPGame;
import com.pkw.game.engine.AFAPEngine;

public abstract class AFAPSwingGame extends SwingGame implements AFAPGame {

	protected AFAPSwingGame(String title, int width, int height) {
		super(title, width, height);
	}

	@Override
	public void draw() {
		frame().repaint();
	}

	@Override
	public void run() {
		AFAPEngine.run(this);
	}
}
