/*******************************************************************************
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
 ******************************************************************************/
package maratona2010;

import java.util.Scanner;

public class Formula1 {
    public static void main(String[] args) {
        new Formula1().begin();
    }

    private void begin() {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        while (g != 0 || p != 0) {
            int results[][] = new int[g][p];
            for (int gp = 0; gp < g; gp++) {
                for (int pilot = 0; pilot < p; pilot++) {
                    results[gp][pilot] = sc.nextInt();
                }
            }

            int s = sc.nextInt();
            for (int sys = 0; sys < s; sys++) {
                int k = sc.nextInt();
                int system[] = new int[k];
                for (int pos = 0; pos < k; pos++) {
                    system[pos] = sc.nextInt();
                }

                int pilotsPoints[] = new int[p];
                for (int gp = 0; gp < g; gp++) {
                    for (int pilot = 0; pilot < p; pilot++) {
                        if (results[gp][pilot] <= k) {
                            pilotsPoints[pilot] += system[results[gp][pilot] - 1];
                        }
                    }
                }

                // Determina o máximo
                int res = pilotsPoints[0];
                StringBuilder sb = new StringBuilder("1");
                for (int i = 1; i < pilotsPoints.length; i++) {
                    if (pilotsPoints[i] > res) {
                        res = pilotsPoints[i];
                        sb = new StringBuilder("" + (i + 1));
                    } else if (pilotsPoints[i] == res) {
                        sb.append(" ");
                        sb.append((i + 1));
                    }
                }
                System.out.println(sb.toString());

            }

            g = sc.nextInt();
            p = sc.nextInt();
        }
    }
}
