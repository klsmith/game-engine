package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

public class MilliSeconds extends GenericUnit<MilliSeconds> {
	private static Map<Double, MilliSeconds> cache = new HashMap<>();
	public static final MilliSeconds PER_SECOND = MilliSeconds.ofValue(1000.0);

	public static MilliSeconds now() {
		return MilliSeconds.ofValue(System.currentTimeMillis());
	}

	public static MilliSeconds ofValue(int value) {
		return MilliSeconds.ofValue((double) value);
	}

	public static MilliSeconds ofValue(long value) {
		return MilliSeconds.ofValue((double) value);
	}

	public static MilliSeconds ofValue(double value) {
		if (!cache.containsKey(value)) {
			cache.put(value, new MilliSeconds(value));
		}
		return cache.get(value);
	}

	public static MilliSeconds ms(double value) {
		return ofValue(value);
	}

	private MilliSeconds(double value) {
		super(value, "ms");
	}

	public Seconds toSeconds() {
		return Seconds.ofValue(PER_SECOND.doubleValue() / doubleValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof MilliSeconds) {
			return isEqualTo((MilliSeconds) obj);
		} else {
			return false;
		}
	}

	@Override
	protected MilliSeconds ofValue(Double value) {
		return MilliSeconds.ofValue(value.doubleValue());
	}

}
