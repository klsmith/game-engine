package com.pkw.units.generic;

public abstract class Direction<U extends UnitValue<U>> extends GenericUnit<U> {
	protected Direction(Double value, String unitName) {
		super(value, unitName);
	}
}
