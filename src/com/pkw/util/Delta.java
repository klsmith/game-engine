package com.pkw.util;

import com.pkw.units.MilliSeconds;
import com.pkw.units.Pixels;
import com.pkw.units.PixelsPerSecond;

public class Delta {

	private MilliSeconds delta;

	private Delta() {
		this.delta = MilliSeconds.ofValue(0);
	}

	public static Delta create() {
		return new Delta();
	}

	public MilliSeconds delta() {
		return delta;
	}

	public void update(MilliSeconds delta) {
		this.delta = delta;
	}

	public Pixels applyTo(PixelsPerSecond pps) {
		return pps.apply(delta());
	}
}
