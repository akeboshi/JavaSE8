/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllLinks {
	public static void main (String[] args) {
		try {
			List<String> list = getLinks(getWebPage("http://google.co.jp"));
			list.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public static String getWebPage(String url) throws Exception{
		URL page = new URL(url);
		InputStream in = page.openStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(in, "JISAutoDetect"));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static List<String> getLinks(String page) {
		String inPattern = "<a\\s+href\\s*=\\s*\"([^\"]+)\"\\s*";
		Pattern pattern = Pattern.compile(inPattern);
		Matcher matcher = pattern.matcher(page);
		List<String> result = new ArrayList<>();
		while(matcher.find()){
			result.add(matcher.group(1));
		}
		return result;
	}
}