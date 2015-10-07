/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex11;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
ロサンジェルスからフランクフルト行きの便は、ローカル時刻の3時5分に出発し、 10時間50分の飛行です。何時に到着しますか。このような計算を処理できる プログラムを書きなさい。

帰りの便は、フランクフルトを14時5分に出発し、ロサンジェルスに16時40分に到着します。 飛行時間は、何時間何分ですか。このような計算を処理できるプログラムを書きなさい。
 */
public class Flight {
	public static void main(String[] args) {
		System.out.println(arriveTime("America/Los_Angeles", "CET", LocalDateTime.of(2015, 9, 27, 15, 50), 650));
		System.out.println(flightTime(ZonedDateTime.of(2015, 9, 27, 14, 5, 0, 0, ZoneId.of("CET")),
				ZonedDateTime.of(2015, 9, 27, 16, 40, 0, 0 , ZoneId.of("America/Los_Angeles"))));
	}

	public static ZonedDateTime arriveTime(String departureZoneId, String arriveZoneId,
										   LocalDateTime departureTime, int flightingMinutes){
		return ZonedDateTime.of(departureTime,
						ZoneId.of(departureZoneId))
						.plusMinutes(flightingMinutes)
						.withZoneSameInstant(ZoneId.of(arriveZoneId));
	}

	public static String flightTime(ZonedDateTime departure, ZonedDateTime arrival){
		long minutes = flightMinutes(departure,arrival);
		return (minutes / 60) + "時間" + (minutes % 60) + "分";
	}

	public static long flightMinutes(ZonedDateTime departure, ZonedDateTime arrival) {
		return Duration.between(departure,arrival).toMinutes();
	}

}
