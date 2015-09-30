package com.pkw.game.engine;

public abstract class GameEngine {

	public final void start() {
		final GameEngine thisEngine = this;
		(new Thread() {
			@Override
			public void run() {
				thisEngine.run();
			}
		}).start();
	}

	public abstract void run();

}
