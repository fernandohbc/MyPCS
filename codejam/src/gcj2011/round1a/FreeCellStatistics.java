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
package gcj2011.round1a;

import java.util.Scanner;

/**
 * Solution to Google Code Jam 2011 Round 1 A Problem "FreeCell Statistics"
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 */
public class FreeCellStatistics {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int qtc = scn.nextInt();
        for (int tc = 1; tc <= qtc; tc++) {
            long n = scn.nextLong();
            long pd = scn.nextLong();
            long pg = scn.nextLong();

            long playsDay = 100 / gcd(100, pd);

            if (playsDay <= n && ((pg != 100 && pg != 0) || pg == pd)) {
                System.out.println("Case #" + tc + ": Possible");
            } else {
                System.out.println("Case #" + tc + ": Broken");
            }
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
