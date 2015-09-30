package com.pkw.game;

import com.pkw.game.engine.AFAPEngine;

public interface AFAPGame extends Game {

	@Override
	default void run() {
		AFAPEngine.run(this);
	}

	public void step();

	public void draw();

}
