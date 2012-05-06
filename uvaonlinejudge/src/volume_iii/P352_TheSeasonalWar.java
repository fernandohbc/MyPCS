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
package volume_iii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #352 - The Seasonal War
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P352_TheSeasonalWar {
  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    int tc = 1;
    while (scn.hasNextInt()) {
      int l = scn.nextInt();
      // +2 in each side to simplify marking
      byte[][] img = new byte[l+2][l+2];
      // Disregard remaining line
      scn.nextLine();

      // Reads the "image"
      for (int i = 1; i <= l; i++) {
        char [] line = scn.nextLine().toCharArray();
        for (int j = 1; j <= l; j++) {
          img[i][j] = (byte)(line[j-1] - '0');
        }
      }

      int eagles = countEagles(img);

      System.out.println("Image number " + tc++ + " contains " + eagles + " war eagles.");
    }
  }

  private static void mark(byte[][] img, int i, int j) {
    // System.out.println("Marking: " + i + "  " + j);
    img[i][j] = -1;
    for (int k = -1; k <= 1; k++) {
      for (int l = -1; l <= 1; l++) {
        int ii = i + k;
        int jj = j + l;
        // System.out.println("Looking: " + ii + "  " + jj);
        if (img[ii][jj] > 0) {
          mark(img, ii, jj);
        }
      }
    }
  }

  private static int countEagles(byte[][] img) {
    int count = 0;
    int l = img.length - 2;
    for (int i = 1; i <= l; i++) {
      for (int j = 1; j <= l; j++) {
        if (img[i][j] > 0) {
          count++;
          mark(img, i, j);
        }
      }
    }
    return count;
  } 
}
