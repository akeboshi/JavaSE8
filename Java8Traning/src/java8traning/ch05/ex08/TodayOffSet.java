/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex08;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodayOffSet {
	public static void main(String[] args) {
get().forEach(System.out::println);
	}

	public static List<String> get(){
		List<String> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		ZoneId.getAvailableZoneIds().stream()
				.map(z -> ZonedDateTime.of(now,ZoneId.of(z)))
				.forEach(off -> list.add(
						off.getZone().getId() + " " + off.getOffset().toString()));
		return list;
	}
}
