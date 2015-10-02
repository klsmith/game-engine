package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

public class MilliSeconds extends GenericUnit<MilliSeconds> {
	public static final MilliSeconds PER_SECOND = MilliSeconds.ofValue(1000.0);

	public static MilliSeconds now() {
		return MilliSeconds.ofValue(System.currentTimeMillis());
	}

	public static MilliSeconds ofValue(int value) {
		return MilliSeconds.ofValue((double) value);
	}

	public static MilliSeconds ofValue(long value) {
		return MilliSeconds.ofValue((double) value);
	}

	public static MilliSeconds ofValue(double value) {
		return new MilliSeconds(value);
	}

	public static MilliSeconds ms(double value) {
		return ofValue(value);
	}

	private MilliSeconds(double value) {
		super(value, "ms");
	}

	public Seconds toSeconds() {
		return Seconds.ofValue(PER_SECOND.doubleValue() / doubleValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof MilliSeconds) {
			return isEqualTo((MilliSeconds) obj);
		} else {
			return false;
		}
	}

	@Override
	protected MilliSeconds from(Double value) {
		return MilliSeconds.ofValue(value.doubleValue());
	}

}
