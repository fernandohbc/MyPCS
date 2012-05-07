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
package volume_cv;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * GETTING WA! GETTING WA! GETTING WA!
 * UVa Online Judge Problem #10591 - Happy Number
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10591_HappyNumber {
  private static TreeSet<Long> happy = new TreeSet<Long>();
  private static TreeSet<Long> unhappy = new TreeSet<Long>();
  private static TreeSet<Long> unsure = new TreeSet<Long>();

  private static long squareDigits(long n) {
    long res = 0;
    while (n > 0) {
      long d = n%10;
      res += d*d;
      n /= 10;
    }
    return res;
  }

  private static boolean isHappy(long n) {
    if (happy.contains(n)) {
      return true;
    }

    if (unhappy.contains(n) || unsure.contains(n)) {
      return false;
    }

    unsure.add(n);
    boolean isHappy = isHappy(squareDigits(n));

    if (isHappy) {
      happy.addAll(unsure);
    } else {
      unhappy.addAll(unsure);
    }
    unsure.clear();
    return isHappy;
  }

  public static void main(String [] args) {
    happy.add(1L);
    Scanner scn = new Scanner(System.in);

    int tc = scn.nextInt();
    for (int i = 1; i <= tc; i++) {
      int n = scn.nextInt();
      System.out.println("Case #" + i + ": " + n + " is " + (isHappy(n)?"a Happy":"an Unhappy") + " number.");
      // System.out.println("Happy = " + happy);
      // System.out.println("Unhappy = " + unhappy);
    }
  }
}
