package com.pkw.units.generic;

public class Vector<U extends UnitValue<U>, D extends Direction<D>> {

	private U value;
	private D direction;

	public Vector(U value, D direction) {
		this.value = value;
		this.direction = direction;
	}

	public U value() {
		return value;
	}

	public D direction() {
		return direction;
	}
}
