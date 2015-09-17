/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex10;


import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Flight {
	public static void main(String[] args) {
		System.out.println(
		ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 5)),
				ZoneId.of("America/Los_Angeles"))
				.plusMinutes(650)
				.withZoneSameInstant(ZoneId.of("CET"))
				.toLocalDateTime());
	}
}
