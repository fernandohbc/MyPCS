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
// @JUDGE_ID:  33089  530  Java  "Binomial Showdown"
package volume_v;

import java.util.StringTokenizer;

class P530_33089 {
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
		(new P530_33089()).begin();
	}
			
	private void begin() {
		//System.out.println(Integer.MAX_VALUE);
		String input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while ( n != 0 || m != 0 ) {
			//Verifica a diferenca entre os numeros
			int diff = n - m;
			if ( diff == 0 || n == 0 || m == 0 ) {
				System.out.println( "1");
			} else {
				//Obtem a maxima simplificacao e a maxima quantidade de divisoes
				int maxSimpl = (diff > m) ? diff : m;
				int maxDiv   = (diff < m) ? diff : m;
				
				//Inicializa o resultado com maxSimpl + 1
				//Inicializa a multiplicacao com maxSimpl + 1
				//Inicializa a divisao com 1
				long result = maxSimpl + 1;
				long mult = result + 1;
				long div = 1;
				boolean dividiu[] = new boolean[maxDiv + 1];
				while ( div < maxDiv || mult <= n) {				
					if ( div < maxDiv ) { 
						int i = maxDiv;
						//divide o maximo de vezes que conseguir antes de multiplicar
						while ( div < maxDiv && i >= 2 ) {
							if ( !dividiu[i] && result%i == 0 ) {
								dividiu[i] = true;
								//System.out.println("dividindo por " + i);
								result = result / i;
								div++;
							}
							i--;
						}
					}
					if ( mult <= n ) {
						//System.out.println("multiplicando por " + mult);
						result = result * mult ;
						mult++;
					}
					//System.out.println(result);
					//readLn();
				}
				
				System.out.println( result );				
			}
			
			input = readLn();
			st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
	}
}
