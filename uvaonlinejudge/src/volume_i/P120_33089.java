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
// @JUDGE_ID:  33089  120  Java  "Stacks of Flapjacks"
package volume_i;

import java.util.StringTokenizer;

class P120_33089 {
	//	Rotina de Leitura
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
		(new P120_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		while ( input != null ) {
			Stack s = new Stack( input );
			System.out.println(input);
			System.out.println(s.flipOrder());
			input = readLn();
		}
	}	
}

class Stack {
	int stack[];
	int tam; 

	public Stack(String input) {
		StringTokenizer st = new StringTokenizer( input );
		tam = st.countTokens();
		stack = new int[tam+1];
		for ( int i = tam; i >= 1; i--) {
			stack[i] = Integer.parseInt(st.nextToken());
		}
	}

	public String flipOrder() {
		StringBuffer result = new StringBuffer();
		for ( int pos = 1; pos <= tam; pos++ ) {
			//Obtem a posicao do maior elemento
			int posLargest = getPosLargest(pos);
			
			//Caso n�o esteja no lugar certo...
			if ( posLargest != pos ) {
//				Caso n�o esteja no topo... leva at� o topo
				if ( posLargest != tam ) {
					flip(posLargest);
					//print();
					result.append(posLargest);
					result.append(" ");
				}
				flip(pos);
				//print();
				result.append(pos);
				result.append(" ");
			}
		}
		result.append("0");
		return result.toString().trim();
	}

	private void flip(int posLargest) {
		int qtdFlips = (tam - posLargest + 1)/2;
		int origem = posLargest;
		int destino = tam;
		for ( int i = 1; i <= qtdFlips; i++ ) {
			int aux = stack[destino];
			stack[destino] = stack[origem];
			stack[origem] = aux;
			origem++;
			destino--;
		}
	}

	private int getPosLargest(int pos) {
		int largest = stack[pos];
		int posLargest = pos;
		for ( int i = pos + 1; i <= tam; i++ ) {
			if ( stack[i] > largest ) {
				largest = stack[i];
				posLargest = i;
			}
		}
		return posLargest;
	}
	
}
