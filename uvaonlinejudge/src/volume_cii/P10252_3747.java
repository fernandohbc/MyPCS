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
//Problem 10252 - Common Permutation
package volume_cii;

import java.util.Scanner;

public class P10252_3747 {
	public static void main(String[] args) {
		new P10252_3747().begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextLine()) {
			String first = scn.nextLine();
			String second = scn.nextLine();

			char arrFirst[] = first.toCharArray();
			char arrSecond[] = second.toCharArray();

			orderChars(arrFirst);
			orderChars(arrSecond);
			
			String result = match(arrFirst, arrSecond);
			System.out.println(result);
		}
	}

	private String match(char[] arrFirst, char[] arrSecond) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i < arrFirst.length && j < arrSecond.length ) {
			if ( arrFirst[i] == arrSecond[j] ) {
				sb.append(arrFirst[i]);
				i++;
				j++;
			} else if ( arrFirst[i] < arrSecond[j] ) {
				i++;
			} else {
				j++;
			}
			
		}
		return sb.toString();
	}

	private void orderChars(char[] charArray) {
		boolean swapped;
		int lim = charArray.length - 1;
		do {
			swapped = false;
			for (int i = 0; i < lim; i++) {
				if (charArray[i] > charArray[i+1]) {
					char aux = charArray[i];
					charArray[i] = charArray[i+1];
					charArray[i+1] = aux;
					swapped = true;
				}
			}
			lim--;
		} while (swapped);
	}
}
