package com.pkw.game.engine;

import com.pkw.game.AFAPGame;

public final class AFAPEngine extends GameEngine {

	private AFAPGame game;

	private AFAPEngine(AFAPGame game) {
		this.game = game;
	}

	public static void run(AFAPGame game) {
		(new AFAPEngine(game)).start();
	}

	@Override
	public void run() {
		game.onStart();
		while (game.isRunning()) {
			game.step();
			game.draw();
		}
		game.onEnd();
	}
}
