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
//Problem: 10921 - Find the Telephone
package volume_cix;

import java.util.Scanner;

public class P10921_3747 {
    public static void main(String[] args) {
	new P10921_3747().begin();
    }

    private void begin() {
	char associatedNumber[] = { '2', '2', '2', '3', '3', '3', '4', '4',
		'4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8',
		'8', '8', '9', '9', '9', '9' };
	Scanner scn = new Scanner(System.in);
	while (scn.hasNextLine()) {
	    String line = scn.nextLine();
	    for (char c = 'A'; c < 'Z'+1; c++) {
		line = line.replace(c, associatedNumber[(int) (c - 'A')]);
	    }
	    System.out.println(line);
	}
    }
}
