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
// @JUDGE_ID:  33089  108  Java  "Maximum Sum"
package volume_i;

import java.util.StringTokenizer;

class P108_33089 {
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
		(new P108_33089()).begin();
	}
	
	String input;
	StringTokenizer st;
	private int[][] matrix;
	private long[][] sum;
	int n; 
	void begin() {
		input = readLn();
		n = Integer.parseInt(input);
		matrix = new int[n][];
		sum = new long[n][];
		for ( int l = 0; l < n; l++ ) {
			matrix[l] = new int[n];
			sum[l] = new long[n];
			for ( int c = 0; c < n; c++ ) {
				matrix[l][c] = getNum();
				sum[l][c] = matrix[l][c];
				if ( l > 0 ) {
					sum[l][c] = sum[l][c] + sum[l-1][c]; 
				}
				if ( c > 0 ) {
					sum[l][c] = sum[l][c] + sum[l][c-1];
				}
				if ( l > 0 && c > 0 ) {
					sum[l][c] = sum[l][c] - sum[l-1][c-1];
				}
			}
		}
		
		long maxSum = matrix[0][0];
		for ( int l = 0; l < n; l ++ ) {
			for( int c = 0; c < n; c++ ) {
				for ( int dl = l; dl < n; dl ++ ) {
					for ( int dc = c; dc < n; dc++ ) {
						long aux = sum[dl][dc];
						if ( l > 0 ) {
							aux = aux - sum[l-1][dc]; 
						}
						if ( c > 0 ) {
							aux = aux - sum[dl][c-1];
						}
						if ( l > 0 && c > 0 ) {
							aux = aux + sum[l-1][c-1];
						}
						if ( aux > maxSum ) {
							maxSum = aux;
						}
					}
				}
			}
		}
		
		System.out.println(maxSum);
		
	}

	private int getNum() {
		if ( st == null || !st.hasMoreTokens() ) {
			input = readLn();
			st = new StringTokenizer(input);
		}
		int num = Integer.parseInt(st.nextToken());
		return num;
	}

}
