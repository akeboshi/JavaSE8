/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex02;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PlusYear {
	public static void main (String[] args) {
		LocalDate leapDay = LocalDate.of(2000, 2, 29);
		// 2001年2月29日が無いため、2月の最後の日付の28日になる。
		System.out.println(LocalDate.from(leapDay).plusYears(1));
		// ちゃんとうるう年に対応してる
		System.out.println(LocalDate.from(leapDay).plusYears(4));
		// うるう年が無い年に、29日の情報が消えているため、2004年2月28日になる
		System.out.println(LocalDate.from(leapDay).plusYears(1).plusYears(1).plusYears(1).plusYears(1));
	}

}
