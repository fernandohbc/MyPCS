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
// @JUDGE_ID:  33089  591  Java  "Box of Bricks"
package volume_v;

import java.util.StringTokenizer;

class P591_33089 {
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
		(new P591_33089()).begin();
	}
			
	private void begin() {
		int n = Integer.parseInt(readLn());
		int tc = 0;
		while ( n != 0 ) {
			tc++;
			int bricks[] = new int[n];
			String input = readLn();
			StringTokenizer st = new StringTokenizer(input);
			int sum = 0;
			for ( int i = 0; i < n; i++ ) {
				bricks[i] = Integer.parseInt(st.nextToken());
				sum = sum + bricks[i];
			}
			int avg = sum / n;
			int moves = 0;
			//A resposta é a soma de todos os excessos da média
			for ( int i = 0; i < n; i++ ) {
				if ( bricks[i] > avg ) {
					moves = moves + (bricks[i] - avg);
				}
			}
			System.out.println("Set #" + tc + "\nThe minimum number of moves is " + moves + ".\n");
			n = Integer.parseInt(readLn());
		}
	}
}
