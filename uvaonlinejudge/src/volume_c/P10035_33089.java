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
// @JUDGE_ID:  33089  10035 Java  "Primary Arithmetic"
package volume_c;

import java.util.StringTokenizer;

class P10035_33089 {
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
		(new P10035_33089()).begin();
	}
	
	void begin() {
		String input = readLn();
		while ( !input.equals("0 0") ) {
			StringTokenizer st = new StringTokenizer(input);
			long a = Long.parseLong( st.nextToken() );
			long b = Long.parseLong( st.nextToken() );
			long carry = 0;
			int carryOps = 0;
			while ( a > 0 || b > 0 || carry > 0 ) {
				if ( carry > 0 ) {					
					carryOps++;
				}
				long soma = a%10 + b%10 + carry;
				carry = soma/10;				
				a = a/10;
				b = b/10;
			}			
			if ( carryOps == 0 ) {
				System.out.println("No carry operation.");
			} else if ( carryOps == 1 ) {
				System.out.println("1 carry operation." );
			} else {
				System.out.println(carryOps + " carry operations.");
			}
			input = readLn();
		}
	}
}
