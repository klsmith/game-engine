package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

public class PixelsPerSecond extends GenericUnit<PixelsPerSecond> {

	private static Map<Double, PixelsPerSecond> cache = new HashMap<>();

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
		if (!cache.containsKey(value)) {
			cache.put(value, new PixelsPerSecond(value));
		}
		return cache.get(value);
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
	protected PixelsPerSecond ofValue(Double value) {
		return PixelsPerSecond.ofValue(value.doubleValue());
	}
}
