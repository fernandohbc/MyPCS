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

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * UVa Online Judge Problem #10099 - The Tourist Guide
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10099_TheTouristGuide {
  private static Scanner scn = new Scanner(System.in);

  public static void main(String [] args) {
    int n = scn.nextInt();
    int r = scn.nextInt();
    int tc = 1;
    while (n != 0 || r != 0) {
      testCase(tc++, n, r);
      n = scn.nextInt();
      r = scn.nextInt();
    }
  }

  private static class Pair implements Comparable<Pair> {
    int vertex;
    int cap;

    Pair(int vertex, int cap) {
      this.vertex = vertex;
      this.cap = cap;
    }

    @Override
    public int compareTo(Pair that) {
      // Reverse order of distance
      return that.cap - this.cap; 
    }
  }

  private static void testCase(int tc, int n, int r) {
    int [][] graph = getGraph(n, r);
    int origin = scn.nextInt();
    int finnal = scn.nextInt();
    int tourists = scn.nextInt();

    Pair p = new Pair(origin, Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    pq.add(p);

    TreeSet<Integer> processed = new TreeSet<Integer>();

    while (!pq.isEmpty()) {
      p = pq.poll();
      if (processed.contains(p.vertex)) {
        continue;
      }
      if (p.vertex == finnal) {
        System.out.println("Scenario #" + tc);
        int trips = calcTrips(tourists, p.cap);
        System.out.println("Minimum Number of Trips = " + trips);
        System.out.println();
        return;
      }
      processed.add(p.vertex);
      for (int t = 1; t <= n; t++) {
        if (graph[p.vertex][t] != 0) {
          pq.add(new Pair(t, Math.min(p.cap, graph[p.vertex][t]))); 
        }
      }
    }
  }

  private static int calcTrips(int tourists, int cap) {
    return (tourists/(cap-1)) + (tourists%(cap-1) == 0?0:1);
  }

  private static int [][] getGraph(int n, int r) {
    int [][] graph = new int[n+1][n+1];
    for (int i = 0; i < r; i++) {
      int from = scn.nextInt();
      int to = scn.nextInt();
      int cap = scn.nextInt();
      graph[from][to] = cap;
      graph[to][from] = cap;
    }
    return graph;
  } 
}
