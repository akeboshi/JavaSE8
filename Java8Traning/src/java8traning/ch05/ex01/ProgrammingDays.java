/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex01;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingDays {
	public static LocalDate get() {
		return get(LocalDate.now().getYear());
	}

	public static LocalDate get(int year) {
		return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
	}

	public static List<LocalDate> get (int startYear, int endYear) {
		if (startYear > endYear) {
			int tmp = startYear;
			startYear = endYear;
			endYear = tmp;
		}
		List<LocalDate> list = new ArrayList<>();
		for (int i = startYear; i < endYear ; i++) {
			list.add(get(i));
		}
		return list;
	}

}
