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
//10003 - Cutting Sticks
package volume_c;

import java.util.Scanner;

class P10003_3747 {

	public static void main(String[] args) {
		(new P10003_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int length = scn.nextInt();
		while ( length != 0 ) {
			int qtCuts = scn.nextInt();
			int cuts[] = new int[qtCuts+2];
			cuts[0] = 0;
			cuts[qtCuts+1] = length;
			for ( int c = 1; c <= qtCuts; c++ ) {
				cuts[c] = scn.nextInt();
			}
			
			int table[][] = new int[qtCuts+2][];
			for ( int i = 0; i < qtCuts+2; i++ ) {
				table[i] = new int[qtCuts+2];
			}
			
			//Dinamic!!
			for ( int offset = 0; offset < qtCuts; offset++ ) {
				int i = 1;
				int e = 1 + offset;
				for (; e <= qtCuts; i++, e++) {
					int min = Integer.MAX_VALUE;
					for ( int k = i; k <= e; k++ ) {
						int thisTry = 0;
						if ( k != i ) {
							thisTry += table[i][k-1];
						}
						if ( k != e ) {
							thisTry += table[k+1][e];
						}
						if ( thisTry < min ) {
							min = thisTry;
						}
					}
					table[i][e] = min + cuts[e+1] - cuts[i-1];
				}
			}
			
			System.out.println("The minimum cutting is " + table[1][qtCuts] + ".");
			length = scn.nextInt();
		}
	}
}
