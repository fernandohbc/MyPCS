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
//371 - Ackermann Functions
package volume_iii;

import java.util.Scanner;

class P371_3747 {

	public static void main(String[] args) {
		try {
		(new P371_3747()).begin();
		} catch (Exception e) {
			while (true);
		}
	}
	
	int qt[] = new int[3000000];
	
	private void begin() {
		Scanner scn = new Scanner(System.in);
		
		long l = scn.nextInt();
		long h = scn.nextInt();
		while ( l != 0 || h != 0 ) {
			if ( l > h ) {
				long aux = l;
				l = h;
				h = aux;
			}
			long maxCount = -1;
			long maxN = -1;
			for ( long n = l; n <= h; n++ ) {
				int count = (n==1)?3:ack(n);
				if ( count > maxCount ) {
					maxCount = count;
					maxN = n;
				}
			}
			System.out.println("Between "+ l +" and "+ h +", "+ maxN +" generates the longest sequence of "+ maxCount +" values.");
			l = scn.nextInt();
			h = scn.nextInt();
		}
	}

	private int ack(long n) {
		if ( n < 3000000 && qt[(int)n-1] != 0 ) {
			return qt[(int)n-1];
		} else if ( n == 1 ) {
			return 0;
		} else {
			int res = 1 + ack(next(n));
			if ( n < 3000000 ) {
				qt[(int)n-1] = res;
			}
			return res;
		}
	}

	private long next(long n) {
		if ( n % 2 == 0 ) {
			return n >> 1;
		} else {
			return n*3 + 1;
		}
	}
}
