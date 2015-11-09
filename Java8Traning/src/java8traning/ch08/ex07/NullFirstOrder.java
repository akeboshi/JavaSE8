/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex07;


import java.util.Comparator;

public class NullFirstOrder {
	public static <T extends Comparable<? super T>> Comparator<T> nullFirstReverse (){
		return Comparator.nullsLast(Comparator.reverseOrder());
	}


}