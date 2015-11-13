/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex08;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Point implements Comparable<Point>{
	private int x;
	private int y;

	public static void main(String[] args){
		Point p1 = new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);
		Point p2 = new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);
		Point p3 = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);

		if (p1.compareTo(p2) != 0)
			throw new AssertionError();
		if (p1.compareTo(p3) != -1)
			throw new AssertionError();
	}

	public Point(int x, int y){
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (x < o.getX() || y < o.getY())
			return -1;
		if (x > o.getX() || y > o.getY())
			return 1;
		return 0;
	}
}