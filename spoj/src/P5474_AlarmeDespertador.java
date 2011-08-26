import java.util.Scanner;

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

/**
 * SPOJ Problem #5474. Alarme Despertador
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P5474_AlarmeDespertador {
    private static final int MINUTES_IN_DAY = 24 * 60;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h1 = scn.nextInt();
        int m1 = scn.nextInt();
        int h2 = scn.nextInt();
        int m2 = scn.nextInt();
        while (h1 != 0 || m1 != 0 || h2 != 0 || m2 != 0) {

            m1 += h1 * 60;
            m2 += h2 * 60;

            int m = m2 - m1;
            m = m > 0 ? m : MINUTES_IN_DAY + m;

            System.out.println(m);

            h1 = scn.nextInt();
            m1 = scn.nextInt();
            h2 = scn.nextInt();
            m2 = scn.nextInt();
        }
    }
}
