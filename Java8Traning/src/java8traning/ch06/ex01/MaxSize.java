/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex01;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MaxSize {
	public static void main (String[] args){
		try{
		String contents = new String(Files.readAllBytes(
				Paths.get("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/alice30.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		System.out.println(get(words));
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public static String get(List<String> words) {
		AtomicReference<String> max = new AtomicReference<>("");
		List<Thread> threads = new ArrayList<>();
		int cores = Runtime.getRuntime().availableProcessors();
		int wordsSize = words.size();
		int tSize = wordsSize / cores +  cores;
		System.out.println(cores + " " + wordsSize + " " + tSize);
		for (int i = 0 ; i < wordsSize ; i += tSize ) {
			int start = i;
			int end = (i + tSize) > wordsSize ? wordsSize : i + tSize;
			threads.add(new Thread(() -> {
				for(int j = start ; j < end ; j++) {
					max.accumulateAndGet(words.get(j),(x,y) ->
						x.length() > y.length() ? x : y
					);
				}
			}));
		}
		threads.stream().forEach(t -> t.start());
		threads.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		return max.get();
	}
}