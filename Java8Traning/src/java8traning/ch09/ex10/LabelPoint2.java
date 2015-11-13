/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex10;


import java.util.Objects;

public class LabelPoint2 implements Comparable<LabelPoint2>{
	private String label;
	private int x;
	private int y;

	public static void main(String[] args){
		LabelPoint2 p = new LabelPoint2(Integer.MIN_VALUE,Integer.MIN_VALUE,"foo");
		LabelPoint2 p1 = new LabelPoint2(Integer.MIN_VALUE,Integer.MIN_VALUE,"foo");
		LabelPoint2 p2 = new LabelPoint2(Integer.MIN_VALUE,Integer.MIN_VALUE,"bar");
		LabelPoint2 p3 = new LabelPoint2(Integer.MAX_VALUE,Integer.MAX_VALUE,"foo");

		if (!p1.equals(p))
			throw new AssertionError();
		if (p1.equals(p2))
			throw new AssertionError();
		if (p1.equals(p3))
			throw new AssertionError();
		if (!(p.hashCode() == p1.hashCode() && p.hashCode() != p2.hashCode() && p.hashCode() != p3.hashCode()))
			throw new AssertionError();
	}

	public LabelPoint2(int x, int y, String label){
		setX(x);
		setY(y);
		setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(LabelPoint2 o) {
		if (x < o.getX() || y < o.getY())
			return -1;
		if (x > o.getX() || y > o.getY())
			return 1;
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if (!(obj instanceof LabelPoint2)) return false;
		LabelPoint2 obje = (LabelPoint2) obj;
		if (x == obje.getX() && y == obje.getY() && label.equals(obje.getLabel()))
			return true;
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(x,y,label);
	}
}