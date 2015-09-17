/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex09;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class LessThan {
	public static void main(String[] args) {
getLessThanOneHour().forEach(System.out::println);
	}

	public static List<String> getLessThanOneHour(){
		List<String> list = new ArrayList<>();
		ZoneId.getAvailableZoneIds().stream()
				.map(z -> ZonedDateTime.now(ZoneId.of(z)))
				.filter(z -> z.getOffset().getTotalSeconds() % (60 * 60) != 0 )
				.forEach(off -> list.add(
						off.getZone().getId() + " " + off.getOffset().toString()));
		return list;
	}
}
