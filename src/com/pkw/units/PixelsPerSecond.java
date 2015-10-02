package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

public class PixelsPerSecond extends GenericUnit<PixelsPerSecond> {

	private PixelsPerSecond(double value) {
		super(value, "pps");
	}

	public static PixelsPerSecond from(Pixels pixels, Seconds seconds) {
		return from(pixels.intValue(), seconds.doubleValue());
	}

	public static PixelsPerSecond from(int pixels, double seconds) {
		return ofValue(pixels / seconds);
	}

	public static PixelsPerSecond ofValue(double value) {
		return new PixelsPerSecond(value);
	}

	public static PixelsPerSecond pps(double value) {
		return ofValue(value);
	}

	public Pixels apply(MilliSeconds elapsed) {
		return apply(elapsed.toSeconds());
	}

	public Pixels apply(Seconds elapsed) {
		return Pixels.ofValue(doubleValue() / elapsed.doubleValue());
	}

	@Override
	protected PixelsPerSecond from(Double value) {
		return PixelsPerSecond.ofValue(value.doubleValue());
	}
}
