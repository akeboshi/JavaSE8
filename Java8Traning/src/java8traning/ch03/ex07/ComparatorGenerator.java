/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */
package java8traning.ch03.ex07;

import java.util.Comparator;

/**
 * Created by akari on 2015/08/11.
 */
public class ComparatorGenerator {
	public static Comparator<String> generate (
			boolean reverse,
			boolean ignoreCase,
			boolean ignoreSpace) {
		return (s1, s2) -> {
			int reversed = reverse ? -1 : 1;
			if (ignoreCase) {
				s1 = s1.toLowerCase();
				s2 = s2.toLowerCase();
			}
			if (ignoreSpace) {
				s1 = s1.replaceAll("\\s", "");
				s2 = s2.replaceAll("\\s", "");
			}
			return s1.compareTo(s2) * reversed;
		};
	}
}
