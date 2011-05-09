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
//Problem: 10924 - Prime Words
package volume_cix;

import java.util.Scanner;

public class P10924_3747 {
	public static void main(String[] args) {
		new P10924_3747().begin();
	}

	private void begin() {
		boolean crivo[] = montaCrivo(1040);
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextLine()) {
			String line = scn.nextLine();
			int n = getNumber( line );
			if ( crivo[n] ) {
				System.out.println("It is not a prime word.");
			} else {
				System.out.println("It is a prime word.");
			}
		}
	}

	private int getNumber(String str) {
		int result = 0;
		int l = str.length();
		for ( int i = 0; i < l; i++ ) {
			result += getCode(str.charAt(i));
		}
		return result;
	}

	private int getCode(char ch) {
		int result = 0;
		if (Character.isLowerCase(ch)) {
			result = (ch - 'a') + 1;
		} else {
			result = (ch - 'A') + 27;
		}
		return result;
	}

	private boolean[] montaCrivo(int max) {
		boolean crivo[] = new boolean[max + 1];
		for (int i = 2; i <= max; i++) {
			if (!crivo[i]) {
				for (int j = 2 * i; j < max + 1; j += i) {
					crivo[j] = true;
				}
			}
		}
		return crivo;
	}
}
