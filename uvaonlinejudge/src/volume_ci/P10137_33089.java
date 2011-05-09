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
// @JUDGE_ID:  33089  10137  Java  "The Trip"
package volume_ci;

class P10137_33089 {
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
		(new P10137_33089()).begin();
	}
	
	void begin() {
		String input = readLn();
		int n = Integer.parseInt( input );
		while ( n != 0 ) {
			
			//Le os valores e jah vai somando (unidade eh o centavo)
			long valores[] = new long[n];
			long soma = 0;
			for ( int i = 0; i < n; i++ ) {
				input = readLn();
				valores[i] = arr( new Double(input).doubleValue() * 100 );
				soma += valores[i];
			}
			
			long mediaFlr = flr( (double)soma / n );
			//System.out.println(mediaFlr);
			long extraPen = Math.abs( soma - mediaFlr * n );
			//System.out.println(extraPen);
			
			//Ordena o vetor
			ordena(valores);
			long minVal = 0;
			for ( int i = 0; i < n; i++ ) {
				long target = mediaFlr + ( extraPen-- > 0 ? 1 : 0 );
				if ( valores[i] > target  ) {
					minVal += valores[i] - target;
				}
			} 
			
			String saida = "" + minVal/100 + "." + minVal%100;
			if ( saida.indexOf('.') == saida.length() - 2 ) {
				saida = saida.concat("0");
			}
			System.out.println("$" + saida);
			
			input = readLn();
			n = Integer.parseInt( input );
		}
	}
	
	public long arr( double d ) {
		return Math.round(100 * d) / 100;
	}
	
	public long flr( double d ) {
		return Math.round(Math.floor(100 * d)) / 100;
	}
	
	static void ordena(long[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j - 1] < array[j]) {
					long aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
				}
			}
		}
	}
}
