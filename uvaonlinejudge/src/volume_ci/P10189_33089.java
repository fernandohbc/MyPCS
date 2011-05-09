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
// @JUDGE_ID:  33089  10189  Java  "Minesweeper"
package volume_ci;

import java.util.StringTokenizer;

class P10189_33089 {
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
	
	//Entrada do programa
	public static void main(String[] args) {
		(new P10189_33089()).begin();
	}

	void begin() {
		String input = readLn();
		int tc = 0;
		while (!input.equals("0 0")) {
			tc++;
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int output[][] = new int[n][];
			for ( int l = 0; l < n; l++ ) {
				output[l] = new int[m];
			}
			for ( int l = 0; l < n; l++ ) {				
				input = readLn();
				for ( int c = 0; c < m; c++ ) {
					char chr = input.charAt(c);
					if ( chr == '*' ) {
						output[l][c] = -1;
						for ( int lin = l-1; lin <= l + 1; lin++ ) {
							for ( int col = c - 1; col <= c + 1; col ++ ) {
								if ( lin >= 0 && lin < n && col >= 0 && col < m && output[lin][col] != -1 ) {
									output[lin][col]++;
								}
							}
						}
					}
				}
			}
			StringBuffer out = new StringBuffer();			
			out.append("Field #" + tc + ":\n");
			for ( int l = 0; l < n; l++ ) {
				for ( int c = 0; c < m; c++ ) {
					if ( output[l][c] == -1 ) {
						out.append('*');
					} else {
						out.append(output[l][c]);
					}					
				}
				if ( l < n-1) {
					out.append("\n");
				}
			}
			input = readLn();
			if ( !input.equals("0 0")) {
				out.append("\n");
			}
			System.out.println(out);
		}
	}
}
