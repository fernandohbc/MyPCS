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
//Problem 104: Arbitrage
package volume_i;

import java.util.Scanner;

public class P104_3747 {
	public static void main(String[] args) {
		(new P104_3747()).begin();
	}

	static int next[][];

	private void begin() {
		Scanner scn = new Scanner(System.in);
		mainloop: while (scn.hasNextInt()) {
			int n = scn.nextInt();
			double table[][] = new double[n][n];
			next = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j == i) {
						table[i][j] = 1.0;
					} else {
						table[i][j] = scn.nextDouble();
					}
					next[i][j] = -1;
				}
			}

			for (int k = 0; k < n; k++) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (table[i][k] * table[k][j] > table[i][j]) {
							table[i][j] = table[i][k] * table[k][j];
							next[i][j] = k;
						}
					}
				}

				// for (int i = 0; i < n; i++) {
				// for (int j = 0; j < n; j++) {
				// System.out.print(table[i][j] + "\t");
				// }
				// System.out.println();
				// }
				//
				// System.out.println();

				for (int i = 0; i < n; i++) {
					if (table[i][i] > 1.01) {
						System.out.println((i + 1) + getPath(i, i) + (i + 1));
						continue mainloop;
					}
				}
			}
			System.out.println("no arbitrage sequence exists");
		}
	}

	private String getPath(int i, int j) {
		int intermediate = next[i][j];
		if (intermediate == -1)
			return " "; /*
						 * there is an edge from i to j, with no vertices
						 * between
						 */
		else
			return getPath(i, intermediate) + (intermediate + 1)
					+ getPath(intermediate, j);

	}
}
