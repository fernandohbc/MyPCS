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
//@JUDGE_ID:  33089  484  Java  "The Department of Redundancy Department"
package volume_iv;

import java.util.StringTokenizer;
import java.util.Vector;

class P484_33089 {
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
		(new P484_33089()).begin();
	}	
	
	private void begin() {
		String input = readLn();
		Vector v = new Vector();
		while ( input != null ) {
			StringTokenizer st = new StringTokenizer( input);
			while ( st.hasMoreTokens() ) {
				int i = Integer.parseInt( st.nextToken() );
				Number n = new Number( i );
				int pos = v.indexOf( n );
				if ( pos == -1 ) {
					v.addElement(n);
				} else {
					n = (Number)v.elementAt(pos);
					n.inc();
				}
			}
			input = readLn();			
		}
		for ( int i = 0; i < v.size(); i++ ) {
			Number n = (Number)v.elementAt(i);
			System.out.println(n);
		}
	}
}

class Number {
	private int number;
	private int qtd;
	
	public Number( int number ) {
		this.number = number;
		this.qtd = 1;
	}
	
	public void inc() {
		qtd++;
	}
	
	public boolean equals( Object o ) {
		return ((Number)o).number == this.number;
	}
	
	public String toString() {
		String result = "";
		result = result + number + " " + qtd;
		return result;
	}
}
