package com.pkw.game.engine;

import com.pkw.game.FluidTimeGame;
import com.pkw.units.MilliSeconds;

public class FluidTimeEngine extends GameEngine {

	private FluidTimeGame game;

	private FluidTimeEngine(FluidTimeGame game) {
		this.game = game;
	}

	public static void run(FluidTimeGame game) {
		(new FluidTimeEngine(game)).start();
	}

	@Override
	public void run() {
		game.onStart();
		MilliSeconds lastTime = MilliSeconds.now();
		while (game.isRunning()) {
			MilliSeconds current = MilliSeconds.now();
			MilliSeconds elapsed = current.subtract(lastTime);
			game.step(elapsed);
			game.draw();
			lastTime = current;
		}
		game.onEnd();
	}
}
