package com.pkw.test.player;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Input {

	public static Cache cache = Cache.create();

	private Type type;
	private Value value;

	private Input(Type type, Value value) {
		this.type = type;
		this.value = value;
	}

	public static Input input(Type type, Value value) {
		return cache.cache(type, value);
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

	public static class Cache {
		private Map<Type, Map<Value, Input>> cache;

		private Cache() {
			cache = new HashMap<>();
		}

		public static Cache create() {
			return new Cache();
		}

		public Input cache(Type type, Value value) {
			if (!cache.containsKey(type)) {
				cache.put(type, new HashMap<>());
			}
			if (!cache.get(type).containsKey(value)) {
				cache.get(type).put(value, new Input(type, value));
			}
			return cache.get(type).get(value);
		}
	}
}
