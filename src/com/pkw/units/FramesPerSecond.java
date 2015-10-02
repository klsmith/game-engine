package com.pkw.units;

import static com.pkw.units.Frames.frames;
import static com.pkw.units.Seconds.seconds;

import com.pkw.units.generic.GenericUnitPerUnit;

final public class FramesPerSecond extends
		GenericUnitPerUnit<Frames, Seconds, FramesPerSecond> {

	private FramesPerSecond(Frames frames, Seconds seconds) {
		super(frames, seconds);
	}

	public static FramesPerSecond ofValue(double value) {
		return fps(value);
	}

	public static FramesPerSecond fps(double value) {
		return from(frames((int) value), seconds(1));
	}

	public static FramesPerSecond from(Frames frames, Seconds seconds) {
		return new FramesPerSecond(frames, seconds);
	}

	public static FramesPerSecond from(int frames, double seconds) {
		return ofValue(frames / seconds);
	}

	public MilliSeconds milliSecondsPerFrame() {
		return MilliSeconds.PER_SECOND.divideBy(doubleValue());
	}

	@Override
	public String unitName() {
		return "fps";
	}

	@Override
	protected FramesPerSecond from(Double value) {
		return FramesPerSecond.ofValue(value.doubleValue());
	}
}
