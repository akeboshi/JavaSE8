/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex08;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TransScanner extends BufferedReader{
	public TransScanner(Reader in, int sz) {
		super(in, sz);
	}

	public Stream<String> lines() {
		Iterator<String> iter = new Iterator<String>() {
			String nextLine = null;

			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = readLine();
						return (nextLine != null);
					} catch (IOException e) {
						throw new UncheckedIOException(e);
					}
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