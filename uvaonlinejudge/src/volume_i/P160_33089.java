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
// @JUDGE_ID:  33089  160  Java  "Factors and Factorias"
package volume_i;

class P160_33089 {
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
		(new P160_33089()).begin();
	}

	private void begin() {
		int smallPrimes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
				43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
		int n = Integer.parseInt(readLn());
		while ( n != 0 ) {
			int i = 0;
			StringBuffer sb = new StringBuffer();
			sb.append(format(n));
			sb.append("! =");
			while ( i < /*smallPrimes.length()*/ 25 && smallPrimes[i] <= n ) {
				int occ = countOcurrencies(n, smallPrimes[i]);
				if ( i == 15 ) {
					sb.append("\n      ");
				}
				sb.append(format(occ));				
				i++;
			}
			System.out.println(sb);
			n = Integer.parseInt(readLn());
		}
	}

	private StringBuffer format(int n) {
		StringBuffer result = new StringBuffer();
		result.append(n);
		while ( result.length() < 3 ) {
			result.insert(0, " ");
		}
		return result;
	}

	private int countOcurrencies(int n, int i) {
		int result = 0;
		do {
			n = n / i;
			result = result + n;
		} while (n > 0);
		return result;
	}
}
