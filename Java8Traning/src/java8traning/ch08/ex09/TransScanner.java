/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex09;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TransScanner {
	public static Stream<String> lines(Scanner scanner) {
		Iterator<String> iter = new Iterator<String>() {
			String nextLine = null;

			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					nextLine = scanner.nextLine();
					return (nextLine != null);
				}
			}

			@Override
			public String next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;
					return line;
				} else {
					throw new NoSuchElementException();
				}
			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}



}