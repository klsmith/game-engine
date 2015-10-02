package com.pkw.units.generic;

public interface UnitValue<U extends UnitValue<U>> {

	public String unitName();

	public short shortValue();

	public int intValue();

	public long longValue();

	public float floatValue();

	public double doubleValue();

	public U subtract(U other);

	public U add(U other);

	public U divideBy(U other);

	public U divideBy(double scalar);

	public U multiplyBy(U other);

	public U multiplyBy(double scalar);

	public boolean isGreaterThan(U other);

	public boolean isGreaterThanOrEqualTo(U other);

	public boolean isLessThan(U other);

	public boolean isLessThanOrEqualTo(U other);

	public boolean isEqualTo(U other);

}
