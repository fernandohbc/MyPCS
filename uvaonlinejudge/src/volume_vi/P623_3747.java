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
//623 - 500!
package volume_vi;

import java.util.Scanner;

public class P623_3747 {
	
	public static void main(String[] args) {
		new P623_3747().begin();
	}

	private void begin() {
		BigNum factorials[] = new BigNum[1001];
		factorials[0] = new BigNum(1);
		for ( int i = 1; i <= 1000; i++ ) {
			factorials[i] = factorials[i-1].times(i);
		}
		Scanner scn = new Scanner(System.in);
		while ( scn.hasNextInt() ) {
			int n = scn.nextInt();
			System.out.println(n + "!");
			System.out.println(factorials[n]);
		}
	}
}

class BigNum {
	private byte[] digits;
	private int size;
	
	public BigNum(int i) {
		int cap = (int) Math.round(Math.log10(i) + 1);
		size = 0;
		this.digits = new byte[cap];
		while ( i != 0 ) {
			digits[size++] = (byte) (i%10);
			i = i/10;
		}
	}

	private BigNum() {}

	public BigNum times(int n) {
		BigNum result = new BigNum();
		result.setCap(this.getSize() + (int) Math.round(Math.log10(n)) + 1);
		int carry = 0;
		int i = 0;
		for (i = 0 ; i < this.getSize(); i++  ) {			
			int aux = this.digits[i] * n + carry;
			result.setDigit(i, (byte) (aux%10));
			carry = aux/10;
		}
		int j = i;
		while ( carry != 0 ) {
			result.setDigit(j, (byte) (carry%10));
			j++;
			carry = carry/10;
		}
		result.setSize(j);
		return result;
	}

	private void setSize(int j) {
		this.size = j;
	}

	private void setDigit(int i, byte j) {
		digits[i] = j;		
	}

	private int getSize() {
		return size;
	}

	private void setCap(int cap) {
		byte[] aux = digits;
		digits = new byte[cap];
		if ( aux != null ) {			
			for ( int i = 0; i < aux.length; i++ ) {
				digits[i] = aux[i];
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = this.size - 1; i >= 0; i-- ) {
			sb.append(digits[i]);
		}
		return sb.toString();
	}
}
