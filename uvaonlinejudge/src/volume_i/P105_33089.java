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
// @JUDGE_ID:  33089  105  Java  "The Skyline Problem"
package volume_i;

import java.util.StringTokenizer;

class P105_33089 {
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
		(new P105_33089()).begin();
	}
	
	private void begin() {
		int skyline[] = new int[10000];
		int maxR = 0;
		String input = readLn();
		while (input != null) {
		//while (!input.equals("sai")) {
			StringTokenizer st = new StringTokenizer( input );
			int l = Integer.parseInt( st.nextToken() );
			int h = Integer.parseInt( st.nextToken() );
			int r = Integer.parseInt( st.nextToken() );
			for ( int i = l; i< r; i++ ) {
				if ( skyline[i] < h ) {
					skyline[i] = h;
				}
			}
			if ( r > maxR ) {
				maxR = r;
			}
			//print(skyline, maxR);
			input = readLn();
		}
		//Altura comeca com 0;
		StringBuffer output = new StringBuffer();
		int currentHeight = 0;
		int i = 0;
		while ( i <= maxR ) {
			if ( skyline[i] != currentHeight ) {
				output.append(i);
				output.append(" ");
				output.append(skyline[i]);
				output.append(" ");
				currentHeight = skyline[i];
			}
			i++;
		}
		System.out.println(output.toString().trim());
	}
}
