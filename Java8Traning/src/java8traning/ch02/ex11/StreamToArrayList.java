/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class StreamToArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<>();
		for (Integer j = 0; j < 100; j++) {
			ali.add(j);
		}
		StreamToArrayList.stream2ArrayList(ali.stream(), 100).stream()
				.forEach(System.out::println);
		;
	}

	public static <T> ArrayList<T> stream2ArrayList(Stream<T> stream, int size) {
		Counter c = new Counter();
		ArrayList<T> list = new ArrayList<>();
		for (int i = 0; i < size ; i++)
			list.add(null);
		stream.parallel().forEach(x -> {
			list.set(c.getAndInc(), x);
		});
		return list;
	}
}

class Counter {
	Integer count = 0;

	public synchronized int getAndInc() {
		return count++;
	}
}
