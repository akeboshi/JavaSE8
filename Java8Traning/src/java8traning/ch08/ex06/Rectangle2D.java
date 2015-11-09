/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch08.ex06;


import java.awt.*;
import java.util.Comparator;

public class Rectangle2D {
	private final int x;
	private final int y;
	private final int width;
	private final int height;

	public static Comparator<Rectangle2D> comp = Comparator.comparing(Rectangle2D::getX)
			.thenComparing(Rectangle2D::getY)
			.thenComparing(Rectangle2D::getHeight)
			.thenComparing(Rectangle2D::getWedth);

	public static void main(String[] args){
		Rectangle2D a = new Rectangle2D(0,0,10,20);
		Rectangle2D b = new Rectangle2D(0,0,10,10);
		Rectangle2D c = new Rectangle2D(0,0,20,10);
		Rectangle2D d = new Rectangle2D(0,0,10,20);
		System.out.println(comp.compare(a,b));
		System.out.println(comp.compare(a,c));
		System.out.println(comp.compare(a,d));
		System.out.println(comp.compare(b,c));
	}

	public Rectangle2D(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWedth() { return width;}

	public int getHeight() {return height;}

}