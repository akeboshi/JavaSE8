/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class GroupeByCount {
	private static int length = 5;

	public static List<Integer> count(Stream<String> stream) {
		AtomicInteger[] ai = new AtomicInteger[length];

		Map<Integer, Long> map = stream.filter(w -> (w.length() < length))
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));

		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < length ; i++)
			li.add(map.get(i).intValue());
		return li;
	}
}