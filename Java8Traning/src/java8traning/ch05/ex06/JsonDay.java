/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex06;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonDay {
	public  static void main (String[] args){
		get(20).forEach(System.out::println);
	}

	public static List<LocalDate> get(int century){
		List<LocalDate> jsonDays = new ArrayList<>();
		LocalDate first = LocalDate.ofYearDay((century - 1) * 100 + 1, 13);
		LocalDate end = LocalDate.ofYearDay(century * 100 + 1, 1).minusDays(1);
		for (;first.isBefore(end); first = first.plusMonths(1)){
			if (first.getDayOfWeek() == DayOfWeek.FRIDAY)
				jsonDays.add(first);
		}
		return jsonDays;
	}

}
