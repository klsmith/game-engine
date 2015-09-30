package com.pkw.game.engine;

import com.pkw.game.CatchUpGame;
import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;

public class CatchUpEngine extends GameEngine {

	public static final FramesPerSecond DEFAULT_FPS = FramesPerSecond
			.ofValue(60);

	private CatchUpGame game;
	private FramesPerSecond fps;

	private CatchUpEngine(CatchUpGame game, FramesPerSecond fps) {
		this.game = game;
		this.fps = fps;
	}

	public static void run(CatchUpGame game) {
		run(game, DEFAULT_FPS);
	}

	public static void run(CatchUpGame game, FramesPerSecond desiredFPS) {
		(new CatchUpEngine(game, desiredFPS)).start();
	}

	@Override
	public void run() {
		game.onStart();
		MilliSeconds previous = MilliSeconds.now();
		MilliSeconds lag = MilliSeconds.ofValue(0.0);
		while (game.isRunning()) {
			MilliSeconds current = MilliSeconds.now();
			MilliSeconds elapsed = current.subtract(previous);
			previous = current;
			lag = lag.add(elapsed);
			while (lag.isGreaterThanOrEqualTo(fps.milliSecondsPerFrame())) {
				game.step();
				lag = lag.subtract(fps.milliSecondsPerFrame());
			}
			game.draw(lag.divideBy(fps.milliSecondsPerFrame()));
		}
		game.onEnd();
	}

}
