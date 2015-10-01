package com.pkw.util;

public class Triplet<A, B, C> {

	private A a;
	private B b;
	private C c;

	public Triplet(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public A a() {
		return a;
	}

	public B b() {
		return b;
	}

	public C c() {
		return c;
	}
}
