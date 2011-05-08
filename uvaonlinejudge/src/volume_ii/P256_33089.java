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
// @JUDGE_ID:  33089  256  Java  "Quirksome Squares"
package volume_ii;

class P256_33089 {
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
		(new P256_33089()).precalculated();
	}
	
	private void precalculated() {
		String input = readLn();
		while ( input != null ) {
			int qtdDig = Integer.parseInt(input);
			switch ( qtdDig ) {
			case 2:
				System.out.println("00");
				System.out.println("01");
				System.out.println("81");
				break;
			case 4:
				System.out.println("0000");
				System.out.println("0001");
				System.out.println("2025");
				System.out.println("3025");
				System.out.println("9801");
				break;
			case 6:
				System.out.println("000000");
				System.out.println("000001");
				System.out.println("088209");
				System.out.println("494209");
				System.out.println("998001");
				break;
			case 8:
				System.out.println("00000000");
				System.out.println("00000001");
				System.out.println("04941729");
				System.out.println("07441984");
				System.out.println("24502500");
				System.out.println("25502500");
				System.out.println("52881984");
				System.out.println("60481729");
				System.out.println("99980001");
				break;
			}			
			input = readLn();
		}
	}
	
	public void begin() {
		String input = readLn();
		while ( input != null ) {
			int qtdDig = Integer.parseInt(input);
			long maxLimit = 0;
			long divisor = 0;
			switch ( qtdDig ) {
			case 2:
				maxLimit = 99;
				divisor = 10;
				break;
			case 4:
				maxLimit = 9999;
				divisor = 100;
				break;
			case 6:
				maxLimit = 999999;
				divisor = 1000;
				break;
			case 8:
				maxLimit = 99999999;
				divisor = 10000;
				break;
			}
			for ( long n = 0; n <= maxLimit; n++ ) {
				long a = n / divisor;
				long b = n % divisor;
				if ( ( a + b ) * ( a + b ) == n ) {
					print(n, qtdDig);
				}
			}
			input = readLn();
		}
	}

	private void print(long n, int qtdDig) {
		String numStr = String.valueOf(n);
		while ( numStr.length() < qtdDig ) {
			numStr = '0' + numStr;
		}
		System.out.println("System.out.println(\"" + numStr + "\");");
	}
}
