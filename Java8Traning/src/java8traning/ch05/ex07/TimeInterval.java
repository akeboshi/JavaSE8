/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex07;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeInterval {
	private LocalDateTime start;
	private LocalDateTime end;

	public TimeInterval(LocalDateTime start, LocalDateTime end){
		if (start.isBefore(end)){
			this.start = start;
			this.end = end;
		} else {
			this.start = end;
			this.end = start;
		}
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public boolean check (TimeInterval time) {
		if (this.start.isBefore(time.getStart())) {
			return this.end.isBefore(time.getEnd());
		} else {
			return time.getEnd().isBefore(this.end);
		}
	}

}
