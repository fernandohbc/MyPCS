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
//@JUDGE_ID:  33089  10260  Java  "Soundex"
package volume_cii;

class P10260_33089 {
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
		(new P10260_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		while ( input != null ) {
			int lastCode = -1;
			String result = "";
			for ( int i = 0; i < input.length(); i++ ) {
				char chr = input.charAt(i);
				int code = getCode(chr);
				if ( code != -1 && code != lastCode ) {					
					result = result + code;
				}
				lastCode = code;
			}
			System.out.println(result);
			input = readLn();
		}
	}

	private int getCode(char chr) {
		switch (chr) {
		case 'B':
		case 'F':
		case 'P':
		case 'V': return 1;
		case 'C':
		case 'G':
		case 'J':
		case 'K':
		case 'Q':
		case 'S':
		case 'X':
		case 'Z': return 2;
		case 'D':
		case 'T': return 3;
		case 'L': return 4;
		case 'M':
		case 'N': return 5;
		case 'R': return 6;
		default: return -1;
		}
	}
}
