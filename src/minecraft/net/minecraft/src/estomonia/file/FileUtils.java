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
			out.write("witaj w " + "Estomonii" + "!");
			out.newLine();
			out.write("Dla spolecznosci betalands Sweetz'a.");
			out.newLine();
			out.write("Mam nadzieje, ze bawisz sie lepiej niz ja przy kodowaniu tego.");
			out.newLine();
			out.write("~Jay");
			out.close();
		} catch (IOException e) {

		}
	}

}
