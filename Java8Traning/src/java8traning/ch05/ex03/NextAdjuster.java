/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex03;


import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class NextAdjuster {
	public static TemporalAdjuster next (Predicate<LocalDate> predicate) {
		return w -> {
			LocalDate result = (LocalDate) w;
			do {
				result = result.plusDays(1);
			} while (!predicate.test(result));
			return result;
		};
	}
}
