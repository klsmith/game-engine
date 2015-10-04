package com.pkw.util;

public class Counter {

	private int count;

	protected Counter() {
		count = 0;
	}

	public static Counter create() {
		return new Counter();
	}

	public void count() {
		count++;
	}

	public int current() {
		return count;
	}

	public void reset() {
		count = 0;
	}
}
