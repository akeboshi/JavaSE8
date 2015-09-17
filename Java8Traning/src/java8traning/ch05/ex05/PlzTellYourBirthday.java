/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class PlzTellYourBirthday {
	public static void main (String[] args) {
		System.out.println(livingDays(LocalDate.of(1987, 6,24)));
	}

	public static long livingDays(LocalDate birth) {
		return Duration.between(birth.atTime(0,0), LocalDate.now().atTime(0,0)).toDays() + 1;
	}

}
