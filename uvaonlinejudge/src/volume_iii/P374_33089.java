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
// @JUDGE_ID:  33089  374  Java  "Big Mod"
package volume_iii;

class P374_33089 {
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
		(new P374_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		while (input != null) {
			long b = Long.parseLong(input);
			long p = Long.parseLong(readLn());
			long m = Long.parseLong(readLn());
			long result = fastCalc(b, p, m);
			System.out.println(result);
			input = readLn();
			input = readLn();
		}
	}

	private long fastCalc(long b, long p, long m) {
		if (p == 0) {
			return 1;
		} else {
			long intermediary = fastCalc(b, p / 2, m) % m;
			//System.out.println(intermediary);
			if (p % 2 == 0) {
				return (intermediary * intermediary) % m;
			} else {
				return (b % m * intermediary * intermediary) % m;
			}
		}
	}
}
