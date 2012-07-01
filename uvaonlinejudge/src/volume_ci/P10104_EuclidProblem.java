/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2012  Fernando Cardoso
 * email: fernandohbc@gmail.com
 * Google+: plus.google.com/117689849496467534996
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
package volume_ci;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #10104 - Euclid Problem
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10104_EuclidProblem {
  // This is a simple implementation of the extended euclidean algorithm
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    while (scn.hasNextInt()) {
      int a = scn.nextInt();
      int b = scn.nextInt();

      int x = 0;
      int y = 1;
      int prev_x = 1;
      int prev_y = 0;
      while (b != 0) {
        int q = a/b;

        int tmp = b;
        b = a%b;
        a = tmp;

        int next_x = prev_x - q * x;
        prev_x = x;
        x = next_x;     

        int next_y = prev_y - q * y;
        prev_y = y;
        y = next_y;     
      }
      System.out.println(prev_x + " " + prev_y + " "  + a);
    }             
  }
}
