/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex03;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

public class Measure {
	private static final int threadNum = 1000;
	private static final int countNum = 100_000;
	public static void main(String[] args){
		System.out.println("AtomicLong : " + measureAtomicLong());
		System.out.println("LongAdder  : " + measureLongAdder());
		System.out.println("LongAdderのほうが一桁早い");
	}

	public static long measureAtomicLong() {
		AtomicLong counter = new AtomicLong();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0 ; i < threadNum ; i ++ ) {
			threads.add(new Thread(() -> {
				for(int j = 0 ; j < countNum ; j++) {
					counter.incrementAndGet();
				}
			}));
		}
		long start = System.nanoTime();
		threads.stream().forEach(t -> t.start());
		threads.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		long end = System.nanoTime();
		if (counter.get() != threadNum * countNum)
			throw new AssertionError("計算間違ってるお？");
		return end - start;
	}

	public static long measureLongAdder() {
		LongAdder counter = new LongAdder();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0 ; i < threadNum ; i ++ ) {
			threads.add(new Thread(() -> {
				for(int j = 0 ; j < countNum ; j++) {
					counter.increment();
				}
			}));
		}
		long start = System.nanoTime();
		threads.stream().forEach(t -> t.start());
		threads.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		long end = System.nanoTime();

		if (counter.sum() != threadNum * countNum)
			throw new AssertionError("計算間違ってるお？");
		return end - start;
	}


}