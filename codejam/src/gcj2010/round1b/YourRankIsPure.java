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
package gcj2010.round1b;

import java.util.Scanner;

public class YourRankIsPure {
    public static void main(String[] args) {
        new YourRankIsPure().begin();
    }

    private void begin() {
        long table[][] = this.fillTable();
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();
        for (long cs = 1; cs <= t; cs++) {
            int n = scn.nextInt();
            System.out.println("Case #" + cs + ": " + table[n][25]);
        }
    }

    private long[][] fillTable() {
        long[][] table = new long[26][26];
        for (int s = 1; s <= 24; s++) {
            for (int n = s + 1; n <= 25; n++) {
                if (s == 1) {
                    table[n][s] = 1;
                } else {
                    long sum = 0;
                    for (int k = 1; k <= s - 1; k++) {
                        sum = (sum + (table[s][k] % 100003 * this.combination(n
                                - s - 1, s - 1 - k))) % 100003;
                    }
                    table[n][s] = sum;
                }
            }
        }

        // A ultima coluna sumariza tudo
        for (int n = 2; n <= 25; n++) {
            long sum = 0;
            for (int s = 1; s <= 24; s++) {
                sum = (sum + (table[n][s] % 100003)) % 100003;
            }
            table[n][25] = sum;
        }
        return table;
    }

    private long combination(long i, long j) {
        if (j > i) {
            return 0;
        }
        long prod = 1;
        for (long k = (i - j) + 1; k <= i; k++) {
            prod = (prod * k % 100003) % 100003;
        }
        return prod;
    }
}
