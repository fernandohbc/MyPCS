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
public class P8302_Elevador {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int l = scn.nextInt();
        int c = scn.nextInt();
        int r1 = scn.nextInt();
        int r2 = scn.nextInt();
        while (l != 0 || c != 0 || r1 != 0 || r2 != 0) {

            // Diâmetro do maior cilindo
            int maxDiameter = 2 * Math.max(r1, r2);

            // Lado do quadrado mínimo
            double L = r1 + r2 + (r1 + r2) / Math.sqrt(2);

            int smallestSide = Math.min(l, c);
            int largestSide = Math.max(l, c);

            if (maxDiameter > smallestSide) {
                System.out.println("N");

            } // Checa se o menor comporta o "quadrado"
            else if (smallestSide >= L) {
                System.out.println("S");
            } else {
                double m = smallestSide - r1 - r2;
                double w = Math.sqrt((r1 + r2) * (r1 + r2) - m * m);
                double W = w + r1 + r2;

                System.out.println(W <= largestSide ? "S" : "N");
            }

            l = scn.nextInt();
            c = scn.nextInt();
            r1 = scn.nextInt();
            r2 = scn.nextInt();
        }
    }
}
