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
package volume_cxiv;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #11498 - Division of Nlogonia
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11498_DivisionOfNlogonia {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int pt = scn.nextInt();
        while (pt != 0) {
            int x = scn.nextInt();
            int y = scn.nextInt();

            for (int i = 0; i < pt; i++) {
                int xp = scn.nextInt();
                int yp = scn.nextInt();

                if (xp == x || yp == y) {
                    System.out.println("divisa");
                } else {
                    if (xp < x) {
                        if (yp < y) {
                            System.out.println("SO");
                        } else {
                            System.out.println("NO");
                        }
                    } else {
                        if (yp < y) {
                            System.out.println("SE");
                        } else {
                            System.out.println("NE");
                        }
                    }
                }
            }

            pt = scn.nextInt();
        }
    }
}
