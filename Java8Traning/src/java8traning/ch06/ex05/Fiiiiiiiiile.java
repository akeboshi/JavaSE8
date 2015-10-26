/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex05;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Fiiiiiiiiile {
	public static void main(String[] args){
		List<File> files = new ArrayList<>();
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice30.txt"));
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice301.txt"));
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice302.txt"));
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/warAndPease.txt"));
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/warAndPease1.txt"));
		files.add(new File("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/warAndPease2.txt"));
		Map<String, Set<File>> map = set(files);
		map.get("is").stream().forEach(System.out::println);
	}

	public static Map<String, Set<File>> set(List<File> files) {
		ConcurrentHashMap<String, Set<File>> chm = new ConcurrentHashMap<>();
		files.parallelStream().forEach(file -> {
			String contents = null;
			try {
				contents = new String(Files.readAllBytes(file.toPath()),StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			Set<File> set = new HashSet<>();
			set.add(file);
			words.stream().forEach(word -> chm.merge(word, set, (x, y) -> {
				Set<File> s = new HashSet<>();
				s.addAll(x);
				s.addAll(y);
				return s;
			}));
		});
		return chm;
	}
}