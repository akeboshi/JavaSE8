/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex04;


import java.util.Random;
import java.util.stream.LongStream;

public class NextNextNext {
	private static long v = 246154705703781L;
	private static long N = 281474976710656L;
	private static long m = 25214903917L;
	private static long a = 11;

	public static void main(String[] args){
		long s = LongStream.iterate(prev(0), p -> prev(p))
				.map(p -> p ^ m)
				.limit(1_000_000)
				.reduce((x, y) -> Math.abs(x) < Math.abs(y) ? x : y)
				.getAsLong();
		System.out.println(s);
		Random r = new Random(s);
		for(int i = 0 ; i < 376049 ; i ++){
			r.nextDouble();
		}
		System.out.println(r.nextDouble());
	}

	public static long prev (long s) {
		return (s - a) * v % N;
	}
}