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
package volume_v;

import java.util.Scanner;

public class P573 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h = scn.nextInt() * 100;
        while (h != 0) {
            int u = scn.nextInt() * 100;
            int d = scn.nextInt() * 100;
            int f = scn.nextInt();

            int fDay = (u / 100) * f;

            int day = 1;
            int beforeClimbing = 0;
            int climbed = u;
            int afterClimbing = beforeClimbing + climbed;
            int afterSliding = afterClimbing - d;

            while (afterClimbing <= h && afterSliding >= 0) {
                day++;
                beforeClimbing = afterSliding;
                climbed = climbed - fDay;
                if (climbed >= 0) {
                    afterClimbing = beforeClimbing + climbed;
                } else {
                    afterClimbing = beforeClimbing;
                }
                afterSliding = afterClimbing - d;
            }

            if (afterClimbing > h) {
                System.out.println("success on day " + day);
            } else {
                System.out.println("failure on day " + day);
            }

            h = scn.nextInt() * 100;
        }
    }
}