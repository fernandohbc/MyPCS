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
//488 - Triangle Wave
package volume_iv;

import java.util.Scanner;

class P488_3747 {
	
	boolean first = true;

	public static void main(String[] args) {
		(new P488_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int nTc = scn.nextInt();
		for ( int tc = 1; tc <= nTc; tc++ ) {
			int amp = scn.nextInt();
			int freq = scn.nextInt();
			for ( int f = 0; f < freq; f++ ) {
				System.out.print(printTriangle( amp ));
			}
		}
	}

	private String printTriangle(int amp) {
		StringBuilder sb = new StringBuilder();
		if ( !first ) {
			sb.append('\n');
		} else {
			first = false;
		}
		
		for ( int i = 1; i <= amp; i++ ) {
			for ( int x = 0; x < i; x++ ) {
				sb.append(i);
			}
			sb.append('\n');
		}
		
		for ( int i = amp-1; i > 0; i-- ) {
			for ( int x = 0; x < i; x++ ) {
				sb.append(i);
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
