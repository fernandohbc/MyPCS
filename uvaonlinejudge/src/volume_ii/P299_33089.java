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
// @JUDGE_ID:  33089  299  Java  "Train Swapping"
package volume_ii;

import java.util.StringTokenizer;

class P299_33089 {

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
		(new P299_33089()).begin();
	}
	
	private void begin() {
		int tc = Integer.parseInt(readLn());
		for ( int i = 0; i < tc; i++ ) {
			int n = Integer.parseInt(readLn());
			int vetor[] = new int[n];
			String input = readLn();
			StringTokenizer st = new StringTokenizer( input );
			for (int t = 0; t < n; t++ ) {
				vetor[t] = Integer.parseInt(st.nextToken());
			}
			System.out.println("Optimal train swapping takes " + bubbleSortSwapCount(vetor) + " swaps.");
		}
	}
	
	private int bubbleSortSwapCount( int vetor[] ) {
		int n = vetor.length;
		int swapCount = 0;
		boolean swapped;
		do {
			swapped = false;
			n = n - 1;
			for ( int i = 0; i < n; i++ ) {
				if ( vetor[i] > vetor[ i + 1 ] ) {
					int aux = vetor[ i ];
					vetor[ i ] = vetor[ i + 1 ];
					vetor[ i + 1 ] = aux;
					swapped = true;
					swapCount++;
				}
			}
		} while (swapped);
		return swapCount;
	}


}
