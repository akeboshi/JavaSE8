/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex05;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseWrite {
	public static void main(String[] args){
		try {
			reverseWrite("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice30.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reverseWrite(String path) throws IOException{
		byte[] data = Files.readAllBytes(Paths.get(path));
		byte[] result = new byte[data.length];
		for (int i = 0 ; i < data.length ; i++)
			result[i] = data [data.length - i - 1];
		Files.write(Paths.get("/tmp/reverse.txt"), result);
	}
}