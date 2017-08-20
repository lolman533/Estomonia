package net.minecraft.src.estomonia.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.src.estomonia.Estomonia;
import net.minecraft.src.estomonia.utils.Rainbow;

public class GuiRendering {

	/**
	 * Entry point for GuiRendering.
	 * @param mc
	 */
	public static void init(Minecraft mc) {
		if (mc.gameSettings.showDebugInfo) {
			return;
		}
		drawName(mc);
		drawCoords(mc);
		drawHealth(mc);
		drawUserName(mc);
		drawHealthDecision(mc);
		drawFPS(mc);
	}

	/**
	 * Draw the client's name.
	 * 
	 * @param mc
	 */
	private static void drawName(Minecraft mc) {
		GL11.glPushMatrix();
		GL11.glScalef(1.5F, 1.5F, 1.5F);
		mc.fontRenderer.drawStringWithShadow(Estomonia.instance.name, 2, 5, Rainbow.getRainbow(6000, -15 * 4));
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glPopMatrix();
		mc.fontRenderer.drawStringWithShadow(Estomonia.instance.version, 75, 5, -1);
	}

	/**
	 * Draw the current coordinates of the player
	 * 
	 * @param mc
	 */
	private static void drawCoords(Minecraft mc) {
		mc.fontRenderer.drawString("X: " + Math.floor(mc.thePlayer.posX), 2, 25, -1);
		mc.fontRenderer.drawString("Y: " + Math.floor(mc.thePlayer.posY), 2, 35, -1);
		mc.fontRenderer.drawString("Z: " + Math.floor(mc.thePlayer.posZ), 2, 45, -1);
	}

	/**
	 * Draw's the player's health.
	 * 
	 * @param mc
	 */
	private static void drawHealth(Minecraft mc) {
		mc.fontRenderer.drawString("Health: " + mc.thePlayer.health, 2, 60, -1);
	}

	/**
	 * Draw's health decision, done one at a time for good stability.
	 * 
	 * @param mc
	 */
	private static void drawHealthDecision(Minecraft mc) {
		if (mc.thePlayer.health == 1) {
			mc.fontRenderer.drawString("HealthDecision: " + "Unhealthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 2) {
			mc.fontRenderer.drawString("HealthDecision: " + "Unhealthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 3) {
			mc.fontRenderer.drawString("HealthDecision: " + "Unhealthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 4) {
			mc.fontRenderer.drawString("HealthDecision: " + "Unhealthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 5) {
			mc.fontRenderer.drawString("HealthDecision: " + "Unhealthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 6) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 7) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 8) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 9) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 10) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 11) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 12) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 13) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 14) {
			mc.fontRenderer.drawString("HealthDecision: " + "Meh.", 2, 80, -1);
		} else if (mc.thePlayer.health == 15) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 16) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 17) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 18) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 19) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		} else if (mc.thePlayer.health == 20) {
			mc.fontRenderer.drawString("HealthDecision: " + "Healthy.", 2, 80, -1);
		}
	}

	/**
	 * Draws the username.
	 * 
	 * @param mc
	 */
	private static void drawUserName(Minecraft mc) {
		mc.fontRenderer.drawString("Username: " + mc.thePlayer.username, 2, 70, -1);
	}

	/**
	 * Draw's the user's FPS
	 */
	private static void drawFPS(Minecraft mc) {
		mc.fontRenderer.drawString("FPS: " + mc.debug, 2, 90, -1);
	}
	
}
