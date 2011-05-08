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
// @JUDGE_ID:  33089  10107  Java  "What is the Median?"
package volume_ci;

class P10107_33089 {
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
		(new P10107_33089()).begin();
	}

	long v[] = new long[10000];
	int tamVetor = 0;
	private void begin() {		
		String input = readLn();
		while (input != null) {
			long n = Long.parseLong(input);
			insereOrdenado(v, n);
			long mediana = mediana(v);
			System.out.println(mediana);
			input = readLn();
		}
	}

	private long mediana(long v[]) {
		long elem = v[tamVetor / 2];
		if ( tamVetor % 2 == 1 ) {			
			return elem;
		} else {
			long other = v[tamVetor / 2 - 1];
			return (elem + other) / 2;
		}
	}

	private void insereOrdenado(long v[], long n) {
		int i = 0;
		while ( i < tamVetor && v[ i ] < n ) {
			i++;
		}
		for ( int k = tamVetor; k >= i + 1; k-- ) {
			v[k] = v[k-1];
		}
		v[i] = n;
		tamVetor++;
	}
}
