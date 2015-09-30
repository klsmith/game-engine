package com.pkw.game;

import com.pkw.game.engine.DelayEngine;

public interface DelayGame extends Game {

	@Override
	default void run() {
		DelayEngine.run(this);
	}

	public void step();

	public void draw();

}
