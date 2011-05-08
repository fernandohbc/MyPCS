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
// @JUDGE_ID:  33089  264  Java  "Count on Cantor"
package volume_ii;

class P264_33089 {
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
		(new P264_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		while ( input != null ) {
			long n = Long.parseLong(input);
			//Determina a linha
			long l = findLine(n);
			//System.out.println(l);
			//Determina o deslocamento
			long offset = n - lowBoundary(l);
			//System.out.println(lowBoundary(l));
			//Determina a e b
			long a = l - offset;
			long b = ( l + 1 ) - a;
			//Escreve a saida
			if ( l%2==0 ) {
				System.out.println("TERM "+ n + " IS " + b + "/" + a);
			} else {
				System.out.println("TERM "+ n + " IS " + a + "/" + b);
			}
			input = readLn();
		}
	}

	private long lowBoundary(long l) {
		return (l)*(l-1)/2 + 1;
	}

	private long findLine(long n) {
		//=ARREDONDAR.PARA.CIMA((1+RAIZ(1+8*A1))/2 - 1;0)
		double raiz = (1+Math.sqrt(1+8*n))/2;
		return Math.round( Math.ceil( raiz - 1 ) );
	}	
}
