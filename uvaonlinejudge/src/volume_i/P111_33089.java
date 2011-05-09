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
// @JUDGE_ID:  33089  111  Java  "History Grading"
package volume_i;

import java.util.StringTokenizer;

class P111_33089 {
	//	Rotina de Leitura
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
		(new P111_33089()).begin();
	}

	private void begin() {
		int n = Integer.parseInt(readLn());
		
		//Leitura do gabarito
		int[] gabarito = new int[n];
		String input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		for ( int i = 0; i < n; i++ ) {
			int idx = Integer.parseInt(st.nextToken());
			gabarito[idx-1] = i;
		}
		
		//Leitura das respostas
		input = readLn();
		while ( input != null ) {
			st = new StringTokenizer(input);
			int respostas[] = new int[n];
			for ( int i = 0; i < n; i++ ) {
				int idx = Integer.parseInt(st.nextToken());
				respostas[idx-1] = i;
			}
			System.out.println(maxLISLength(respostas, gabarito));
			input = readLn();
		}
	}

	private int pos(int[] v, int e) {
		int result = -1;
		for ( int i = 0; i < v.length; i++ ) {
			if (v[i] == e) {
				return i;
			}
		}
		return result;
	}

	private int maxLISLength(int[] v, int[] g) {
		int n = v.length;
		int[] aux = new int[n];
		int maxAux = 0;
		for ( int j = 0; j < n; j++ ) {
			aux[j] = 1;
			for ( int i = 0; i <= j - 1; i++ ) {
				if (pos(g,v[i]) <= pos(g,v[j])  && aux[j] < aux[i] + 1) {
					aux[j] = aux[i] + 1;
				}
			}
			if ( aux[j] > maxAux ) {
				maxAux = aux[j];
			}
		}
		return maxAux;
	}
}
