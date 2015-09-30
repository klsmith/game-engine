package com.pkw.game.swing;

import com.pkw.game.CatchUpGame;
import com.pkw.game.engine.CatchUpEngine;
import com.pkw.game.swing.util.ExpandedGraphics;
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
	public void draw(ExpandedGraphics graphics) {
		draw(graphics, delta);
	}

	public abstract void draw(ExpandedGraphics graphics, MilliSeconds delta);

}
