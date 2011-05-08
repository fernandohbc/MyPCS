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
// @JUDGE_ID:  33089  10038  Java  "Jolly Jumpers"
package volume_c;

import java.util.StringTokenizer;

class P10038_33089 {
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
        return (buffer.toString());
    }
	
	//Entrada do programa
	public static void main(String[] args) {
		(new P10038_33089()).begin();
	}

	private boolean diferencas[];

	void begin() {
		String input = null;
		diferencas = new boolean[2999];
		while ((input = readLn()) != null) {
			StringTokenizer st = new StringTokenizer( input );
			int n = Integer.parseInt(st.nextToken());
			if ( n == 1 ) {
				System.out.println("Jolly");
				continue;
			} else if ( n < 1 ) {
				System.out.println("Not jolly");
				continue;
			}
			//Inicializa o vetor
			inicializa( n );
			
			//Obtem o primeiro par
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//Verifica as sequencias
			boolean invalida = false;
			for ( int i = 1; i <= n - 1 && !invalida; i++ ) {
				int diff = Math.abs(x-y);
				if ( diff == 0 || diff >= n || diferencas[ diff - 1 ] ) {
					invalida = true;
				} else {
					diferencas[ diff - 1 ] = true;
					if ( i < n-1 ) {
						x = y;
						y = Integer.parseInt(st.nextToken());
					}
				}
			}
			
			//Resposta
			if ( invalida ) {
				System.out.println("Not jolly");
			} else {
				System.out.println("Jolly");
			}
		}		
	}

	private void inicializa(int n) {
		for ( int i = 0; i < n-1; i++ ) {
			diferencas[ i ] = false;
		}
	}
}
