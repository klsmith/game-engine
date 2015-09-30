package com.pkw.units.generic;


public interface UnitMath<U extends Unit> {

	
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
