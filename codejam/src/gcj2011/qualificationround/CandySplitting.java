/*******************************************************************************
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
 ******************************************************************************/
package gcj2011.qualificationround;

import java.util.Scanner;

/**
 * Solution to Google Code Jam 2011 Qualification Round's Problem Candy
 * Splitting.
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 * 
 */
public class CandySplitting {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int qtc = scn.nextInt();
        for (int tc = 1; tc <= qtc; tc++) {
            int n = scn.nextInt();
            int arr[] = new int[n];
            int xorSum = 0;
            long sum = 0;
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
                xorSum ^= arr[i];
                sum += arr[i];
                if (arr[i] < lowest) {
                    lowest = arr[i];
                }
            }

            if (xorSum != 0) {
                System.out.println("Case #" + tc + ": NO");
            } else {
                long result = sum - lowest;
                System.out.println("Case #" + tc + ": " + result);
            }
        }
    }
}
