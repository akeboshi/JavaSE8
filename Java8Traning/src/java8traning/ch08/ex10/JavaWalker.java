/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex10;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaWalker{

	public static void grepDir(String dir, List<String> names){
		try {
			try (Stream<Path> paths = Files.walk(Paths.get(dir))){
				paths.filter(p -> !p.toFile().isDirectory()).filter(p -> {
					try {
						return Files.lines(p).anyMatch(s -> names.stream().anyMatch(n -> s.contains(n)));
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
				}).forEach(p -> System.out.println(p));
			}
		} catch (Exception e){
			System.out.println(e);
		}
	}
}