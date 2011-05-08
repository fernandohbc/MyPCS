/*
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
 */
// @JUDGE_ID:  33089  100  Java  "Easy algorithm"
package volume_i;

import java.util.Scanner;

public class P100_33089 {
	
    public static void main (String args[]) {
		new P100_33089().begin();
    }

    public void begin() {
    	Scanner scn =  new Scanner( System.in );
        long a, b, min, max, num, n, cycle, cyclemax;

        while (scn.hasNextLong()) {
          a = scn.nextLong();
          b = scn.nextLong();
          if (a < b) { min=a; max=b; } else { min=b; max=a; }
          for (cyclemax=-1, num=min; num<=max; num++) {
            for (n=num, cycle=1; n != 1; cycle++) {
            	if ((n % 2) != 0) { 
            		n=3*n+1;
            	} else {
            		n >>= 1;
            	}
            }
            if (cycle > cyclemax) {
            	cyclemax=cycle;
            }
          }
          System.out.println (a + " " + b + " " + cyclemax);
        }
    }
}
