package com.pkw.units;

import static com.pkw.units.Pixels.pixels;
import static com.pkw.units.Seconds.seconds;

import com.pkw.units.generic.GenericUnitPerUnit;

public class PixelsPerSecond extends
		GenericUnitPerUnit<Pixels, Seconds, PixelsPerSecond> {

	private PixelsPerSecond(Pixels pixels, Seconds seconds) {
		super(pixels, seconds);
	}

	public static PixelsPerSecond from(Pixels pixels, Seconds seconds) {
		return new PixelsPerSecond(pixels, seconds);
	}

	public static PixelsPerSecond from(int pixels, double seconds) {
		return ofValue(pixels / seconds);
	}

	public static PixelsPerSecond ofValue(double value) {
		return from(pixels((int) value), seconds(1));
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
	public String unitName() {
		return "pps";
	}

	@Override
	protected PixelsPerSecond from(Double value) {
		return PixelsPerSecond.ofValue(value.doubleValue());
	}
}
