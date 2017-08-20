package net.minecraft.src.estomonia;

import java.util.Arrays;

import net.minecraft.src.estomonia.file.FileUtils;
import net.minecraft.src.estomonia.utils.ConsoleLogger;

/**
 * Estomonia. 
 * @author Jay
 */

public class Estomonia {

	public static final Estomonia instance = new Estomonia();
	
	public final String name = "Estomonia";
	public final String version = "v2.0";
	
	public final String[] authors = { "Jay" };	
	
	/* Management */
	public final FileUtils fileUtils = new FileUtils();
	
	/* Client Initialisation */
	public void onEnable() {
		try{
			ConsoleLogger.log("Client Initialised Successfully.");
			ConsoleLogger.log("Client Coded by: " + Arrays.asList(authors));
		}catch(Exception e) {
			ConsoleLogger.log("Client failed to Initialise");
		}
	}
	
}
