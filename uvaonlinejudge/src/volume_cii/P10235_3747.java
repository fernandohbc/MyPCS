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
//Problem 10235: Simply Emirp!
package volume_cii;

import java.util.Scanner;

public class P10235_3747 {
	public static void main(String[] args) {
		new P10235_3747().begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int n = scn.nextInt();
			if ( !isPrime(n) ) {
				System.out.println(n + " is not prime.");
			} else {
				int rev = reverse(n);
				if ( rev != n && isPrime(rev) ) {
					System.out.println(n + " is emirp.");
				} else {
					System.out.println(n + " is prime.");
				}
			}
		}
	}

	private int reverse(int n) {
		int rev = 0;
		while ( n != 0 ) {
			rev = rev*10 + n%10;
			n = n / 10;
		}
		return rev;
	}

	private boolean isPrime(int n) {
		if ( n < 2 ) {
			return false;
		} else if ( n == 2 ) {
			return true;
		} else if ( n%2 != 0 ) {
			int div = 3;
			double max = Math.sqrt(n);
			while ( div <= max ) {
				if ( n%div == 0) {
					return false;
				}
				div += 2;
			}
			return true;
		} else {
			return false;
		}
	}
}
