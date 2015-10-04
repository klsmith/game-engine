package com.pkw.units.generic;

public abstract class Vector<U extends UnitValue<U>, D extends Direction<D>> {

	private U magnitude;
	private D direction;

	public Vector(U value, D direction) {
		this.magnitude = value;
		this.direction = direction;
	}

	public U value() {
		return magnitude;
	}

	public D direction() {
		return direction;
	}

	protected abstract Vector<U, D> from(double magnitude, double radians);

	public U xMagnitude() {

		return magnitude;
	}

	public U yMagnitude() {
		return magnitude.multiplyBy(Math.sin(direction.toRadians()
				.doubleValue()));
	}
}
