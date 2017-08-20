// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.src.estomonia.Estomonia;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiMainMenu extends GuiScreen {

	public GuiMainMenu() {
		updateCounter = 0.0F;
		splashText = "missingno";
		try {
			ArrayList arraylist = new ArrayList();
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(
					(net.minecraft.src.GuiMainMenu.class).getResourceAsStream("/title/splashes.txt"),
					Charset.forName("UTF-8")));
			String s = "";
			do {
				String s1;
				if ((s1 = bufferedreader.readLine()) == null) {
					break;
				}
				s1 = s1.trim();
				if (s1.length() > 0) {
					arraylist.add(s1);
				}
			} while (true);
			splashText = (String) arraylist.get(rand.nextInt(arraylist.size()));
		} catch (Exception exception) {
		}
	}

	public void updateScreen() {
		updateCounter++;
	}

	protected void keyTyped(char c, int i) {
	}

	@SuppressWarnings("unchecked")
	public void initGui() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
			splashText = "Happy birthday, ez!";
		} else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
			splashText = "Happy birthday, Notch!";
		} else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
			splashText = "Merry X-mas!";
		} else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
			splashText = "Happy new year!";
		}
		StringTranslate stringtranslate = StringTranslate.getInstance();
		int i = height / 4 + 48;
		controlList.add(new GuiButton(1, width / 2 - 100, i, stringtranslate.translateKey("menu.singleplayer")));
		controlList.add(multiplayerButton = new GuiButton(2, width / 2 - 100, i + 24,
				stringtranslate.translateKey("menu.multiplayer")));
		controlList.add(new GuiButton(3, width / 2 - 100, i + 48, stringtranslate.translateKey("menu.mods")));
		controlList.add(new GuiButton(100, width / 2 - 100, i + 110, "Connect To BetaLands"));
		controlList.add(new GuiButton(200, width / 2 - 100, i - 100, "Sweetz"));
		if (mc.hideQuitButton) {
			controlList.add(new GuiButton(0, width / 2 - 100, i + 72, stringtranslate.translateKey("menu.options")));
		} else {
			controlList.add(new GuiButton(0, width / 2 - 100, i + 72 + 12, 98, 20,
					stringtranslate.translateKey("menu.options")));
			controlList.add(
					new GuiButton(4, width / 2 + 2, i + 72 + 12, 98, 20, stringtranslate.translateKey("menu.quit")));
		}
		if (mc.session == null) {
			multiplayerButton.enabled = false;
		}
	}

	public GuiConnecting connecting;

	protected void actionPerformed(GuiButton guibutton) {
		if (guibutton.id == 0) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if (guibutton.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if (guibutton.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if (guibutton.id == 3) {
			mc.displayGuiScreen(new GuiTexturePacks(this));
		}
		if (guibutton.id == 4) {
			mc.shutdown();
		}
		if (guibutton.id == 100) {
			mc.displayGuiScreen(new GuiConnecting(mc, "betalands.serverminer.com", 25565));
		}
		if (guibutton.id == 200) {
			String url = "https://www.youtube.com/user/Sw33tzGaming/featured";
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(url));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void drawBack(int i) {
		GL11.glBindTexture(3553, mc.renderEngine.getTexture("/gui/unknown_pack.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(2912 /*GL_FOG*/);
        Tessellator tessellator = Tessellator.instance;
        float fx = 32F;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0D, height, 0.0D, 0.0D, (float)height / fx + (float)i);
        tessellator.addVertexWithUV(width, height, 0.0D, (float)width / fx, (float)height / fx + (float)i);
        tessellator.addVertexWithUV(width, 0.0D, 0.0D, (float)width / fx, 0 + i);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0 + i);
        tessellator.draw();
	}

	
	public void drawEstomoniaBackground(int i) {
		if(mc.theWorld != null)
        {
            drawGradientRect(0, 0, width, height, 0xc0101010, 0xd0101010);
        } else
        {
            drawBack(i);
        }
	}
	
	public void drawScreen(int i, int j, float f) {
		final ScaledResolution scaledResolution = new ScaledResolution(mc.gameSettings, width, height);
	
		drawEstomoniaBackground(i);
		
		String title = Estomonia.instance.name;

		GL11.glPushMatrix();
		GL11.glScalef(3.5f, 3.5f, 3.5f);
		drawCenteredString(mc.fontRenderer, title, width / 7, 20, -1);
		GL11.glPopMatrix();

		String credits = "Coded by: " + Arrays.asList(Estomonia.instance.authors);
		drawString(fontRenderer, credits, width - fontRenderer.getStringWidth(credits) - 2, height - 20, -1);

		String s = "Copyright Mojang AB. Do not distribute.";
		drawString(fontRenderer, s, width - fontRenderer.getStringWidth(s) - 2, height - 10, 0xffffff);

		super.drawScreen(i, j, f);
	}

	private static final Random rand = new Random();
	private float updateCounter;
	private String splashText;
	private GuiButton multiplayerButton;

}
