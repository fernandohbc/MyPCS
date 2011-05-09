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
// @JUDGE_ID:  33089  136  Java  "Ugly Numbers"
package volume_i;

class P136_33089 {	
	//Entrada do programa
	public static void main(String[] args) {
		(new P136_33089()).begin();
	}
	
//	Programa principal Para calcular o 1500 Ugly.
//  Ele demora, mas depois de calculado, eh soh escrever
/*	void begin() {		
		int n = 1;
		for ( int i = 1; i <= 1500; ) {
			if ( isUgly(n) ) {
				System.out.println(i + " " + n);
				i++;
			}
			n++;			
		}
	}
	
	private boolean isUgly(long n) {
		if ( n == 1 ) {
			return true;
		} else {
			while (n % 2 == 0) {
				n = n/2;
			}
			while (n % 3 == 0) {
				n = n/3;
			}
			while (n % 5 == 0) {
				n = n/5;
			}
			return n == 1;
		}
	} */
	
	void begin() {
		System.out.println("The 1500'th ugly number is 859963392.");
	}
}
