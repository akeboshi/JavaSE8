/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex08;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MeritOfCheckdQue {
	public static void main(String[] args){
		Queue queue = new LinkedList<Integer>();
		queue.add("for");
		queue.add(100);

		for (Object o: queue){
			try {
				if ((Integer) o == 100)
					System.out.println("Good");
			} catch (Exception e){
				System.out.println("get ClassCastException. expected Integer, but get String");
			}
		}

		queue = new LinkedList();
		queue = Collections.checkedQueue(queue, Integer.class);

		try {
			queue.add("foo");
			queue.add(100);
		}catch (Exception e){
			System.out.println("expected ClassCastException");
		}

		for (Object o: queue){
			try {
				if ((Integer) o == 100)
					System.out.println("Good");
			} catch (Exception e){
				System.out.println("get ClassCastException. expected Integer, but get String");
			}
		}
	}



}