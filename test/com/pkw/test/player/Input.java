package com.pkw.test.player;

import java.awt.event.KeyEvent;

public class Input {

	private Type type;
	private Value value;

	private Input(Type type, Value value) {
		this.type = type;
		this.value = value;
	}

	public static Input input(Type type, Value value) {
		return new Input(type, value);
	}

	public static Input from(Type type, KeyEvent keyEvent) {
		return input(type, Value.from(keyEvent));
	}

	public Type type() {
		return type;
	}

	public Value value() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Input) {
			Input other = (Input) obj;
			return (type == other.type) && (value == other.value);
		} else {
			return false;
		}
	}

	public static enum Type {
		PRESSED, RELEASED;
	}

	public static enum Value {
		KEY_NONE, KEY_A, KEY_S, KEY_D, KEY_W;

		public static Value from(KeyEvent keyEvent) {
			switch (keyEvent.getKeyCode()) {
			case KeyEvent.VK_A:
				return KEY_A;
			case KeyEvent.VK_S:
				return KEY_S;
			case KeyEvent.VK_D:
				return KEY_D;
			case KeyEvent.VK_W:
				return KEY_W;
			default:
				return KEY_NONE;
			}
		}
	}
}
