package com.pkw.units.generic;

public abstract class GenericUnitPerUnit<U extends UnitValue, O extends UnitValue, V extends GenericUnitPerUnit<U, O, V>>
		extends GenericUnit<V> {

	private GenericUnitPerUnit(Double value, String unitName) {
		super(value, unitName);
	}

	protected GenericUnitPerUnit(U unit, O perUnit) {
		this(unit.doubleValue() / perUnit.doubleValue(), unit.unitName() + "/"
				+ perUnit.unitName());
	}
}
