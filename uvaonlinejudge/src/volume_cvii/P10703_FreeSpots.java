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
package volume_cvii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #10703 - Free spots
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10703_FreeSpots {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int w = scn.nextInt();
        int h = scn.nextInt();
        int n = scn.nextInt();

        while (w != 0 || h != 0 || n != 0) {
            boolean board[][] = new boolean[w][h];
            int offCount = h * w;

            for (int i = 0; i < n; i++) {
                int x1 = scn.nextInt();
                int y1 = scn.nextInt();
                int x2 = scn.nextInt();
                int y2 = scn.nextInt();

                for (int x = Math.min(x1, x2) - 1; x < Math.max(x1, x2); x++) {
                    for (int y = Math.min(y1, y2) - 1; y < Math.max(y1, y2); y++) {
                        if (!board[x][y]) {
                            board[x][y] = true;
                            offCount--;
                        }
                    }
                }
            }

            if (offCount == 0) {
                System.out.println("There is no empty spots.");
            } else if (offCount == 1) {
                System.out.println("There is one empty spot.");
            } else {
                System.out.println("There are " + offCount + " empty spots.");
            }

            w = scn.nextInt();
            h = scn.nextInt();
            n = scn.nextInt();
        }
    }
}
