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
//"Beat the Spread!"
package volume_cviii;

import java.util.Scanner;

class P10812_3747 {

	public static void main(String[] args) {
		(new P10812_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int i = 0; i < tc; i++) {
			long s = scn.nextLong();
			long d = scn.nextLong();
			if ((s + d) % 2 != 0 || d > s) {
				System.out.println("impossible");
			} else {
				long x = (s + d) / 2;
				long y = s - x;
				System.out.println(x + " " + y);
			}
		}
	}
}
