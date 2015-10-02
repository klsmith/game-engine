package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

final public class Frames extends GenericUnit<Frames> {

	private Frames(int value) {
		super((double) value, "frames");
	}

	public static Frames ofValue(double value) {
		return ofValue((int) value);
	}

	public static Frames ofValue(int value) {
		return new Frames(value);
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
