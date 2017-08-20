package net.minecraft.src.estomonia.gui.other;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.GuiScreen;
import net.minecraft.src.Tessellator;
import net.minecraft.src.estomonia.Estomonia;

public class EstomoniaGui extends GuiScreen {

	public GuiScreen lastScreen;

	public EstomoniaGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
	}

	public void drawBack(int i) {
		GL11.glBindTexture(3553, mc.renderEngine.getTexture("/gui/unknown_pack.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(2896 /* GL_LIGHTING */);
		GL11.glDisable(2912 /* GL_FOG */);
		Tessellator tessellator = Tessellator.instance;
		float fx = 32F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0x404040);
		tessellator.addVertexWithUV(0.0D, height, 0.0D, 0.0D, (float) height / fx + (float) i);
		tessellator.addVertexWithUV(width, height, 0.0D, (float) width / fx, (float) height / fx + (float) i);
		tessellator.addVertexWithUV(width, 0.0D, 0.0D, (float) width / fx, 0 + i);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0 + i);
		tessellator.draw();
	}

	public void drawEstomoniaBackground(int i) {
		if (mc.theWorld != null) {
			drawGradientRect(0, 0, width, height, 0xc0101010, 0xd0101010);
		} else {
			drawBack(i);
		}
	}

	public void initGui() {

	}

	public void drawScreen(int i, int j, float f) {
		drawEstomoniaBackground(0);
		mc.fontRenderer.drawStringWithShadow("So, welcome to " + Estomonia.instance.name + "!", 2, 5, -1);
		mc.fontRenderer.drawStringWithShadow("Coded by: " + Arrays.asList(Estomonia.instance.authors) + " With proudness.", 2, 20, -1);
		mc.fontRenderer.drawStringWithShadow("Thanks to Sweetz for giving me the oppertunity to make this client.", 2, 30, -1);
		mc.fontRenderer.drawStringWithShadow("Thanks to the community for supporting me.", 2, 40, -1);
		mc.fontRenderer.drawStringWithShadow("You are currently on version: " + Estomonia.instance.version, 2, 50, -1);
	}

}
