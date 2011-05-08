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
// @JUDGE_ID:  33089  10008  Java  "What's Cryptanalysis?"
package volume_c;

class P10008_33089 {
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
		(new P10008_33089()).begin();
	}
	
	private Letra letras[];
	private int AOFFSET = 65;
	
	private void begin() {
		letras = new Letra[26];
		for ( int i = 0; i < 26; i++ ) {
			char chr = (char)(i + AOFFSET);
			letras[i] = new Letra( chr );
		}
		int lines = Integer.parseInt(readLn());
		for (int i = 0; i < lines; i++ ) {
			String input = readLn();
			input = input.toUpperCase();
			int tam = input.length();
			for ( int c = 0; c < tam; c++ ) {
				char chr = input.charAt(c);
				int pos = (int)chr - (int)'A';
				if ( pos >= 0 && pos <= 26 ) {
					letras[pos].inc();
				}
			}
		}
		sort(letras);
		int i = 0;
		while ( i < 26 && letras[i].count > 0 ) {
			System.out.println(letras[i]);
			i++;
		}
	}

	private void sort(Letra[] letras) {
		int n = letras.length;
		boolean swapped;
		do {
			swapped = false;
			n = n - 1;
			for ( int i = 0; i < n; i++ ) {
				if ( letras[i].biggerThan( letras[ i + 1 ] ) ) {
					Letra aux = letras[ i ];
					letras[ i ] = letras[ i + 1 ];
					letras[ i + 1 ] = aux;
					swapped = true;
				}
			}
		} while (swapped);
	}
}

class Letra {
	char chr;
	int count = 0;
	public Letra(char chr) {
		this.chr = chr;
		this.count = 0;
	}
	public boolean biggerThan(Letra other) {
		return ( this.count < other.count ) || ( this.count == other.count && this.chr > other.chr );
	}
	public void inc() {
		count++;
	}
	public String toString() {
		return chr + " " + count;
	}
}
