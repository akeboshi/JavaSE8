/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex08;


import java.util.Arrays;
import java.util.Random;

public class MyComputerSort {
	private static int ato = 2;
	public static void main(String[] args){
		int num = 10000;
		while (true) {
			long[] val = new long[num];
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				val[i] = r.nextLong();
			}
			long parallel = measureParallelSort(val.clone());
			long seq = measureSort(val.clone());
			if (seq > parallel) {
				System.out.println(num / ato + "から" + num + "のあいだ");
				break;
			}
			num *= ato;
		}
	}

	public static long measureSort(long[] val) {
		long start = System.nanoTime();
		Arrays.sort(val);
		return System.nanoTime() - start;
	}

	public static long measureParallelSort(long[] val) {
		long start = System.nanoTime();
		Arrays.parallelSort(val);
		return System.nanoTime() - start;
	}
}