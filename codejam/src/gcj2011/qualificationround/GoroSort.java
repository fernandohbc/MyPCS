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
package gcj2011.qualificationround;

import java.util.Scanner;

/**
 * Solution to Google Code Jam 2011 Qualification Round's Problem "GoroSort"
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 */
public class GoroSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = scn.nextInt();

            int misplacesCount = 0;
            for (int i = 1; i <= n; i++) {
                int x = scn.nextInt();

                if (x != i) {
                    misplacesCount++;
                }
            }

            System.out.printf("Case #%d: %.6f\n", tc, misplacesCount);
        }
    }
}
