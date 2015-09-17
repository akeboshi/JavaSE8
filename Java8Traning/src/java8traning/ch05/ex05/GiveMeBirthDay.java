/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.function.Predicate;

public class GiveMeBirthDay {
	public static void main(String[] args) {
		if (args.length != 3){
			System.out.println("ごめんなさい。引数3つ有るときしか対応してないんです。");
			return;
		}

		try {
			System.out.println(exec(args));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cal(args));
	}

	public static String cal(String[] args) {
		if (!args[0].toLowerCase().equals("cal"))
			throw new UnsupportedOperationException();
		int month, year;
		LocalDate ld;
		if (args.length == 3) {
			month = Integer.parseInt(args[1]);
			year = Integer.parseInt(args[2]);
			if (month < 1 || month > 12)
				return month + " is neither a month number (1..12) nor a name";
			ld = LocalDate.of(year, month, 1);
		} else {
			ld = LocalDate.now();
		}

		// ヘッダーの年、月を表示
		String strMonth = ld.getMonth().name();
		strMonth = strMonth.substring(0,1).toUpperCase() + strMonth.substring(1).toLowerCase();
		int charNum = strMonth.length() + Integer.toString(ld.getYear()).length() + 1;
		String headFormat = "%" + ((20 - charNum) / 2 + strMonth.length()) + "s %d\n";
		StringBuilder result = new StringBuilder(String.format(headFormat,strMonth,ld.getYear()));

		// 曜日表示
		result.append("Su Mo Tu We Th Fr Sa\n");

		// いろいろ頑張ってる
		int lastDay = ld.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
		String[] week = new String[7];
		String[] weekResult = new String[6];
		int weekNum = 0;
		for (int i = 0; i < 6; i++) weekResult[i] = "";
		for (int j = 0; j < 7; j++) week[j] = "";
		int pos = ld.getDayOfWeek().getValue();

		for (int i = 1; i <= lastDay ; i++,pos++) {
			week[pos % 7] = Integer.toString(i);
			if ((pos + 1) % 7 == 0 && pos != 0) {
				weekResult[weekNum ++] = getWeek(week);
				for (int j = 0; j < 7; j++) week[j] = "";
			}
		}
		if (!getWeek(week).equals("")) {
			weekResult[weekNum] = getWeek(week).replaceAll("   ", "").replaceAll("  ","");
		}

		for (int i = 0 ; i < 6 ; i++)
			result.append(weekResult[i] + "\n");
		result.deleteCharAt(result.length() -1 );

		return result.toString();
	}

	private static String getWeek(String[] week) {
		return String.format("%2s%3s%3s%3s%3s%3s%3s",
				week[0], week[1], week[2], week[3], week[4], week[5], week[6]);
	}

	/**
	 * only can exec on UNIX.
	 * @return calender
	 */
	public static String exec(String arg) throws IOException{
		return execProcess(Runtime.getRuntime().exec(arg));
	}

	public static String exec(String[] args) throws IOException{
			return execProcess(Runtime.getRuntime().exec(args));
	}


	private static String execProcess(Process process) throws IOException{
		StringBuilder sb = new StringBuilder();
			InputStream in = process.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String result;
			while ((result = br.readLine()) != null) {
				sb.append(result);
				sb.append("\n");
			}
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
