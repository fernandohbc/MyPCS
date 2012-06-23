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
package volume_v;

import java.util.Arrays;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #562 - Dividing coins
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P562_DividingCoins {
  private static Scanner scn = new Scanner(System.in);

  public static void main(String [] args) {
    int n = scn.nextInt();
    for (int i = 0; i < n; i++) {
      testCase();
    }
  }

  public static void testCase() {
    int m = scn.nextInt();

    // Special case when there are 0 coins
    if (m == 0) {
      System.out.println("0");
      return;
    }

    int [] coins = new int[m];

    int sum = 0;
    for (int i = 0; i < m; i++) {
      coins[i] = scn.nextInt();
      sum += coins[i];
    }

    boolean [][] table = new boolean[m][sum+1];
    table[0][0] = true; // Zero is possible!
    table[0][coins[0]] = true; // The first coin is possible

    for (int i = 1; i < m; i++) {
      for (int s = 0; s <= sum - coins[i]; s++) {
        if (table[i-1][s]) {
          table[i][s] = true; // Still possible
          table[i][s+coins[i]] = true; // New possible sum
        }
      }
    }

    int k = sum / 2; // Middle point of the table
    while (!table[m-1][k]) {
      k--;
    }

    System.out.println(sum - 2*k);
  }
}
