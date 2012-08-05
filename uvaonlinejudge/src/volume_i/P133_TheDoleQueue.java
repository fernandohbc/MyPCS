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

import java.util.Scanner;

/**
 * UVa Online Judge Problem #133 - The Dole Queue
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P133_TheDoleQueue {

  private static final int FORWARD = 1;
  private static final int BACKWARDS = -1;
  private static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    int N = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    while (N != 0) {
      boolean[] offQueue = new boolean[N];
      int offCount = 0;
      int kdx = 0;
      int mdx = N - 1;
      StringBuilder sb = new StringBuilder();
      while (offCount < N) {
        kdx = count(k, offQueue, kdx, FORWARD);
        mdx = count(m, offQueue, mdx, BACKWARDS);
        addToOutput(sb, kdx + 1, mdx + 1);
        offQueue[kdx] = true;
        offQueue[mdx] = true;
        offCount += kdx == mdx ? 1 : 2;
      }
      System.out.println(sb.deleteCharAt(sb.length() - 1));
      N = scn.nextInt();
      k = scn.nextInt();
      m = scn.nextInt();
    }
  }

  private static void addToOutput(StringBuilder sb, int kdx, int mdx) {
    addToOutput(sb, kdx);
    if (mdx != kdx) {
      addToOutput(sb, mdx);
    }
    sb.append(",");
  }

  private static void addToOutput(StringBuilder sb, int n) {
    sb.append(" ");
    if (n < 10) {
      sb.append(" ");
    }
    sb.append(n);
  }

  private static int count(int q, boolean[] offQueue, int qdx, int direction) {
    int count = 0;
    while (count < q) {
      if (!offQueue[qdx]) {
        count++;
      }
      if (count < q) {
        qdx += direction + offQueue.length;
        qdx %= offQueue.length;
      }
    }
    return qdx;
  }

}
