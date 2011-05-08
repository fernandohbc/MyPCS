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
//443 - Humble Numbers
package volume_iv;

import java.util.Scanner;

class P443_3747 {

	public static void main(String[] args) {
		(new P443_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int qtd = 0;
		long humble[] = new long[5842];
		long x = 1;
		
		while( x <= 2000000000 ) {
			//System.out.println(qtd + " " + x);
			humble[qtd++] = x;
			x = x*2;
		}
		
		int qtd2 = qtd;
		//System.out.println(qtd2);
		for ( int i = 0; i < qtd2; i++ ) {
			x = humble[i] * 3;
			while( x <= 2000000000 && x > 0  ) {
				//System.out.println(qtd + " " + x);
				humble[qtd++] = x;
				x = x*3;
			}
		}
		
		int qtd3 = qtd;
		//System.out.println(qtd3);
		for ( int i = 0; i < qtd3; i++ ) {
			x = humble[i] * 5;
			while( x <= 2000000000 && x > 0  ) {
				//System.out.println(qtd + " " + x);
				humble[qtd++] = x;
				x = x*5;
			}
		}
		
		int qtd5 = qtd;
		//System.out.println(qtd5);
		for ( int i = 0; i < qtd5; i++ ) {
			x = humble[i] * 7;
			while( x <= 2000000000 && x > 0  ) {
				//System.out.println(qtd + " " + x);
				humble[qtd++] = x;				
				x = x*7;
			}
		}
		
		bubbleSort( humble );
		
		//System.out.println("Pode pedir");
		int i = scn.nextInt();
		while (i != 0 ) {
			System.out.println("The " + i + orderMod(i) + " humble number is " + humble[i-1] + ".");
			i = scn.nextInt();
		}
	}

	private String orderMod(int i) {
		if ( ( i / 10 )  % 10 != 1 ) {
			if ( i % 10 == 1 ) {
				return "st";
			} else if ( i % 10 == 2 ) {
				return "nd";
			} else if ( i % 10 == 3 ) {
				return "rd";
			} else {
				return "th";
			}
		} else {
			return "th";
		}
	}

	private void bubbleSort(long[] vetor) {
		int n = vetor.length;
		int swapCount = 0;
		boolean swapped;
		do {
			swapped = false;
			n = n - 1;
			for ( int i = 0; i < n; i++ ) {
				if ( vetor[i] > vetor[ i + 1 ] ) {
					long aux = vetor[ i ];
					vetor[ i ] = vetor[ i + 1 ];
					vetor[ i + 1 ] = aux;
					swapped = true;
					swapCount++;
				}
			}
		} while (swapped);		
	}
}
