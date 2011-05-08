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
// @JUDGE_ID:  33089  476  Java  "Points in Figures: Rectangles"

// PLEASE, SUBMIT P477_33089

package volume_iv;

import java.util.StringTokenizer;
import java.util.Vector;

class P476_33089 {
//	//	Rotina de Leitura
//	static String readLn() {
//		String newLine = System.getProperty("line.separator");
//		StringBuffer buffer = new StringBuffer();
//		int car = -1;
//		try {
//			car = System.in.read();
//			while ((car > 0) && (car != newLine.charAt(0))) {
//				buffer.append((char) car);
//				car = System.in.read();
//			}
//			if (car == newLine.charAt(0))
//				System.in.skip(newLine.length() - 1);
//		} catch (java.io.IOException e) {
//			return (null);
//		}
//		if ((car < 0) && (buffer.length() == 0))
//			return (null);
//		return (buffer.toString().trim());
//	}
//
//	public static void main(String[] args) {
//		(new P476_33089()).begin();
//	}
//
//	private void begin() {
//		String input = readLn();
//		Vector v = new Vector();
//		StringTokenizer st;
//		while (!input.equals("*")) {
//			st = new StringTokenizer(input);
//			//ignora o r
//			st.nextToken();
//			double ulx = new Double(st.nextToken()).doubleValue();
//			double uly = new Double(st.nextToken()).doubleValue();
//			double lrx = new Double(st.nextToken()).doubleValue();
//			double lry = new Double(st.nextToken()).doubleValue();
//			Rectangle r = new Rectangle( ulx, uly, lrx, lry );
//			v.addElement(r);
//			input = readLn();
//		}
//		input = readLn();
//		int tc = 0;
//		while (!input.equals("9999.9 9999.9")) {
//			st = new StringTokenizer(input);
//			tc++;
//			boolean contains = false;
//			double x = new Double(st.nextToken()).doubleValue();
//			double y = new Double(st.nextToken()).doubleValue();
//			for ( int i = 0; i < v.size(); i++ ) {
//				Rectangle r = (Rectangle)v.elementAt(i);
//				if ( r.contains(x,y) ) {
//					System.out.println("Point "+tc+" is contained in figure "+(i+1));
//					contains = true;
//				}
//			}
//			if ( !contains ) {
//				System.out.println("Point "+tc+" is not contained in any figure");
//				
//			}
//			input = readLn();
//		}
//	}
//}
//
//class Rectangle {
//	private double ulx;
//	private double uly;
//	private double lrx;
//	private double lry;
//
//	public Rectangle(double ulx, double uly, double lrx, double lry) {
//		this.ulx = ulx;
//		this.uly = uly;
//		this.lrx = lrx;
//		this.lry = lry;
//	}
//
//	public boolean contains(double x, double y) {
//		return ( x > ulx && x < lrx ) && ( y > lry && y < uly );
//	}
//	
}
