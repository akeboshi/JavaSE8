/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex16;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CityStateZip {
	public static void main (String[] args){
		parseAddress("1600 Pennsylvania Ave NW Washington, DC 20500");
		parseAddress("1600 Pennsylvania Ave NW Washington, DC 20500-1111");
		parseAddress("1600 Pennsylvania Ave NW Washington, DC 2050");
		parseAddress("1600 Pennsylvania Ave NW Washington, DC 20500, foobar");
		parseAddress("1600 Pennsylvania Ave NW Washington, DC 20500");
	}

	public static void parseAddress(String address) {
		Pattern pattern = Pattern.compile("(?<city>[\\p{L} 0-9]+),\\s*(?<state>[A-Z]{2})\\s+(?<zipcode>[0-9]{5}|[0-9]{5}-[0-9]{4})");
		Matcher mat = pattern.matcher(address);
		if (mat.matches())
			System.out.println("city: " + mat.group("city") + "\nstate: " + mat.group("state") + "\nzip:" + mat.group("zipcode"));
		else
			System.out.println("can't parse: " + address);
	}
}