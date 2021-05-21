package com.blackdragon2447.AAMS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * the utils class, contains multiple utility methods
 * @author Blackdragon2447
 */
public class Utils {
	
	static File userfolder = new File("users");
	
	public static <T>T[] AddToArray(T[] arr, T obj) {
	    arr = Arrays.copyOf(arr, arr.length + 1);
	    arr[arr.length - 1] = obj;
	    return arr;
	}
	
	public static String findUser(String SteamID) {
		File[] users = userfolder.listFiles();
		File user;
		String filename = SteamID + ".user";
		System.out.println(filename);
		for (File file : users) {
			System.out.println(file.getName());
			if(file.getName().equals(filename)) {
				user = file;
				try {
					System.out.println("user found");
					return fileToSting(user);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("user not found");
		return null;
	}
	
	public static String fileToSting(File file) throws IOException {
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
				result = result + line;
		    }
		}
		System.out.println(result);
		return result;
	}
	
}
