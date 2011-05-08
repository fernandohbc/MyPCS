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
//Problem 414: Machined Surfaces
package volume_iv;

import java.util.Scanner;

public class P414_3747 {
	
	static final int LINELENGHT = 25;
	static char BLANK = ' ';
	
	public static void main(String[] args) {
		(new P414_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		while (n != 0) {
			int count[] = new int[n];
			int min = Integer.MAX_VALUE;
			for (int l = 0; l < n; l++) {
				String line = scn.nextLine();
				count[l] = 0;
				int first = line.indexOf(BLANK);
				if (first > -1) {
					count[l] = 1;
					for (int i = first + 1; i < LINELENGHT && line.charAt(i) == BLANK; i++, count[l]++)
						;
				}
				if ( count[l] < min ) {
					min = count[l];
				}
			}
			int sum = 0;
			for (int l = 0; l < n; l++) {
				count[l] -= min;
				sum+=count[l];
			}
			System.out.println(sum);
			n = Integer.parseInt(scn.nextLine());
		}
	}
}
