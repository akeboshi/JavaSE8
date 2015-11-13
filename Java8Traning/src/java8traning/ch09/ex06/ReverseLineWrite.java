/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex06;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLineWrite {
	public static void main(String[] args){
		try {
			reverseWrite("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice30.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reverseWrite(String path) throws IOException{
		List<String> data = Files.readAllLines(Paths.get(path));
		Collections.reverse(data);
		Files.write(Paths.get("/tmp/reverse.txt"), data);
	}
}