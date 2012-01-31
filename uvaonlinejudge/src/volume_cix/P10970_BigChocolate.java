/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2012  Fernando Cardoso
 * email: fernandohbc@gmail.com
 * +Fernando: https://plus.google.com/117689849496467534996
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
//Problem: 10970 - Big Chocolate
package volume_cix;

import java.util.Scanner;

public class P10970_BigChocolate {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    while (scn.hasNextInt()) {
      int m = scn.nextInt();
      int n = scn.nextInt();
      System.out.println(m * n - 1);
    }
  }
}
