/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Grep {
	public static void main (String[] args){
		grep("/Users/akari/.bashrc","&&");
	}

	public static void grep(String path, String pat) {
		try {
			Pattern pattern = Pattern.compile(pat);
			Stream<String> lines = Files.lines(Paths.get(path));
			lines.filter(pattern.asPredicate()).forEach(
					l -> System.out.println(path + ": " + l)
			);
		} catch (Exception e){
			System.out.println(e);
		}
	}
}