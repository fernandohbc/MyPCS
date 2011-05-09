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
// @JUDGE_ID:  33089  583  Java  "Prime Factors"
package volume_v;

class P583_33089 {
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
		(new P583_33089()).begin();
	}

	boolean crivo[] = new boolean[47000];

	private void begin() {
		geraCrivo();
		int n = Integer.parseInt(readLn());
		while (n != 0) {
			if (n == 1) {
				System.out.println("1 = 1");
			} else if (n == -1) {
				System.out.println("-1 = -1");

			} else {
				StringBuffer out = new StringBuffer();
				out.append(n);
				out.append(" = ");
				if (n < 0) {
					out.append("-1 x ");
					n = -n;
				}
				int p = 2;
				while (n > 1 && p <= 47000) {
					while (n % p == 0) {
						out.append(p);
						out.append(" x ");
						n = n / p;
					}
					// System.out.println(p);
					p = nextPrime(p);
				}
				if (n > 1) {
					out.append(n);
				}
				String output = out.toString();
				if ( n == 1 ) {
					output = output.substring(0, out.length() - 3);
				}
				System.out.println(output);
			}
			n = Integer.parseInt(readLn());
		}
	}

	private int nextPrime(int n) {
		do {
			n++;
		} while (crivo[n - 2]);
		return n;
	}

	private void geraCrivo() {
		long maxCheck = Math.round(Math.floor(Math.sqrt(47000)));
		for (int i = 2; i <= maxCheck; i++) {
			if (!crivo[i - 2]) {
				int idx = i * i;
				while (idx < 47000) {
					crivo[idx - 2] = true;
					idx = idx + i;
				}
			}
		}
	}
}
