package com.pkw.game.engine;

import static com.pkw.units.MilliSeconds.ms;

import com.pkw.game.DelayGame;
import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;

public class DelayEngine extends GameEngine {

	public static final FramesPerSecond DEFAULT_FPS = FramesPerSecond
			.ofValue(60);

	private DelayGame game;
	private FramesPerSecond fps;

	private DelayEngine(DelayGame game, FramesPerSecond fps) {
		this.game = game;
		this.fps = fps;
	}

	public static void run(DelayGame game) {
		run(game, DEFAULT_FPS);
	}

	public static void run(DelayGame game, FramesPerSecond desiredFPS) {
		(new DelayEngine(game, desiredFPS)).start();
	}

	@Override
	public void run() {
		game.onStart();
		while (game.isRunning()) {
			MilliSeconds start = MilliSeconds.now();
			game.step();
			game.draw();
			try {
				MilliSeconds sleepTime = start.add(fps.milliSecondsPerFrame())
						.subtract(MilliSeconds.now());
				if (sleepTime.isGreaterThan(ms(0))) {
					Thread.sleep(sleepTime.longValue());
				}
			} catch (InterruptedException e) {
			}
		}
		game.onEnd();
	}
}
