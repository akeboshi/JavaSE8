/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex04;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class Maaaaaaaaax {
	private static final int countNum = 100_000;
	public static void main(String[] args){
		Random r = new Random();
		long[] val = new long[countNum];
		long max = Long.MIN_VALUE;
		long tmp;
		for (int i = 0 ; i < countNum ; i++ ) {
			tmp = r.nextLong();
			max = max > tmp ? max : tmp;
			val[i] = tmp;
		}
		long actual = getMax(val);
		if (max != actual) throw new AssertionError();
		System.out.println(actual);
	}

	public static long getMax(long[] val) {
		LongAccumulator max = new LongAccumulator(Math::max, Long.MIN_VALUE);
		Arrays.stream(val).parallel().forEach(x -> max.accumulate(x));
		return max.get();
	}
}