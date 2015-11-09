/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex06;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Point2D {
	private final int x;
	private final int y;

	public static Comparator<Point2D> comp = Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY);

	public static void main(String[] args){
		Point2D a = new Point2D(0,0);
		Point2D b = new Point2D(1,0);
		Point2D c = new Point2D(0,1);
		Point2D d = new Point2D(0,0);
		System.out.println(comp.compare(a,b));
		System.out.println(comp.compare(a,c));
		System.out.println(comp.compare(a,d));
		System.out.println(comp.compare(b,c));
	}

	public Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

}