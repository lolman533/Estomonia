package net.minecraft.src.estomonia.utils;

import net.minecraft.src.estomonia.Estomonia;

public class ConsoleLogger {

	public static void log(String msg) {
		System.out.println("[" + Estomonia.instance.name + "]" + " " + msg);
	}
	
}
