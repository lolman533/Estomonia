package net.minecraft.src.estomonia.utils;

import java.io.File;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.WorldClient;

public class Wrapper {

	private static Minecraft mc;
	private static EntityPlayerSP entityPlayerSP;
	private static EntityRenderer entityRenderer;
	private static EntityPlayer entityPlayer;
	private static EntityLiving entityLiving;
	private static Block block;
	
	public static boolean isEntityValid(EntityLiving entity) {
		if (entity.isEntityAlive() && entity != mc.thePlayer) {
			return true;
		}
		return false;
	}

	public static List<?> getLoadedTileEntityList() {
		return mc.theWorld.loadedTileEntityList;
	}
	
	public static List<?> getLoadedEntityList() {
		return mc.theWorld.loadedEntityList;
	}
	
	public static WorldClient getWorld() {
		return (WorldClient) mc.theWorld;
	}
	
	public static EntityPlayerSP getPlayer() {
		return mc.thePlayer;
	}
	
	public static Block getBlockClass() {
		return block;
	}
	
	public static EntityLiving getEntityLiving() {
		return entityLiving;
	}

	public static File getMCDir() {
		return Minecraft.getMinecraftDir();
	}

	public static Minecraft getMinecraft() {
		return mc;
	}

	public static EntityPlayerSP getEntityPlayerSP() {
		return entityPlayerSP;
	}

	public static EntityRenderer getEntityRenderer() {
		return entityRenderer;
	}

	public static EntityPlayer getEntityPlayer() {
		return entityPlayer;
	}

}
