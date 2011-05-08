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
//@JUDGE_ID:  33089  640  Java  "Self Numbers"
package volume_vi;

class P640_33089 {
		public static void main( String args[] ) {
			boolean generated[] = new boolean[1000001];
			for ( int i = 1; i <= 1000000; i++ ) {
				if ( !generated[i] ) {
					System.out.println(i);
					int a = next( i );
					while ( a <= 1000000 && a > 0 && !generated[a]) {
						generated[a] = true;
						a = next( a );
					}
				}
			}
		}

	private static int next(int s) {
		int aux = s;
		int result = 0;
		while ( aux > 0 ) {
			result = result + aux%10;
			aux = aux/10;
		}
		result = result + s;
		return result;
	}
}
