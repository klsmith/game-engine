package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

public class Pixels extends GenericUnit<Pixels> {

	private Pixels(double value) {
		super(value, "px");
	}

	public static Pixels ofValue(double value) {
		return new Pixels(value);
	}

	public static Pixels pixels(double value) {
		return new Pixels(value);
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
		return pixels(value.doubleValue());
	}
}
