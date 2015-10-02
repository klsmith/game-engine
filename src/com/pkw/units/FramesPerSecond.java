package com.pkw.units;

import com.pkw.units.generic.GenericUnit;

public class FramesPerSecond extends GenericUnit<FramesPerSecond> {

	private FramesPerSecond(double value) {
		super(value, "fps");
	}

	public static FramesPerSecond from(Frames frames, Seconds seconds) {
		return from(frames.intValue(), seconds.doubleValue());
	}

	public static FramesPerSecond from(int frames, double seconds) {
		return ofValue(frames / seconds);
	}

	public static FramesPerSecond ofValue(double value) {
		return new FramesPerSecond(value);
	}

	public static FramesPerSecond fps(double value) {
		return ofValue(value);
	}

	public MilliSeconds milliSecondsPerFrame() {
		return MilliSeconds.PER_SECOND.divideBy(doubleValue());
	}

	@Override
	protected FramesPerSecond from(Double value) {
		return FramesPerSecond.ofValue(value.doubleValue());
	}

}
