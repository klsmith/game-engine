package com.pkw.units.generic;

public abstract class GenericUnitPerUnit<U extends UnitValue<U>, O extends UnitValue<O>, V extends GenericUnitPerUnit<U, O, V>>
		extends GenericUnit<V> {

	private GenericUnitPerUnit(Double value, String unitName) {
		super(value, unitName);
	}

	protected GenericUnitPerUnit(U unit, O perUnit) {
		this(unit.doubleValue() / perUnit.doubleValue(), unit.unitName() + "/"
				+ perUnit.unitName());
	}

}
