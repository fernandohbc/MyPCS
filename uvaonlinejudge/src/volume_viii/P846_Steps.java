/* MyPCS - My Programming Contests Solutions
 *
 * Copyright (C) 2007 - 2012  Fernando Cardoso
 * email: fernandohbc@gmail.com
 * Google+: plus.google.com/117689849496467534996
 *  
 * 
 * SPOILER ALERT!
 * These are the solutions for problems from Programming Contests and Online
 * Judges. Seeing an accepted code before getting accepted by oneself is uncool.
 * 
 * Q: So why are the solutions being made available?
 * A: For educational purposes only. Some of the problems can be used in Contests
 * training (even if it is to show how NOT to do :-) ) and also can serve to
 * compare solutions and algorithms. Also, the author thinks it is cool to have
 * his code well versioned.
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

import java.util.Scanner;

public class P846_Steps {
  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    int tc = scn.nextInt();
    for (int i = 0; i < tc; i++) {
      int a = scn.nextInt();
      int b = scn.nextInt();

      int n = b-a;

      long steps = m(n);

      System.out.println(steps);
    }
  }

  // This is a calculation of what the recursive algorithm does.
  private static long m(int d) {
    if (d==0) {
      return 0;
    }

    double q = (Math.sqrt(1+4*d)-1)/2.0;
    long cq = Math.round(Math.ceil(q));
    long cn = cq*cq+cq;
    long diff = cn - d;
    return diff < cq?2*cq:2*cq-1;
  }

  private static long m(int d, int lastStep) {
    // Cannot walk a negative distance
    if (d < 0) {
      return Integer.MAX_VALUE;
    }

    // We're done!
    if (d == 0) {
      return 0;
    }

    return Math.min(Math.min(changingStep(d, lastStep-1), sameStep(d, lastStep)), changingStep(d, lastStep+1));
  }

  private static long sameStep(int d, int step) {
    if (step < 1) {
      return Integer.MAX_VALUE;
    }

    long res = 1 + m(d - step, step);
    return res;
  }

    
  private static long changingStep(int d, int step) {
    if (step < 1) {
      return Integer.MAX_VALUE;
    }

    if (d == step) {
      return 1;
    }

    long res = 2 + m(d-2*step, step);
    return res;
  }
}
