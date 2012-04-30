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
package volume_ciii;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.HashMap;

public class P10305_OrderingTasks {
  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    int v = scn.nextInt();
    int e = scn.nextInt();
    while (v != 0 || e !=0) {
      // Initialize no incoming set
      TreeSet<Integer> noIncoming = new TreeSet<Integer>();
      for (int i = 1; i <= v; i++) {
        noIncoming.add(i);
      }

      // Read edges
      HashMap<Integer, Set<Integer>> in = new HashMap<Integer, Set<Integer>>();
      HashMap<Integer, Set<Integer>> out = new HashMap<Integer, Set<Integer>>();
      for (int i = 0; i < e; i++) {
        int from = scn.nextInt();
        int to = scn.nextInt();

        put(out, from, to);
        put(in, to, from);

        noIncoming.remove(to);
      }

      // Main algorithm
      LinkedList<Integer> ordering = new LinkedList<Integer>();
      while (!noIncoming.isEmpty()) {
        int from = noIncoming.pollFirst();
        ordering.add(from);

        // remove edges
        Set<Integer> outgoing = out.remove(from);
        if (outgoing != null ) {
          for (int to : outgoing) {
            Set<Integer> fromSet = in.get(to); 
            fromSet.remove(from);
            if (fromSet.isEmpty()) {
              noIncoming.add(to);
              in.remove(to);
            }
          }
        }
      }

      output(ordering);

      // new iteration
      v = scn.nextInt();
      e = scn.nextInt();
    }
  }

  private static void output(List<Integer> ordering) {
    StringBuilder outBuff = new StringBuilder();
    for (int i : ordering) {
      outBuff.append(i);
      outBuff.append(" ");
    }
    outBuff.setLength(outBuff.length()-1);
    System.out.println(outBuff.toString());
  }

  private static void put(HashMap<Integer, Set<Integer>> set, int key, int value) {
    Set<Integer> inner = set.get(key);
    if (inner == null) {
      inner = new TreeSet<Integer>();
      set.put(key, inner);
    }
    inner.add(value);
  }
}
