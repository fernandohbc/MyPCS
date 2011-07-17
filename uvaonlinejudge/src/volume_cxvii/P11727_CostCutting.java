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
package volume_cxvii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #11727 - Cost Cutting
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11727_CostCutting {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int i = 1; i <= q; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();

            System.out.println("Case "
                    + i
                    + ": "
                    + ((b < a && a < c) || (c < a && a < b) ? a
                            : ((a < b && b < c) || (c < b && b < a) ? b : c)));
        }
    }
}
