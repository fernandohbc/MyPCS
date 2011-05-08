/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. In other words, use it
 * at your own risk.
 * 
 * If you find this a little useful, you can buy the author some beer.
 * If you find this really useful, you can buy a kid a book, and help making
 * the world more literate.
 */
//Problem 109: Circle Through Three Points
package volume_i;

import java.util.StringTokenizer;

public class P109_3747 {

	static String readLn() {
		String newLine = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		int car = -1;
		try {
			car = System.in.read();
			while ((car > 0) && (car != newLine.charAt(0))) {
				buffer.append((char) car);
				car = System.in.read();
			}
			if (car == newLine.charAt(0))
				System.in.skip(newLine.length() - 1);
		} catch (java.io.IOException e) {
			return (null);
		}
		if ((car < 0) && (buffer.length() == 0))
			return (null);
		return (buffer.toString().trim());
	}

	public static void main(String[] args) {
		try {
			new P109_3747().begin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void begin() throws Exception {
		String line = readLn();
		while (line != null) {
			StringTokenizer st = new StringTokenizer(line);

			double xa = Double.parseDouble(st.nextToken());
			double ya = Double.parseDouble(st.nextToken());
			Point a = new Point(xa, ya);

			double xb = Double.parseDouble(st.nextToken());
			double yb = Double.parseDouble(st.nextToken());
			Point b = new Point(xb, yb);

			double xc = Double.parseDouble(st.nextToken());
			double yc = Double.parseDouble(st.nextToken());
			Point c = new Point(xc, yc);

			Circle o = new Circle(a, b, c);

			o.printHKString();
			o.printCDEString();
			
			System.out.println();

			line = readLn();
		}
	}
}

class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public Point findMiddle(Point b) {
		double newx = (this.getX() + b.getX()) / 2;
		double newy = (this.getY() + b.getY()) / 2;
		return new Point(newx, newy);
	}

	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

	public double getDistance(Point a) {
		return Math.sqrt((a.getX() - this.getX()) * (a.getX() - this.getX())
				+ (a.getY() - this.getY()) * (a.getY() - this.getY()));
	}
}

class Line {
	private double n;
	private double l;

	private double fixedX;

	public Line(Point a, Point b) {
		this.n = (a.getY() - b.getY()) / (a.getX() - b.getX());
		this.l = a.getY() - n * a.getX();
		this.fixedX = a.getX();
	}

	private Line() {
	}

	public Line getOrthogonal(Point mab) {
		Line result = new Line();
		if (this.isVertical()) {
			result.setN(0);
			result.setL(mab.getY());
		} else if (this.isHorizotnal()) {
			result.setN(Double.NaN);
			result.setL(Double.NaN);
			result.setFixedX(mab.getX());
		} else {
			double newN = -1 / this.getN();
			double newL = mab.getY() - newN * mab.getX();
			result.setN(newN);
			result.setL(newL);
		}
		return result;
	}

	private double getN() {
		return n;
	}

	private void setFixedX(double fixedX) {
		this.fixedX = fixedX;
	}

	private void setL(double l) {
		this.l = l;

	}

	private void setN(double n) {
		this.n = n;
	}

	private boolean isHorizotnal() {
		return n == 0;
	}

	private boolean isVertical() {
		return Double.isNaN(n);
	}

	public Point getIntersection(Line l) throws Exception {
		double xint = 0;
		double yint = 0;
		if (this.getN() == l.getN()) {
			throw new Exception("Lines are parallel");
		} else {
			if (this.isVertical()) {
				xint = this.getFixedX();
				yint = l.getY(xint);
			} else if (l.isVertical()) {
				xint = l.getFixedX();
				yint = this.getY(xint);
			} else {
				xint = (l.getL() - this.getL()) / (this.getN() - l.getN());
				yint = this.getY(xint);

			}
		}
		Point intersection = new Point(xint, yint);
		return intersection;
	}

	private double getFixedX() {
		return this.fixedX;
	}

	private double getY(double x) throws Exception {
		if (this.isVertical()) {
			throw new Exception("The line is vertical");
		} else {
			return n * x + l;
		}
	}

	private double getL() {
		return this.l;
	}
}

class Circle {
	private Point center;
	private double radius;

	public Circle(Point a, Point b, Point c) throws Exception {
		this.center = calcCenter(a, b, c);
		this.radius = center.getDistance(a);
	}

	public void printCDEString() {
		double h = this.getCenter().getX();		
		double k = this.getCenter().getY();
		double r = this.getRadius();
		
		double c = Math.abs(2 * h);
		char signal1 = h >= 0 ? '-' : '+';
		double d = Math.abs(2 * k);
		char signal2 = k >= 0 ? '-' : '+';
		double e = h*h + k*k - r*r;
		char signal3 = e >= 0 ? '+' : '-';
		e = Math.abs(e);
		
		System.out.printf("x^2 + y^2 %s %.3fx %s %.3fy %s %.3f = 0%n", signal1,
				c, signal2, d, signal3, e);
	}

	public void printHKString() {
		double h = Math.abs(this.getCenter().getX());
		char signal1 = this.getCenter().getX() >= 0 ? '-' : '+';
		double k = Math.abs(this.getCenter().getY());
		char signal2 = this.getCenter().getY() >= 0 ? '-' : '+';
		double r = Math.abs(this.getRadius());
		System.out.printf("(x %s %.3f)^2 + (y %s %.3f)^2 = %.3f^2%n", signal1,
				h, signal2, k, r);
	}

	private double getRadius() {
		return this.radius;
	}

	private Point getCenter() {
		return center;
	}

	private Point calcCenter(Point a, Point b, Point c) throws Exception {
		Line ab = new Line(a, b);
		Line bc = new Line(b, c);

		Point mab = a.findMiddle(b);
		Line rab = ab.getOrthogonal(mab);

		Point mbc = b.findMiddle(c);
		Line rbc = bc.getOrthogonal(mbc);

		Point center = rab.getIntersection(rbc);
		return center;
	}
}
