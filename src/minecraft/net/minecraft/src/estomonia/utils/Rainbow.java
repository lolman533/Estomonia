package net.minecraft.src.estomonia.utils;

import java.awt.Color;

public class Rainbow {

	/**
	 * Simple Rainbow Loop.
	 * @param speed - Speed of Rainbow.
	 * @param offset - Offset.
	 * @return - Return's the RGB.
	 */
	public static int getRainbow(int speed, int offset) {
		float hue = (System.currentTimeMillis() + offset) % speed;
		hue /= speed;
		return Color.getHSBColor(hue, 1f, 1f).getRGB();
	}
	
}
