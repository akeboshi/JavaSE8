/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex02;


public class NegateExactCheck {
	public static void main(String[] args){
		try {
			Math.negateExact(Integer.MIN_VALUE);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException: Math.negateExact(Integer.MIN_VALUE);");
		}

		try {
			Math.negateExact(Long.MIN_VALUE);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException: Math.negateExact(Long.MIN_VALUE);");
		}

		try {
			Math.negateExact(Integer.MAX_VALUE);
			Math.negateExact(0);
			Math.negateExact(Long.MAX_VALUE);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException: Math.negateExact(etc);");
		}
	}
}