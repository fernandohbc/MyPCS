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
// @JUDGE_ID:  33089  458 Java  "The Decoder"
package volume_iv;

import java.util.Scanner;

class P458_33089 {
	public static void main(String[] args) {
		(new P458_33089()).begin();
	}
	
	void begin() {
//		String a = "1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5";
//		String b = "*CDC is the trademark of the Control Data Corporation.";
//		for ( int i = 0; i < a.length(); i++ ) {
//			System.out.println(a.charAt(i) + ": " + (int)a.charAt(i) + "\t" + b.charAt(i) + ": " + (int)b.charAt(i) );
//		}
		Scanner scn = new Scanner(System.in);
		while ( scn.hasNextLine() ) {
			String input = scn.nextLine();
			StringBuffer output = new StringBuffer();
			for ( int i = 0; i < input.length(); i++ ) {				
				output.append((char)( (int)input.charAt(i) - 7 ));
			}
			System.out.println(output);
		}
	}

}
