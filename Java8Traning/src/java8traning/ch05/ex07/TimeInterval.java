/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex07;

import java.time.LocalDateTime;

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

	public boolean checkCross8 (TimeInterval time) {
		TimeInterval first = this;
		TimeInterval second = time;
		if (this.getStart().isAfter(time.getStart())){
			first = time;
			second = this;
		}
		return first.getEnd().isBefore(second.getStart());
	}

}
