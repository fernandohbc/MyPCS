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
//@JUDGE_ID:  33089  494  Java  "Kindergarten Counting Game"
package volume_iv;

import java.util.StringTokenizer;

class P494_33089 {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString().trim());
    }
	
	public static void main(String[] args) {
		(new P494_33089()).begin();
	}
	
	private void begin() {
		String input;
		while ( ( input = readLn() ) != null ) {
//			System.out.println((int)'A');
//			System.out.println((int)'Z');
			input = input.toUpperCase();
			int tamInput = input.length();
			int nWord = 0;
			int i = 0;
			while ( i < tamInput && !isValid(input.charAt(i)) ) {
				i++;
			}
			if ( i < tamInput ) {
				nWord = 1;
				for ( i++ ; i < tamInput; i++ ) {
					if ( isValid(input.charAt(i)) && !isValid(input.charAt(i-1)) ) {
						nWord++;
					}
				}
			}
			System.out.println(nWord);
		}
	}
	
	private boolean isValid( char c ) {
		return ((int)c >= 65 && (int)c <= 90);
	}
	
	void oldVersion() {
		String input;
		while ( ( input = readLn() ) != null ) {
//			System.out.println((int)'A');
//			System.out.println((int)'Z');
			StringTokenizer st = new StringTokenizer( input.toUpperCase() );
			int nTok = st.countTokens();
			int nWord = 0;
outter:		for ( int i = 0; i < nTok; i++ ) {
				String possibleWord = st.nextToken();
				int tamWord = possibleWord.length();
				for ( int c = 0; c < tamWord; c++ ) {
					int chr = (int)possibleWord.charAt(c);
					if ( chr >= 65 && chr <= 90 ) {
						nWord++;
						continue outter;
					}
				}
			}
			System.out.println(nWord);
		}
	}
}


