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
//10220 - I Love Big Numbers !
package volume_cii;

import java.util.Scanner;
import java.util.Vector;

class P10220_3747 {
	
	boolean first = true;

	public static void main(String[] args) {
		(new P10220_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			int n = scn.nextInt();
			MyBigNumber mbn = new MyBigNumber(1);
			for (int i = 2; i <= n; i++ ) {
				mbn.product(i);
			}
			System.out.println(mbn.sumOfDigits());
		}
	}
}

class MyBigNumber {
	
	Vector<Integer> v = new Vector<Integer>();

	public MyBigNumber(int i) {
		v.add(i);
	}

	public int sumOfDigits() {
		int result = 0;
		for ( int i = 0; i < v.size(); i++ ) {
			result += v.elementAt(i);
		}
		return result;
	}

	public void product(int n) {
		int l = v.size();
		int carry = 0;
		for ( int i = 0; i < l; i++ ) {
			int temp = v.elementAt(i) * n + carry;
			v.set(i, temp%10);
			carry = temp/10;
		}
		while ( carry != 0 ) {
			v.add(carry%10);
			carry = carry / 10;
		}
	}
	
}
