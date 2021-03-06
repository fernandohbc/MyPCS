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
//Problem 147: Dollars
package volume_i;

import java.util.Scanner;

public class P147_Dollars {
  long ways[][] = new long[11][6001];

  public static void main(String[] args) {
    (new P147_Dollars()).begin();
  }

  private void begin() {
    countWays(6000, 10);
    Scanner scn = new Scanner(System.in);
    double value = scn.nextDouble();
    while (value != 0) {
      int intValue = (int) Math.round(value * 100);
      intValue /= 5;
      System.out.printf("%6.2f%17s\n", value, countWays(intValue, 10));
      value = scn.nextDouble();
    }
  }

  private int coinValue(int i) {
    switch (i) {
    case 10:
      return 2000;
    case 9:
      return 1000;
    case 8:
      return 400;
    case 7:
      return 200;
    case 6:
      return 100;
    case 5:
      return 40;
    case 4:
      return 20;
    case 3:
      return 10;
    case 2:
      return 4;
    case 1:
      return 2;
    }
    return 1;
  }

  private long countWays(int value, int coin) {
    if (ways[coin][value] != 0) {
      return ways[coin][value];
    }
    if (value == 0 || coin == 0) {
      ways[coin][value] = 1;
      return ways[coin][value];
    } else {
      int qtCoin = value / coinValue(coin);
      long result = 0;
      for (int i = 0; i <= qtCoin; i++) {
        result += countWays(value - i * coinValue(coin), (coin - 1));
      }
      ways[coin][value] = result;
      return result;
    }
  }
}
