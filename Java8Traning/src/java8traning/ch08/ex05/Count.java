/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex05;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Count {

	public static void main(String[] args){
		try {
			String contents = new String(Files.readAllBytes(
					Paths.get("/Users/akari/IdeaProjects/JavaSE8/Java8Traning/warAndPease.txt")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			long answer1, answer2;
			long start, end;

			start = System.nanoTime();
			answer1 = countStream(words);
			end = System.nanoTime();
			System.out.println("stream   count: " + answer1 + "\ntime: " + (end - start));

			start = System.nanoTime();
			answer2 = countForEach(words);
			end = System.nanoTime();
			System.out.println("foreach  count: " + answer2 + "\ntime: " + (end - start));
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public static long countStream(List<String> words){
		long counter = 0L;
		for (int i = 0 ; i < 100 ; i++)
		counter += words.stream().filter(w -> w.length() > 12).count();
		return counter;
	}

	public static long countForEach(List<String> words){
		AtomicLong counter = new AtomicLong(0L);
		for (int i = 0 ; i < 100 ; i++)
			words.forEach(w -> {
				if (w.length() > 12)
					counter.incrementAndGet();
			});
		return counter.get();
	}
}