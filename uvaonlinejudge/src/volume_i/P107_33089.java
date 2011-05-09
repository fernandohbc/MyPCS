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
// @JUDGE_ID:  33089  107  Java  "Cat in The Hat"
package volume_i;

import java.util.StringTokenizer;

class P107_33089 {
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
		(new P107_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		int h0 = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		while (h0 != 0 || w != 0) {
			if (h0 == 1) {
				System.out.println(0 + " " + w);
			} else {
				// Primeiro descobre a quantidade de passos
				long steps = calculateSteps(h0, w);
				// Com base nos passos, clacula o n
				long n = Math.round(Math.pow(w, 1.0 / steps));
				
				long totalCats = 0;
				if ( n != 1 ) {
					totalCats = Math.round((Math.pow(n, steps + 1) - 1)
							/ (n - 1));
				} else {
					totalCats = steps + 1;
				}
				long notWorking = totalCats - w;

				// Raz�o da PG da pilha
				double stackQ = (n / 1.0) / (n + 1);

				long stack = Math.round(h0 * (Math.pow(stackQ, steps + 1) - 1)
						/ (stackQ - 1));

				System.out.println(notWorking + " " + stack);
			}
			input = readLn();
			st = new StringTokenizer(input);
			h0 = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
		}
	}

	private int calculateSteps(int h0, int w) {
		int steps = 0;
		double rsw = 0;
		double rsh0 = 0;
		do {
			steps++;
			rsw = Math.pow(w, 1.0 / steps);
			rsh0 = Math.pow(h0, 1.0 / steps);
		} while (Math.abs(rsw + 1 - rsh0) > 0.0000001);
		return steps;
	}

}
