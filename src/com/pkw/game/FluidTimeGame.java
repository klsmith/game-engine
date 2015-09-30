package com.pkw.game;

import com.pkw.game.engine.FluidTimeEngine;
import com.pkw.units.MilliSeconds;

public interface FluidTimeGame extends Game {

	@Override
	default void run() {
		FluidTimeEngine.run(this);
	}

	public void step(MilliSeconds delta);

	public void draw();

}
