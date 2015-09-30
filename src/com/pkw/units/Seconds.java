package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

public class Seconds extends GenericUnit<Seconds> {

	private static Map<Double, Seconds> cache = new HashMap<>();

	public static Seconds now() {
		return MilliSeconds.now().toSeconds();
	}

	public static Seconds ofValue(int value) {
		return seconds((double) value);
	}

	public static Seconds ofValue(long value) {
		return seconds((double) value);
	}

	public static Seconds seconds(double value) {
		return ofValue(value);
	}

	public static Seconds ofValue(double value) {
		if (!cache.containsKey(value)) {
			cache.put(value, new Seconds(value));
		}
		return cache.get(value);
	}

	private Seconds(double value) {
		super(value, "s");
	}

	public MilliSeconds toMilliSeconds() {
		return MilliSeconds.PER_SECOND.multiplyBy(doubleValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof Seconds) {
			return isEqualTo((Seconds) obj);
		} else {
			return false;
		}
	}

	@Override
	protected Seconds from(Double value) {
		return Seconds.ofValue(value.doubleValue());
	}
}
