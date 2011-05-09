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
package volume_c;

import java.util.Scanner;

public class P10066_3747 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int tamA = scn.nextInt();
    int tamB = scn.nextInt();
    int tc = 1;
    while (tamA > 0 || tamB > 0) {
      // L� os vetores...
      int[] a = new int[tamA];
      int[] b = new int[tamB];

      for (int i = 0; i < tamA; i++) {
        a[i] = scn.nextInt();
      }
      for (int i = 0; i < tamB; i++) {
        b[i] = scn.nextInt();
      }

      int maxSub = maxSubsequencia(a, b);

      System.out.println("Twin Towers #" + tc++);
      System.out.println("Number of Tiles : " + maxSub + "\n");

      // Recome�a
      tamA = scn.nextInt();
      tamB = scn.nextInt();
    }

  }

  public static int maxSubsequencia(int[] a, int[] b) {
    int tabela[][] = new int[a.length + 1][b.length + 1];
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          tabela[i][j] = tabela[i - 1][j - 1] + 1;
        }
        else {
          tabela[i][j] =
              max(tabela[i - 1][j - 1], tabela[i - 1][j], tabela[i][j - 1]);
        }
      }
    }
    return tabela[a.length][b.length];
  }

  public static int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }
}
