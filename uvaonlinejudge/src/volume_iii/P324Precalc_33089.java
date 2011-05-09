/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified.
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
package volume_iii;

import java.math.BigInteger;

public class P324Precalc_33089 {
	public static void main( String args[] ) {
		BigInteger theFactorial = new BigInteger("1");
		for ( int i = 1; i <= 366; i++ ) {
			theFactorial = theFactorial.multiply(new BigInteger(String.valueOf(i)));
			int array[] = toIntArray(theFactorial);
			print(i-1, array);
			System.out.println("table[" + (i-1) + "] = array" + (i-1) + ";");
		}
	}

	private static void print(int n, int[] array) {
		System.out.print("int[] array");
		System.out.print(n);
		System.out.print(" = {");
		for ( int i = 0; i < array.length; i++ ) {
			System.out.print( array[i] );
			if ( i != array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("};");
	}

	private static int[] toIntArray(BigInteger theFactorial) {
		int result[] = new int[10];
		String aux = theFactorial.toString();
		for ( int i = 0; i < aux.length(); i++ ) {
			int idx = (int)aux.charAt(i) - (int)'0';
			result[idx]++;
		}
		return result;
	}
}
