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
// @JUDGE_ID:  33089  10013  Java  "Super long sums"
package volume_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P10013_33089 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String readLn() {
        try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

	
	public static void main( String args[] ) {
		int qtdTc = Integer.parseInt(readLn());
		
		for ( int t = 0; t < qtdTc; t++ ) {
			//Ignora a primeira linha
			readLn();
			
			int qtdDig = Integer.parseInt(readLn());
			int soma[] = new int[qtdDig+1];
			for ( int i = 1; i <= qtdDig; i++ ) {
				String input = readLn();
				StringTokenizer st = new StringTokenizer( input );
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				soma[i] = a+b;
				int j = i;
				while ( soma[j] > 9 ) {
					soma[j] = soma[j] % 10;
					soma[j-1] = soma[j-1] + 1;
					j--;
				}
			}
			StringBuffer output = new StringBuffer();
			if ( soma[0] != 0 ) {
				output.append(soma[0]);
			}
			for ( int i = 1; i <= qtdDig; i++ ) {
				output.append(soma[i]);
			}
			System.out.println(output);
			if (t != qtdTc - 1) {
				System.out.println();
			}
		}
	}	
}
