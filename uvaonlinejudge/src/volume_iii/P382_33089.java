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
// @JUDGE_ID:  33089  382  Java  "Perfection"
package volume_iii;

import java.util.StringTokenizer;

class P382_33089 {
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
		(new P382_33089()).begin();
	}
	
	
	String input;
	StringTokenizer st;
	private void begin() {
		System.out.println("PERFECTION OUTPUT");
		int n = getNum();
		while ( n != 0 ) {
			int sum = 0;
			if ( n == 1 ) {
				sum = 0;
			} else {
				sum = sumOfDivisors(n);
			}
			if ( sum < n ) {
				System.out.println( justfied(n) + "  DEFICIENT");
			} else if ( sum == n ) {
				System.out.println( justfied(n) + "  PERFECT");
			} else {
				System.out.println( justfied(n) + "  ABUNDANT");
			}
			n = getNum();
		}
		System.out.println("END OF OUTPUT");
	}

	private String justfied(int n) {
		String result = String.valueOf(n);
		while ( result.length() < 5 ) {
			result = " " + result;
		}		
		return result;
	}

	private int sumOfDivisors(int i) {
		double raiz = Math.sqrt(i);
		int result = 1;
		for ( int d = 2; d <= raiz; d++ ) {
			if ( d == raiz ) {
				result = result + d;
			} else if ( i%d == 0 ) {
				//System.out.println(d);
				//System.out.println(i/d);
				result = result + d + (i/d);
			}
		}
		return result;
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
