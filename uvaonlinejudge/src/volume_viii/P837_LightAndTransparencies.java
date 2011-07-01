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
package volume_viii;

import java.util.Arrays;
import java.util.Scanner;

/**
 * UVa Online Judge - Problem 837: Light and Transparencies
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 * 
 */
public class P837_LightAndTransparencies {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int totalCases = scn.nextInt();
        for (int tc = 1; tc <= totalCases; tc++) {
            if (tc > 1) {
                System.out.println();
            }
            int segments = scn.nextInt();
            Endpoint[] endpoints = new Endpoint[2 * segments];
            for (int s = 0; s < segments; s++) {
                double x1 = scn.nextDouble();
                // y-values are irrelevant
                scn.nextDouble();

                double x2 = scn.nextDouble();
                // y-values are irrelevant
                scn.nextDouble();

                double transp = scn.nextDouble();

                double init = Math.min(x1, x2);
                double end = Math.max(x1, x2);

                endpoints[2 * s] = new Endpoint(init, transp);
                endpoints[2 * s + 1] = new Endpoint(end, 1.0 / transp);
            }

            Arrays.sort(endpoints);

            // Processing
            System.out.println(2 * segments + 1);
            System.out.printf("-inf %.3f 1.000\n", endpoints[0].x);

            double transp = 1;
            for (int ep = 1; ep < 2 * segments; ep++) {
                transp *= endpoints[ep - 1].f;
                System.out.printf("%.3f %.3f %.3f\n", endpoints[ep - 1].x,
                        endpoints[ep].x, transp);
            }

            System.out.printf("%.3f +inf 1.000\n",
                    endpoints[2 * segments - 1].x);
        }
    }
}

class Endpoint implements Comparable<Endpoint> {

    double x;
    double f;

    public Endpoint(double x, double f) {
        this.x = x;
        this.f = f;
    }

    @Override
    public int compareTo(Endpoint o) {
        return Double.compare(this.x, o.x);
    }
}