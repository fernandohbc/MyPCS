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
// @JUDGE_ID:  33089  572  Java  "Oil Deposits"
package volume_v;

import java.util.StringTokenizer;

class P572_33089 {
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
		(new P572_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		while (m != 0 || n != 0) {
			char mapa[][] = new char[m][];
			for (int i = 0; i < m; i++) {
				mapa[i] = new char[n];
				String linha = readLn();
				for (int j = 0; j < n; j++) {
					mapa[i][j] = linha.charAt(j);
				}
			}
			System.out.println(conta(mapa, m, n));
			input = readLn();
			st = new StringTokenizer(input);
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
		}
	}

	private int conta(char[][] mapa, int m, int n) {
		int max = 0;
		int numMap[][] = new int[m][];
		for (int i = 0; i < m; i++) {
			numMap[i] = new int[n];
		}

		// Passa pelo mapa
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mapa[i][j] == '@' && numMap[i][j] == 0) {
					max++;
					floodFill(mapa, numMap, i, j, m, n, max);
				}
			}
		}

		return max;
	}

	private void floodFill(char[][] mapa, int[][] numMap, int i, int j, int m,
			int n, int num) {

		numMap[i][j] = num;
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				if (k >= 0 && k < m && l >= 0 && l < n && mapa[k][l] == '@'
						&& numMap[k][l] == 0) {
					floodFill(mapa, numMap, k, l, m, n, num);
				}
			}
		}
	}
}
