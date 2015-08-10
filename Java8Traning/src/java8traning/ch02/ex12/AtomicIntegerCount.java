/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class AtomicIntegerCount {
	private static int length = 5;
	public static List<Integer> count(Stream<String> stream) {
		AtomicInteger[] ai = new AtomicInteger[length];
		for (int i = 0; i < length ; i++)
			ai[i] = new AtomicInteger();
		stream.parallel().forEach(w -> {
			if (w.length() < length)
				ai[w.length()].getAndIncrement();
		});
		List<Integer> li = new ArrayList<>();
		Arrays.asList(ai).stream().forEach(a -> {
			li.add(a.get());
		});
		return li;
	}
}