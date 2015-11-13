/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex03;

public class GCD {
	public static void main(String[] args){
		System.out.println(percent(96, 68));
		System.out.println(percent(96, -68));
		System.out.println(percent(-96, 68));
		System.out.println(percent(-96, -68));
		System.out.println(percent(68, 96));
		System.out.println(percent(68, -96));
		System.out.println(percent(-68, 96));
		System.out.println(percent(-68, -96));
		System.out.println(percent(-68, 0));
		System.out.println(percent(0, -96));
		System.out.println(percent(12, 32));
		System.out.println(percent(32, -12));
		System.out.println(percent(-32, 12));
		System.out.println(percent(28, 8));
		System.out.println(percent(8, 28));
		System.out.println(floorM(32, 12));
		System.out.println(floorM(-32, 12));
		System.out.println(floorM(32, -12));
		System.out.println(floorM(12, 32));
		System.out.println(rem(0, 12));
		System.out.println(rem(-32, 12));
		System.out.println(rem(32, -12));
		System.out.println(rem(-32, -12));
	}

	public static int percent(int a, int b) {
		if (b == 0) return Math.abs(a);
		return a % b == 0 ? Math.abs(b) : percent(b, a % b);
	}

	public static int floorM(int a, int b) {
		if (b == 0) return Math.abs(a);
		return Math.floorMod(a, b) == 0 ? Math.abs(b) : floorM(b, Math.floorMod(a, b));
	}

	public static int rem(int a, int b) {
		if (b == 0) return Math.abs(a);
		return Integer.remainderUnsigned(a, b) == 0 ? b : rem(b, Integer.remainderUnsigned(a, b));
	}
}
