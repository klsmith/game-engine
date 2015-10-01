package com.pkw.test.player;

import static com.pkw.test.player.Input.Type.PRESSED;
import static com.pkw.test.player.Input.Type.RELEASED;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.units.PixelsPerSecond;

public class TestPlayer {
	private static final int SPEED = 4;

	private State HOR_STOPPED = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case PRESSED:
				switch (input.value()) {
				case KEY_A:
					return LEFT;
				case KEY_D:
					return RIGHT;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
		}
	};

	private State RIGHT = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_D:
					return HOR_STOPPED;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position.x += SPEED;
		}
	};

	private State LEFT = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_A:
					return HOR_STOPPED;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position.x -= SPEED;
		}
	};

	private State UP = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_W:
					return VER_STOPPED;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position.y -= SPEED;
		}
	};

	private State DOWN = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_S:
					return VER_STOPPED;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position.y += SPEED;
		}
	};

	private State VER_STOPPED = new State() {
		@Override
		public State apply(Input input) {
			switch (input.type()) {
			case PRESSED:
				switch (input.value()) {
				case KEY_W:
					return UP;
				case KEY_S:
					return DOWN;
				default:
					break;
				}
			default:
				break;
			}
			return this;
		}

		@Override
		public void step() {
		}
	};
	private Point position;
	private Dimension size;
	private KeyListener keyListener;
	private PixelsPerSecond hspeed;
	private PixelsPerSecond vspeed;
	private State hState = HOR_STOPPED;
	private State vState = VER_STOPPED;

	private TestPlayer(Point startPosition, Dimension size) {
		this.position = startPosition;
		this.size = size;
		hspeed = PixelsPerSecond.ofValue(0);
		vspeed = PixelsPerSecond.ofValue(0);
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				handle(Input.from(PRESSED, e));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				handle(Input.from(RELEASED, e));
			}

		};
	}

	public void handle(Input input) {
		hState = hState.apply(input);
		vState = vState.apply(input);
	}

	public static TestPlayer createAt(int x, int y, int width, int height) {
		return new TestPlayer(new Point(x, y), new Dimension(width, height));
	}

	public Point position() {
		return new Point(x(), y());
	}

	public int x() {
		return position.x;
	}

	public int y() {
		return position.y;
	}

	public int width() {
		return size.width;
	}

	public int height() {
		return size.height;
	}

	public PixelsPerSecond hspeed() {
		return hspeed;
	}

	public PixelsPerSecond vspeed() {
		return vspeed;
	}

	public KeyListener keyListener() {
		return keyListener;
	}

	public void step() {
		hState.step();
		vState.step();
	}

	public void draw(ExpandedGraphics graphics) {
		graphics.unexpanded().setColor(Color.WHITE);
		graphics.unexpanded().fillRect(x(), y(), width(), height());
		graphics.unexpanded().setColor(Color.RED);
		graphics.unexpanded().drawRect(x(), y(), width(), height());
	}
}
