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
package volume_c;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #10000 - Longest Paths
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10000_LongestPaths {

  private static Scanner scn = new Scanner(System.in);

  private static class Point {
    int id;
    List<Point> adjacent = new LinkedList<Point>();
    int distance;

    Point(int id) {
      this.id = id;
    }
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    int tc = 0;
    while (n != 0) {
      // Create the nodes and put them in the map
      Point[] points = new Point[n + 1];
      for (int i = 1; i <= n; i++) {
        points[i] = new Point(i);
      }

      // The starting point
      int s = scn.nextInt();

      // The edges
      int p = scn.nextInt();
      int q = scn.nextInt();
      while (p != 0) {
        points[p].adjacent.add(points[q]);

        p = scn.nextInt();
        q = scn.nextInt();
      }

      // The BFS:
      List<Point> queue = new LinkedList<Point>();
      queue.add(points[s]);

      while (!queue.isEmpty()) {
        Point top = queue.remove(0);

        for (Point next : top.adjacent) {
          if (next.distance < top.distance + 1) {
            next.distance = top.distance + 1;
            queue.add(next);
          }
        }
      }

      // Gets the maximum level
      Point finalPoint = points[s];
      for (int i = 1; i <= n; i++) {
        if (points[i].distance > finalPoint.distance) {
          finalPoint = points[i];
        }
      }
      System.out
          .printf(
              "Case %d: The longest path from %d has length %d, finishing at %d.\n",
              ++tc, s, finalPoint.distance, finalPoint.id);
      n = scn.nextInt();
    }
  }
}
