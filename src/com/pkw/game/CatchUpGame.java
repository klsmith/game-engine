package com.pkw.game;

import com.pkw.game.engine.CatchUpEngine;
import com.pkw.units.MilliSeconds;

public interface CatchUpGame extends Game {

	@Override
	default void run() {
		CatchUpEngine.run(this);
	}

	public void step();

	public void draw(MilliSeconds delta);

}
