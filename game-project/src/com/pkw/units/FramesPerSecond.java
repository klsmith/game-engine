package com.pkw.units;

import java.util.HashMap;
import java.util.Map;

import com.pkw.units.generic.GenericUnit;

public class FramesPerSecond extends GenericUnit<FramesPerSecond> {

	private static Map<Double, FramesPerSecond> cache = new HashMap<>();

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
		if (!cache.containsKey(value)) {
			cache.put(value, new FramesPerSecond(value));
		}
		return cache.get(value);
	}

	public MilliSeconds milliSecondsPerFrame() {
		return MilliSeconds.PER_SECOND.divideBy(doubleValue());
	}

	@Override
	protected FramesPerSecond ofValue(Double value) {
		return FramesPerSecond.ofValue(value.doubleValue());
	}

}
