package com.pkw.units.generic;

public abstract class GenericUnit<U extends UnitValue<U>> implements
		UnitValue<U> {

	private Double value;
	private String unitName;

	protected GenericUnit(Double value, String unitName) {
		this.value = value;
		this.unitName = unitName;
	}

	@Override
	public String unitName() {
		return unitName;
	}

	@Override
	public short shortValue() {
		return value.shortValue();
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	protected abstract U from(Double value);

	@Override
	public U add(U other) {
		return from(doubleValue() + other.doubleValue());
	}

	@Override
	public U subtract(U other) {
		return from(doubleValue() - other.doubleValue());
	}

	@Override
	public U divideBy(U other) {
		return divideBy(other.doubleValue());
	}

	@Override
	public U divideBy(double scalar) {
		return from(doubleValue() / scalar);
	}

	@Override
	public U multiplyBy(U other) {
		return multiplyBy(other.doubleValue());
	}

	@Override
	public U multiplyBy(double scalar) {
		return from(doubleValue() * scalar);
	}

	@Override
	public boolean isGreaterThan(U other) {
		return doubleValue() > other.doubleValue();
	}

	@Override
	public boolean isGreaterThanOrEqualTo(U other) {
		return doubleValue() >= other.doubleValue();
	}

	@Override
	public boolean isLessThan(U other) {
		return doubleValue() < other.doubleValue();
	}

	@Override
	public boolean isLessThanOrEqualTo(U other) {
		return doubleValue() <= other.doubleValue();
	}

	@Override
	public boolean isEqualTo(U other) {
		return doubleValue() == other.doubleValue();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value + " " + unitName();
	}
}
