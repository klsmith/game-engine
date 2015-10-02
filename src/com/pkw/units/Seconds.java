package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

public class Seconds extends GenericUnit<Seconds> {

	public static Seconds now() {
		return MilliSeconds.now().toSeconds();
	}

	public static Seconds ofValue(int value) {
		return seconds((double) value);
	}

	public static Seconds ofValue(long value) {
		return seconds((double) value);
	}

	public static Seconds seconds(double value) {
		return ofValue(value);
	}

	public static Seconds ofValue(double value) {
		return new Seconds(value);
	}

	private Seconds(double value) {
		super(value, "s");
	}

	public MilliSeconds toMilliSeconds() {
		return MilliSeconds.PER_SECOND.multiplyBy(doubleValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof Seconds) {
			return isEqualTo((Seconds) obj);
		} else {
			return false;
		}
	}

	@Override
	protected Seconds from(Double value) {
		return Seconds.ofValue(value.doubleValue());
	}
}
