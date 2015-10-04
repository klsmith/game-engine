package com.pkw.util;

import java.util.Timer;
import java.util.TimerTask;

import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;

public class FramesPerSecondCounter extends Counter {

	private int current;
	private Timer timer;

	private FramesPerSecondCounter() {
		super();
		this.current = 0;
		timer = new Timer("perSecondTimer");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				commit();
			}
		}, MilliSeconds.PER_SECOND.longValue(),
				MilliSeconds.PER_SECOND.longValue());
	}

	public static FramesPerSecondCounter create() {
		return new FramesPerSecondCounter();
	}

	private void commit() {
		current = super.current();
		reset();
	}

	public FramesPerSecond currentFPS() {
		return FramesPerSecond.ofValue(current);
	}

	@Override
	public int current() {
		return current;
	}
}
