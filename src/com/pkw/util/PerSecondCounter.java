package com.pkw.util;

import java.util.Timer;
import java.util.TimerTask;

import com.pkw.units.MilliSeconds;

public class PerSecondCounter {

	private int count;
	private int current;
	private Timer timer;

	private PerSecondCounter() {
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

	public static PerSecondCounter create() {
		return new PerSecondCounter();
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

	public int current() {
		return current;
	}
}
