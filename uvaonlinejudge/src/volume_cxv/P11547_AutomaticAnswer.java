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
package volume_cxv;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #11547 - Automatic Answer
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11547_AutomaticAnswer {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        for (int i = 0; i < tc; i++) {
            System.out
                    .println(Math.abs((((scn.nextInt() * 63 + 7492) * 5 - 498) % 100) / 10));
        }
    }
}
