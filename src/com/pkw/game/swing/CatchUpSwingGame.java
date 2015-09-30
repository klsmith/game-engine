package com.pkw.game.swing;

import java.awt.Graphics2D;

import com.pkw.game.CatchUpGame;
import com.pkw.game.engine.CatchUpEngine;
import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;

public abstract class CatchUpSwingGame extends SwingGame implements CatchUpGame {

	protected FramesPerSecond targetFPS;
	private MilliSeconds delta;

	protected CatchUpSwingGame(String title, int width, int height,
			FramesPerSecond targetFPS) {
		super(title, width, height);
		this.targetFPS = targetFPS;
	}

	@Override
	public void run() {
		CatchUpEngine.run(this, targetFPS);
	}

	@Override
	public void draw(MilliSeconds delta) {
		this.delta = delta;
	}

	@Override
	public void draw(Graphics2D graphics) {
		draw(graphics, delta);
	}

	public abstract void draw(Graphics2D graphics, MilliSeconds delta);

}
