/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex01;


import java.util.Arrays;
import java.util.Random;

public class UnsignedCalc {
	public static void main(String[] args){
		System.out.println(Integer.toUnsignedLong(Integer.MIN_VALUE));
		Integer foo = -1;
		Integer bar = (int)(Math.pow(2,32) - 1);
		System.out.println(bar);
		System.out.println(Integer.toUnsignedLong(foo) + ":" + foo);
		Integer bar2 = Integer.remainderUnsigned(bar, 2);
		Integer hoge = bar /2;
		System.out.println(Integer.toUnsignedString(bar2) + ":" + Integer.toUnsignedString(hoge));
		System.out.println(Integer.MIN_VALUE + ":" + Long.MIN_VALUE);
		Math.negateExact(Integer.MIN_VALUE);
	}
}