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
// @JUDGE_ID:  33089  706  Java  "LCD Displays"
package volume_vii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P706_33089 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String readLn() {
        try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

	
	public static void main( String args[] ) {
		String input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		int tam = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());;
		while ( tam != 0 ) {
			String numStr = "" + num;
			StringBuffer out = new StringBuffer();
			out.append(top(tam, numStr));
			out.append('\n');
			for ( int i = 0; i < tam; i++ ) {
				out.append(topBody(tam, numStr));
				out.append('\n');
			}
			out.append(middle(tam, numStr));
			out.append('\n');
			for ( int i = 0; i < tam; i++ ) {
				out.append(bottomBody(tam, numStr));
				out.append('\n');
			}
			out.append(bottom(tam, numStr));
			out.append('\n');
			System.out.println(out);
			
			input = readLn();
			st = new StringTokenizer(input);
			tam = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
		}
	}


	private static String bottom(int tam, String num) {
		StringBuffer out = new StringBuffer();
		for ( int i = 0; i < num.length(); i++ ) {
			out.append(bottom(tam, num.charAt(i)));
			if (i != num.length() - 1) {
				out.append(' ');
			}
		}
		return out.toString();
	}


	private static String bottom(int tam, char c) {
		StringBuffer out = new StringBuffer();
		out.append(' ');
		char chr = ' ';
		if ( c != '1' && c != '4' && c != '7' ) {
			chr = '-';
		}
		for ( int i = 1; i <= tam; i++ ) {
			out.append(chr);
		}
		out.append(' ');
		return out.toString();
	}


	private static String bottomBody(int tam, String num) {
		StringBuffer out = new StringBuffer();
		for ( int i = 0; i < num.length(); i++ ) {
			out.append(bottomBody(tam, num.charAt(i)));
			if (i != num.length() - 1) {
				out.append(' ');
			}
		}
		return out.toString();
	}


	private static String bottomBody(int tam, char c) {
		StringBuffer out = new StringBuffer();
		if ( c == '2' || c == '6' || c == '8' || c == '0') {
			out.append('|');
		} else {
			out.append(' ');
		}
		for ( int i = 1; i <= tam; i++ ) {
			out.append(' ');
		}
		if ( c != '2'  ) {
			out.append('|');
		} else {
			out.append(' ');
		}
		return out.toString();
	}


	private static String middle(int tam, String num) {
		StringBuffer out = new StringBuffer();
		for ( int i = 0; i < num.length(); i++ ) {
			out.append(middle(tam, num.charAt(i)));
			if (i != num.length() - 1) {
				out.append(' ');
			}
		}
		return out.toString();
	}


	private static String middle(int tam, char c) {
		StringBuffer out = new StringBuffer();
		out.append(' ');
		char chr = ' ';
		if ( c != '1' && c != '7' && c != '0' ) {
			chr = '-';
		}
		for ( int i = 1; i <= tam; i++ ) {
			out.append(chr);
		}
		out.append(' ');
		return out.toString();
	}


	private static String topBody(int tam, String num) {
		StringBuffer out = new StringBuffer();
		for ( int i = 0; i < num.length(); i++ ) {
			out.append(topBody(tam, num.charAt(i)));
			if (i != num.length() - 1) {
				out.append(' ');
			}
		}
		return out.toString();
	}


	private static String topBody(int tam, char c) {
		StringBuffer out = new StringBuffer();
		if ( c != '1' && c != '2' && c != '3' && c != '7') {
			out.append('|');
		} else {
			out.append(' ');
		}
		for ( int i = 1; i <= tam; i++ ) {
			out.append(' ');
		}
		if ( c != '5' && c != '6' ) {
			out.append('|');
		} else {
			out.append(' ');
		}
		return out.toString();
	}


	private static String top(int tam, String num) {
		StringBuffer out = new StringBuffer();
		for ( int i = 0; i < num.length(); i++ ) {
			out.append(top(tam, num.charAt(i)));
			if (i != num.length() - 1) {
				out.append(' ');
			}
		}
		return out.toString();
	}


	private static String top(int tam, char c) {
		StringBuffer out = new StringBuffer();
		out.append(' ');
		char chr = ' ';
		if ( c != '4' && c != '1' ) {
			chr = '-';
		}
		for ( int i = 1; i <= tam; i++ ) {
			out.append(chr);
		}
		out.append(' ');
		return out.toString();
	}	
}
