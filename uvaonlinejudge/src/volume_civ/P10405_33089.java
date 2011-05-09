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
// @JUDGE_ID:  33089  10405  Java  "Longest Common Subsequence"
package volume_civ;

class P10405_33089 {
//	Rotina de Leitura
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
		(new P10405_33089()).begin();
	}	
	
	int lcs[][];
	private void begin() {
		String a = readLn();
		while ( a != null ) {
			String b = readLn();
			int m = a.length();
			int n = b.length();
			lcs = new int[m+1][];
			for ( int i = 0; i <= m; i++ ) {
				lcs[i] = new int[n+1];
				for ( int j = 0; j <= n; j++ ) {
					lcs[i][j] = -1;
				}
			}
			System.out.println(calcLcs(a,0,b,0));
			a = readLn();
		}
	}

	private int calcLcs(String a, int i, String b, int j) {
		if ( lcs[i][j] != -1 ) {
			return lcs[i][j];
		} else if ( i == a.length() || j == b.length() ) {
			lcs[i][j] = 0;
			return 0;
		} else if ( a.charAt(i) == b.charAt(j)) {
			lcs[i][j] = 1 + calcLcs(a, i+1, b, j+1);
			return lcs[i][j];
		} else {
			lcs[i][j] = Math.max( calcLcs(a, i+1, b, j), calcLcs(a, i, b, j+1 ) ); 
			return lcs[i][j];
		}
	}
}
