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
//834 - Continued Fractions
package volume_viii;

import java.util.Scanner;

class P834_3747 {

	public static void main(String[] args) {
		(new P834_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while( scn.hasNextInt() ) {
			sb = new StringBuilder();
			int num = scn.nextInt();
			int div = scn.nextInt();
			int i = num / div;
			sb.append("["+i+";");
			int rest = num - i*div;
			while ( rest != 0 ) {
				num = div;
				div = rest;
				i = num / div;
				sb.append(i+",");
				rest = num - i*div;
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			System.out.println(sb);
		}
	}
}
