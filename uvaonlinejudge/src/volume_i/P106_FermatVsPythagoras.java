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
package volume_i;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

/**
 * UVa Online Judge Problem #106 - Fermat vs. Pythagoras
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P106_FermatVsPythagoras {
  private static class Triple implements Comparable<Triple> {
    int a, b, c;
    Triple(int a, int b, int c) {
      this.a = Math.min(a,b);
      this.b = Math.max(a,b);
      this.c = c;
    }

    public int compareTo(Triple that) {
      int diff = this.c - that.c;
      if (diff != 0) return diff;
      diff = this.b - that.b;
      if (diff != 0) return diff;
      return this.a - that.a;
    }
  }

  private static final int MAX = 1000000;
  private static Scanner scn = new Scanner(System.in);
  private static String [] memo = new String[MAX+1];
  private static LinkedList<Triple> primitives;

  public static void main(String [] args) {
    genPrimitives();

    while (scn.hasNextLong()) {
      System.out.println(testCase(scn.nextInt()));
    }
  }

  private static void genPrimitives() {
    primitives = new LinkedList<Triple>();
    double sq = Math.sqrt(MAX);
    for (int n = 1; n <= sq; n++) {
      for (int m = n+1; m*m + n*n <= MAX; m++) {
        int x = (m*m - n*n);
        int y = 2*m*n;
        int z = (m*m + n*n);

        if (coprimes(x,y,z)) {
          primitives.add(new Triple(x, y, z));
        }
      }
    }
    Collections.sort(primitives);
  }

  private static String testCase(int N) {
    int c = 0;
    int count = N;
    boolean [] bitmap = new boolean[N+1];

    for (Triple t : primitives) {
      if (t.c > N) {
        break;
      }

      c++;

      for (int k = 1; k*t.c <= N; k++) {
        if (!bitmap[k*t.a]) {
          bitmap[k*t.a] = true;
          count--;
        }
        if (!bitmap[k*t.b]) {
          bitmap[k*t.b] = true;
          count--;
        }
        if (!bitmap[k*t.c]) {
          bitmap[k*t.c] = true;
          count--;
        }
      }
    }

    return c + " " + count;
  }

  private static boolean coprimes(long x, long y, long z) {
    return coprimes(x,y) && coprimes(y, z) && coprimes(x, z);
  }

  private static boolean coprimes(long x, long y) {
    return gdc(x, y) == 1;
  }


  private static long gdc(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gdc(b, a%b);
    }
  }
}
