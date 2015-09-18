/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex07;


import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MaxKeyCoffee {
	private static final int countNum = 100_000;
	public static void main(String[] args){
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		Random r = new Random();
		Long max = Long.MIN_VALUE;
		long tmp;
		for (int i = 0 ; i < countNum ; i++ ) {
			tmp = r.nextLong();
			if (max < tmp) max = tmp;
			map.put(Integer.toString(i),tmp);
		}
		Map.Entry<String, Long> actual = getMax(map);
		System.out.println("actual:" + actual.getKey() + ", " + actual.getValue() + "\nexpected:" + max);
		if (!max.equals(actual.getValue())) throw new AssertionError();
	}

	public static Map.Entry<String, Long> getMax(ConcurrentHashMap<String, Long> map) {
		return map.reduceEntries(Long.MIN_VALUE,(x,y) ->
			x.getValue() > y.getValue() ? x: y
		);

	}
}