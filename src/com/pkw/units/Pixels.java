package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

public class Pixels extends GenericUnit<Pixels> {

	private static Map<Integer, Pixels> cache = new HashMap<>();

	private Pixels(double value) {
		super(value, "px");
	}

	public static Pixels ofValue(double value) {
		return Pixels.ofValue((int) value);
	}

	public static Pixels ofValue(int value) {
		if (!cache.containsKey(value)) {
			cache.put(value, new Pixels(value));
		}
		return cache.get(value);
	}

	public static Pixels px(int value) {
		return ofValue(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof Pixels) {
			return isEqualTo((Pixels) obj);
		} else {
			return false;
		}
	}

	@Override
	protected Pixels from(Double value) {
		// TODO Auto-generated method stub
		return null;
	}
}
