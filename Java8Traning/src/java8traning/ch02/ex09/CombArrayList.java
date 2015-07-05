/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class CombArrayList {
	public static <T> ArrayList<T> compArrayList1(Stream<ArrayList<T>> st) {
		return st.reduce((x, y) -> {
			ArrayList<T> al = new ArrayList<>();
			al.addAll(x);
			al.addAll(y);
			return al;
		}).get();
	}

	public static <T> ArrayList<T> compArrayList2(Stream<ArrayList<T>> st) {
		return st.reduce(new ArrayList<>(), (x, y) -> {
			x.addAll(y);
			return x;
		});
	}

	public static <T> ArrayList<T> compArrayList3(Stream<ArrayList<T>> st) {
		return st.reduce(new ArrayList<>(), (x,y) -> {
			x.addAll(y);
			return x;
		},
		(x,y) -> {
			x.addAll(y);
		return x;
		});
	}
}
