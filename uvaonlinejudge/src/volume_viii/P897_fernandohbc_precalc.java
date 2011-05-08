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
//897 - Anagrammatic Primes
package volume_viii;

import java.util.Scanner;

public class P897_fernandohbc_precalc {

    public static void main(String[] args) {
        (new P897_fernandohbc_precalc()).begin();
    }

    private void begin() {
        int[] anagramatic = { 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97,
                113, 131, 199, 311, 337, 373, 733, 919, 991 };
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while (n != 0) {
            int nextPower = this.getNextPower(n);
            int idx = 0;
            while (idx < anagramatic.length && anagramatic[idx] <= n
                    && anagramatic[idx] < nextPower) {
                idx++;
            }
            if (idx < anagramatic.length && anagramatic[idx] < nextPower) {
                System.out.println(anagramatic[idx]);
            } else {
                System.out.println(0);
            }
            n = scn.nextInt();
        }
    }

    private int getNextPower(int n) {
        int np = 10;
        while (n >= 10) {
            np = np * 10;
            n = n / 10;
        }
        return np;
    }
}
