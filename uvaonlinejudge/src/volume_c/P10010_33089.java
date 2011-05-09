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
// @JUDGE_ID:  33089  10010  Java  "Where's Waldorf?"
package volume_c;

import java.util.StringTokenizer;

class P10010_33089 {
	// Entrada do programa
	public static void main(String args[]) {
		(new P10010_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		int qtdTc = Integer.parseInt(input);
		for (int t = 0; t < qtdTc; t++) {
			// Despreza uma linha em branco
			readLn();

			// Leitura do tamanho do grid
			input = readLn();
			StringTokenizer st = new StringTokenizer(input);
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// Leitura do grid
			char[][] grid = new char[m][];
			for (int l = 0; l < m; l++) {
				grid[l] = new char[n];
				input = readLn();
				for (int c = 0; c < n; c++) {
					char chr = input.charAt(c);
					grid[l][c] = Character.toLowerCase(chr);
				}
			}

			// Leitura das palavras
			input = readLn();
			int k = Integer.parseInt(input);
			for (int p = 0; p < k; p++) {
				String palavra = readLn();
				localizaPalavra(palavra, grid);
			}

			if (t != qtdTc - 1) {
				System.out.println();
			}
		}
	}

	private void localizaPalavra(String palavra, char[][] grid) {
		palavra = palavra.toLowerCase();
		for (int l = 0; l < grid.length; l++) {
			for (int c = 0; c < grid[l].length; c++) {
				// Verifica se a primeira letra casa
				if (palavra.charAt(0) == grid[l][c]
						&& (localiza(palavra, grid, l, c, "u")
								|| localiza(palavra, grid, l, c, "ur")
								|| localiza(palavra, grid, l, c, "r")
								|| localiza(palavra, grid, l, c, "dr")
								|| localiza(palavra, grid, l, c, "d")
								|| localiza(palavra, grid, l, c, "dl")
								|| localiza(palavra, grid, l, c, "l") || localiza(
								palavra, grid, l, c, "ul"))) {
					System.out.println((l + 1) + " " + (c + 1));
					return;
				}
			}
		}
	}

	private boolean localiza(String palavra, char[][] grid, int l, int c,
			String direcao) {
		int lStep = 0;
		int cStep = 0;
		if (direcao.equals("u")) {
			lStep = -1;
			cStep = 0;
		} else if (direcao.equals("ur")) {
			lStep = -1;
			cStep = 1;
		} else if (direcao.equals("r")) {
			lStep = 0;
			cStep = 1;
		} else if (direcao.equals("dr")) {
			lStep = 1;
			cStep = 1;
		} else if (direcao.equals("d")) {
			lStep = 1;
			cStep = 0;
		} else if (direcao.equals("dl")) {
			lStep = 1;
			cStep = -1;
		} else if (direcao.equals("l")) {
			lStep = 0;
			cStep = -1;
		} else if (direcao.equals("ul")) {
			lStep = -1;
			cStep = -1;
		}

		int pos = 0;
		while (l >= 0 && l < grid.length && c >= 0 && c < grid[0].length
				&& pos < palavra.length() && palavra.charAt(pos) == grid[l][c]) {
			pos++;
			l += lStep;
			c += cStep;
		}
		return pos == palavra.length();
	}

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
		return (buffer.toString());
	}
}
