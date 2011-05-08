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
//674 - Coin Change
package volume_vi;

import java.util.Scanner;

class P674_3747 {

	int ways[][] = new int[5][];
	
	public static void main(String[] args) {
		(new P674_3747()).begin();
	}

	private void begin() {
		for ( int c = 0; c < 5; c++ ) {
			ways[c] = new int[7490];
		}
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int value = scn.nextInt();			
			System.out.println(countWays(value, 4));
		}
	}

	private int coinValue(int i) {
		switch (i) {
		case 4:
			return 50;
		case 3:
			return 25;
		case 2:
			return 10;
		case 1:
			return 5;
		}
		return 1;
	}

	private int countWays(int value, int coin) {
		if ( ways[coin][value] != 0 ) {
			return ways[coin][value];
		}
		if (value == 0 || coin == 0) {
			ways[coin][value] = 1;
			return 1;
		} else {
			int qtCoin = value / coinValue(coin);			
			int result = 0;
			for (int i = 0; i <= qtCoin; i++) {
				result += countWays(value - i * coinValue(coin), (coin-1));
			}
			ways[coin][value] = result;
			return result;
		}
	}
}
