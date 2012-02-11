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
//Problem 10034: Freckles
package volume_c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class P10034_Freckles {
  public static class Freckle {
    private double x;
    private double y;

    public Freckle(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(x);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(y);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Freckle other = (Freckle) obj;
      if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
        return false;
      if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
        return false;
      return true;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int testCases = scn.nextInt();
    for (int tc = 0; tc < testCases; tc++) {
      if (tc > 0) {
        System.out.println();
      }
      int v = scn.nextInt();
      List<Freckle> freckles = new ArrayList<Freckle>(v);
      for (int vi = 0; vi < v; vi++) {
        double x = scn.nextDouble();
        double y = scn.nextDouble();
        Freckle freckle = new Freckle(x, y);
        freckles.add(freckle);
      }
      System.out.printf("%.2f\n", mst(freckles));
    }
  }

  // Implements Prim's algorithm
  public static class Edge implements Comparable<Edge> {
    private Freckle from;
    private Freckle to;

    public Edge(Freckle from, Freckle to) {
      this.from = from;
      this.to = to;
    }

    public double getWeight() {
      return Math.sqrt((from.x - to.x) * (from.x - to.x) + (from.y - to.y)
          * (from.y - to.y));
    }

    @Override
    public int compareTo(Edge o) {
      return Double.compare(this.getWeight(), o.getWeight());
    }
  }

  private static double mst(List<Freckle> freckles) {
    // Initialization: uses the first freckle as the initial connected vertex
    Freckle f = freckles.get(0);

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    Set<Freckle> connected = new HashSet<Freckle>();
    Set<Freckle> unconnected = new HashSet<Freckle>(freckles);

    updateDataStructures(f, pq, connected, unconnected);

    // Main loop
    double totalWeight = 0;
    while (!unconnected.isEmpty()) {
      Edge e = null;
      Freckle added = null;
      do {
        e = pq.poll();
        added = getUnconnectedFromEdge(e, connected, unconnected);
      } while (added == null);
      totalWeight += e.getWeight();
      updateDataStructures(added, pq, connected, unconnected);
    }
    return totalWeight;
  }

  private static void updateDataStructures(Freckle freckle,
      PriorityQueue<Edge> pq, Set<Freckle> connected, Set<Freckle> unconnected) {
    unconnected.remove(freckle);
    connected.add(freckle);
    for (Freckle to : unconnected) {
      pq.add(new Edge(freckle, to));
    }
  }

  private static Freckle getUnconnectedFromEdge(Edge e, Set<Freckle> connected,
      Set<Freckle> unconnected) {
    if (connected.contains(e.from)) {
      if (unconnected.contains(e.to)) {
        return e.to;
      }
    }
    if (connected.contains(e.to)) {
      if (unconnected.contains(e.from)) {
        return e.from;
      }
    }
    return null;
  }
}
