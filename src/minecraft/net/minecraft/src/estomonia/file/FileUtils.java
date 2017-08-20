package net.minecraft.src.estomonia.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class FileUtils {

	private static File dir;

	public FileUtils() {
		dir = new File(Minecraft.getMinecraftDir() + File.separator + "Estomonia");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		makeWelcome();
	}

	private static void makeWelcome() {
		try {
			File file = new File(dir.getAbsolutePath(), "welcome.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("Welcome to " + "Estomonia" + "!");
			out.newLine();
			out.write("For the betalands community, owned by Sweetz.");
			out.newLine();
			out.write("I hope you enjoyed this more then I did making it.");
			out.newLine();
			out.write("~Jay");
			out.close();
		} catch (IOException e) {

		}
	}

}
