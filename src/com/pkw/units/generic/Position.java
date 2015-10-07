package com.pkw.units.generic;

import static com.pkw.units.Pixels.pixels;

import com.pkw.units.Pixels;

public class Position {

	private Pixels x;
	private Pixels y;

	private Position(Pixels x, Pixels y) {
		this.x = x;
		this.y = y;
	}

	public static Position position(double x, double y) {
		return position(pixels(x), pixels(y));
	}

	public static Position position(Pixels x, Pixels y) {
		return new Position(x, y);
	}

	public Pixels x() {
		return x;
	}

	public Pixels y() {
		return y;
	}

	public Position translateX(double xAmount) {
		return translate(xAmount, 0);
	}

	public Position translateY(double yAmount) {
		return translate(0, yAmount);
	}

	public Position translate(double xAmount, double yAmount) {
		return translate(pixels(xAmount), pixels(yAmount));
	}

	public Position translate(Pixels xAmount, Pixels yAmount) {
		return position(x.add(xAmount), y.add(yAmount));
	}

	public Position whereXIs(double newX) {
		return position(pixels(newX), y);
	}

	public Position whereYIs(double newY) {
		return position(x, pixels(newY));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Position) {
			Position other = (Position) obj;
			return other.x.equals(x) && other.y.equals(y);
		} else {
			return false;
		}
	}

}
