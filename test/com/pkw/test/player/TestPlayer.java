package com.pkw.test.player;

import static com.pkw.test.player.Input.Action.PRESSED;
import static com.pkw.test.player.Input.Action.RELEASED;
import static com.pkw.units.Pixels.pixels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.units.generic.Position;

public class TestPlayer {
	private static final int SPEED = 4;

	private Position position;
	private Dimension size;
	private KeyListener keyListener;
	private State hState;
	private State vState;

	private TestPlayer(Position startPosition, Dimension size) {
		this.position = startPosition;
		this.size = size;
		hState = HOR_STOPPED;
		vState = VER_STOPPED;
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
		return new TestPlayer(Position.position(x, y), new Dimension(width,
				height));
	}

	public Position position() {
		return position;
	}

	public int x() {
		return position.x().intValue();
	}

	public int y() {
		return position.y().intValue();
	}

	public int width() {
		return size.width;
	}

	public int height() {
		return size.height;
	}

	public KeyListener keyListener() {
		return keyListener;
	}

	public void step() {
		hState.step();
		vState.step();
		if (position.x().isLessThan(pixels(0))) {
			position = position.whereXIs(0);
		} else if (position.x().isGreaterThan(pixels(431))) {
			position = position.whereXIs(431);
		}
		if (position.y().isLessThan(pixels(0))) {
			position = position.whereYIs(0);
		} else if (position.y().isGreaterThan(pixels(248))) {
			position = position.whereYIs(248);
		}
	}

	public void draw(ExpandedGraphics graphics) {
		graphics.unexpanded().setColor(Color.WHITE);
		graphics.unexpanded().fillRect(x(), y(), width(), height());
		graphics.unexpanded().setColor(Color.RED);
		graphics.unexpanded().drawRect(x(), y(), width(), height());
	}

	private State HOR_STOPPED = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
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
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_D:
					return HOR_STOPPED;
				default:
					break;
				}
			case PRESSED:
				switch (input.value()) {
				case KEY_A:
					return LEFT_HOLDING_RIGHT;
				default:
					break;
				}
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position = position.translateX(SPEED);
		}
	};

	private State LEFT = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_A:
					return HOR_STOPPED;
				default:
					break;
				}
			case PRESSED:
				switch (input.value()) {
				case KEY_D:
					return RIGHT_HOLDING_LEFT;
				default:
					break;
				}
				break;
			}
			return this;
		}

		@Override
		public void step() {
			position = position.translateX(-SPEED);
		}
	};

	private State LEFT_HOLDING_RIGHT = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_A:
					return RIGHT;
				case KEY_D:
					return LEFT;
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
			position = position.translateX(-SPEED);
		}
	};

	private State RIGHT_HOLDING_LEFT = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_D:
					return LEFT;
				case KEY_A:
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
			position = position.translateX(SPEED);
		}
	};

	private State UP = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_W:
					return VER_STOPPED;
				default:
					break;
				}
			case PRESSED:
				switch (input.value()) {
				case KEY_S:
					return DOWN_HOLDING_UP;
				default:
					break;
				}
			}
			return this;
		}

		@Override
		public void step() {
			position = position.translateY(-SPEED);
		}
	};

	private State UP_HOLDING_DOWN = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_W:
					return DOWN;
				case KEY_S:
					return UP;
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
			position = position.translateY(-SPEED);
		}
	};

	private State DOWN_HOLDING_UP = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_S:
					return UP;
				case KEY_W:
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
			position = position.translateY(SPEED);
		}
	};

	private State DOWN = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
			case RELEASED:
				switch (input.value()) {
				case KEY_S:
					return VER_STOPPED;
				default:
					break;
				}
			case PRESSED:
				switch (input.value()) {
				case KEY_W:
					return UP_HOLDING_DOWN;
				default:
					break;
				}
			}
			return this;
		}

		@Override
		public void step() {
			position = position.translateY(SPEED);
		}
	};

	private State VER_STOPPED = new State() {
		@Override
		public State apply(Input input) {
			switch (input.action()) {
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
}
