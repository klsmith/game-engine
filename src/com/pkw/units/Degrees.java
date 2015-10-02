package com.pkw.units;

import com.pkw.units.generic.Direction;

public class Degrees extends Direction<Degrees> {

	protected Degrees(Double value) {
		super(value, "degrees");
	}

	public static Degrees degrees(double value) {
		return new Degrees(value);
	}

	@Override
	protected Degrees from(Double value) {
		return degrees(value.doubleValue());
	}

	public Radians toRadians() {
		return null;
	}

}
