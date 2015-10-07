/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex05;


import java.time.Duration;
import java.time.LocalDate;

public class PlzTellYourBirthday {
	public static void main (String[] args) {
		System.out.println(livingDays(LocalDate.of(1987, 6,24)));
	}

	public static long livingDays(LocalDate birth) {
		return Duration.between(birth.atTime(0,0), LocalDate.now().atTime(0,0)).toDays() + 1;
	}

}
