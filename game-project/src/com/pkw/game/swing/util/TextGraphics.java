package com.pkw.game.swing.util;

import java.awt.Graphics2D;

public class TextGraphics {
	public static void drawString(Graphics2D graphics, String text, int x, int y) {
		for (String line : text.split("\n")) {
			drawTabString(graphics, line, x, y += graphics.getFontMetrics()
					.getHeight());
		}
	}

	private static void drawTabString(Graphics2D graphics, String text, int x,
			int y) {
		for (String line : text.split("\t")) {
			graphics.drawString(line, x += graphics.getFontMetrics()
					.getHeight(), y);
		}
	}
}
