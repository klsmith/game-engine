package com.pkw.units;

import com.pkw.units.generic.Direction;

public class Radians extends Direction<Radians> {

	protected Radians(Double value) {
		super(value, "radians");
	}

	public static Radians radians(double value) {
		return new Radians(value);
	}

	@Override
	protected Radians from(Double value) {
		return radians(value.doubleValue());
	}

	public Degrees toDegrees() {
		return null;
	}

	@Override
	public Radians toRadians() {
		return this;
	}
}
