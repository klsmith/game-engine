package com.pkw.game.swing.util;

import java.awt.Graphics2D;

public class ExpandedGraphics {

	private Graphics2D graphics;

	private ExpandedGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}

	public static ExpandedGraphics from(Graphics2D graphics) {
		return new ExpandedGraphics(graphics);
	}

	public Graphics2D graphics() {
		return graphics;
	}

	public void drawString(String text, int x, int y) {
		for (String line : text.split("\n")) {
			drawTabString(line, x, y += graphics.getFontMetrics().getHeight());
		}
	}

	private void drawTabString(String text, int x, int y) {
		for (String line : text.split("\t")) {
			graphics.drawString(line, x += graphics.getFontMetrics()
					.getHeight(), y);
		}
	}
}
