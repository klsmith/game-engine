package com.pkw.util;

import java.util.Timer;
import java.util.TimerTask;

import com.pkw.units.FramesPerSecond;
import com.pkw.units.MilliSeconds;

public class FramesPerSecondCounter {

	private int count;
	private int current;
	private Timer timer;

	private FramesPerSecondCounter() {
		reset();
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

	public void reset() {
		count = 0;
	}

	private void commit() {
		current = count;
		reset();
	}

	public void count() {
		count++;
	}

	public FramesPerSecond current() {
		return FramesPerSecond.ofValue(current);
	}
}