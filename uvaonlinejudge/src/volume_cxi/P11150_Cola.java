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
package volume_cxi;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #11150 - Cola
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11150_Cola {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (scn.hasNextInt()) {
            int n = scn.nextInt();
            System.out.println(countBottles(n));
        }
    }

    private static int countBottles(int n) {
        int count = n;

        while (n >= 3) {
            count += n / 3;
            n = n / 3 + n % 3;
        }

        if (n == 2) {
            count += 1;
        }

        return count;
    }
}