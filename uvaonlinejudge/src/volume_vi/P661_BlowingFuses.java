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
package volume_vi;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #661: Blowing Fuses
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / twitter: fernando_hbc)
 */
public class P661_BlowingFuses {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int s = 1;
        int n = scn.nextInt();
        int m = scn.nextInt();
        int c = scn.nextInt();

        while (n != 0 && m != 0 && c != 0) {
            int cons[] = new int[n];
            boolean state[] = new boolean[n];

            for (int i = 0; i < n; i++) {
                cons[i] = scn.nextInt();
            }

            int consumption = 0;
            int maxConsumption = 0;
            boolean blown = false;
            for (int i = 0; i < m; i++) {
                int dev = scn.nextInt() - 1;
                if (!blown) {
                    state[dev] = !state[dev];
                    consumption += cons[dev] * (state[dev] ? 1 : -1);

                    if (consumption > maxConsumption) {
                        maxConsumption = consumption;
                        if (maxConsumption > c) {
                            blown = true;
                        }
                    }
                }
            }

            System.out.println("Sequence " + s++);
            if (blown) {
                System.out.println("Fuse was blown.");
            } else {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was "
                        + maxConsumption + " amperes.");
            }
            System.out.println();
            n = scn.nextInt();
            m = scn.nextInt();
            c = scn.nextInt();
        }
    }
}
