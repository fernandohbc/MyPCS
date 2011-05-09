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
// @JUDGE_ID:  33089  10041  Java  "Vito's family"
package volume_c;

import java.util.StringTokenizer;

class P10041_33089 {
	//Rotina de Leitura
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
		(new P10041_33089()).begin();
	}
	
	long numbers[] = null;
	int qtdRel = 0;
	
//	Programa principal
	void begin() {
		String input = readLn();
		int noTestCases = Integer.parseInt(input);
		for ( int t = 0; t < noTestCases; t++ ) {
			//Le a vizinhanca
			input = readLn();
			StringTokenizer st = new StringTokenizer(input);
			qtdRel = Integer.parseInt(st.nextToken());
			numbers = new long[qtdRel];
			
			for ( int i = 0; i < qtdRel; i++ ) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			//Ordena o vetor
			ordena(numbers);
			
			if ( qtdRel % 2 == 1) {
				long meio = numbers[qtdRel / 2];
				System.out.println(distancia(meio));
			} else {
				long distMeio = distancia(numbers[qtdRel / 2]);
				long distOutra = distancia(numbers[qtdRel / 2 - 1]);
				System.out.println(distMeio < distOutra ? distMeio : distOutra );
			}			
		}
	}

	static void ordena(long[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j - 1] > array[j]) {
					long aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
				}
			}
		}
	}

	private long distancia(long casa) {
		long result = 0;
		for ( int i = 0; i < qtdRel; i++  ) {
			result = result + Math.abs( casa - numbers[i] );
		}
		return result;
	}

}
