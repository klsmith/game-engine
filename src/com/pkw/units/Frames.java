package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

final public class Frames extends GenericUnit<Frames> {

	private static Map<Integer, Frames> cache = new HashMap<>();

	private Frames(int value) {
		super((double) value, "frames");
	}

	public static Frames ofValue(double value) {
		return ofValue((int) value);
	}

	public static Frames ofValue(int value) {
		if (!cache.containsKey(value)) {
			cache.put(value, new Frames(value));
		}
		return cache.get(value);
	}

	public static Frames frames(int value) {
		return ofValue(value);
	}

	@Override
	protected Frames from(Double value) {
		return Frames.ofValue(value.doubleValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof Frames) {
			return isEqualTo((Frames) obj);
		} else {
			return false;
		}
	}
}
