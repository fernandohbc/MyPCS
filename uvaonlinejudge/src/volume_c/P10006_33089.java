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
// @JUDGE_ID:  33089  10006  Java  "Carmichael Numbers"
package volume_c;

class P10006_33089 {
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
		(new P10006_33089()).begin();
	}

	private void begin() {
		long n = Long.parseLong(readLn());
		while (n != 0) {
			if (preCalcCharmichael(n)) {
				System.out.println("The number " + n
						+ " is a Carmichael number.");
			} else {
				System.out.println(n + " is normal.");
			}
			n = Long.parseLong(readLn());
		}
	}

	private boolean isPrime(long a) {
		long maxDiv = Math.round(Math.sqrt(a));
		for (long div = 2; div <= maxDiv; div = div + 1) {
			if (a % div == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean preCalcCharmichael(long n) {
		return n == 561 || n == 1105 || n == 1729 || n == 2465 || n == 2821
				|| n == 6601 || n == 8911 || n == 10585 || n == 15841
				|| n == 29341 || n == 41041 || n == 46657 || n == 52633
				|| n == 62745 || n == 63973;
	}

	private boolean isCharmichael(long n) {
		if (isPrime(n)) {
			return false;
		} else {
			for (int a = 2; a < n; a++) {
				// Primeiro mod
				long partialMod = a % n;
				for (int m = 2; m <= n; m++) {
					partialMod = (partialMod * (a % n)) % n;
				}
				// System.out.println(a + "\t" + partialMod);
				if (partialMod != a) {
					return false;
				}
			}
			return true;
		}
	}

}
