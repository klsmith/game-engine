package com.pkw.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.pkw.game.swing.util.ExpandedGraphics;
import com.pkw.units.PixelsPerSecond;
import static com.pkw.units.PixelsPerSecond.*;

public class TestPlayer {

	private static final int SPEED = 4;

	private Point position;
	private Dimension size;
	private KeyListener keyListener;
	private PixelsPerSecond hspeed;
	private PixelsPerSecond vspeed;

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
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					if (hspeed.isEqualTo(PixelsPerSecond.ofValue(0))) {
						hspeed = pps(-SPEED);
					}
					break;
				case KeyEvent.VK_D:
					if (hspeed.isEqualTo(PixelsPerSecond.ofValue(0))) {
						hspeed = pps(SPEED);
					}
					break;
				case KeyEvent.VK_W:
					if (vspeed.isEqualTo(PixelsPerSecond.ofValue(0))) {
						vspeed = pps(-SPEED);
					}
					break;
				case KeyEvent.VK_S:
					if (vspeed.isEqualTo(PixelsPerSecond.ofValue(0))) {
						vspeed = pps(SPEED);
					}
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					if (hspeed.isLessThan(PixelsPerSecond.ofValue(0))) {
						hspeed = pps(0);
					}
					break;
				case KeyEvent.VK_D:
					if (hspeed.isGreaterThan(PixelsPerSecond.ofValue(0))) {
						hspeed = pps(0);
					}
					break;
				case KeyEvent.VK_W:
					if (vspeed.isLessThan(PixelsPerSecond.ofValue(0))) {
						vspeed = pps(0);
					}
					break;
				case KeyEvent.VK_S:
					if (vspeed.isGreaterThan(PixelsPerSecond.ofValue(0))) {
						vspeed = pps(0);
					}
				default:
					break;
				}
			}

		};
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
		position.x += hspeed.intValue();
		position.y += vspeed.intValue();
	}

	public void draw(ExpandedGraphics graphics) {
		graphics.unexpanded().setColor(Color.WHITE);
		graphics.unexpanded().fillRect(x(), y(), width(), height());
		graphics.unexpanded().setColor(Color.RED);
		graphics.unexpanded().drawRect(x(), y(), width(), height());
	}
}
