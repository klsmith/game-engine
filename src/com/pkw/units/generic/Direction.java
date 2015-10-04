package com.pkw.units.generic;

import com.pkw.units.Radians;

public abstract class Direction<U extends UnitValue<U>> extends GenericUnit<U> {
	protected Direction(Double value, String unitName) {
		super(value, unitName);
	}

	public abstract Radians toRadians();
}
