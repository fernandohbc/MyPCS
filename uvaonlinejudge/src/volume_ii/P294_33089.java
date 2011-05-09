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
//@JUDGE_ID:  33089  294  Java  "Divisors"
package volume_ii;

import java.util.StringTokenizer;

class P294_33089 {
	// Rotina de Leitura
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
		(new P294_33089()).begin();
	}

	private void begin() {
		int tc = Integer.parseInt(readLn());
		for (int i = 0; i < tc; i++) {
			String input = readLn();
			StringTokenizer st = new StringTokenizer( input );
			long l = Long.parseLong( st.nextToken() );
			long u = Long.parseLong( st.nextToken() );
			long maxDiv = -1;
			long maxN   = -1;
			for ( long n = l; n <= u; n++ ) {
				long div = countDivisors(n);
				if ( div > maxDiv ) {
					maxDiv = div;
					maxN = n;
				}
			}
			System.out.println("Between "+l+" and "+u+", "+maxN+" has a maximum of "+maxDiv+" divisors.");
		}
	}

	private long countDivisors(long n) {
		long result = 0;
		for ( int i = 1; i <= Math.sqrt(n); i++ ) {
			if ( n%i == 0 ) {
				result++;
			}
		}
		result = result * 2;
		double floorSqrt = Math.floor(Math.sqrt(n));
		if ( floorSqrt*floorSqrt == n ) {
			result = result - 1;
		}
		return result;
	}
}
