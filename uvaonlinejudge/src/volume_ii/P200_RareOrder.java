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
package volume_ii;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.HashMap;

/**
 * UVa Online Judge Problem #200 - Rare Order
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P200_RareOrder {
  public static void main(String [] args) {
    TreeSet<Character> hasIncoming = new TreeSet<Character>();
    TreeSet<Character> noIncoming = new TreeSet<Character>();

    HashMap<Character, Set<Character>> in = new HashMap<Character, Set<Character>>();
    HashMap<Character, Set<Character>> out = new HashMap<Character, Set<Character>>();

    Scanner scn = new Scanner(System.in);
    String prev = scn.nextLine().trim();
    String next = scn.nextLine().trim();
    while (!"#".equals(next)) {
      Edge edge = readEdge(prev, next);

      if (edge != null) {
        // Update incoming sets
        // to vertex HAS incoming.
        hasIncoming.add(edge.to);
        noIncoming.remove(edge.to);

        //  from vertex may have incoming
        if (!hasIncoming.contains(edge.from)) {
          noIncoming.add(edge.from);
        }

        // Update edge maps
        put(out, edge.from, edge.to);
        put(in, edge.to, edge.from);
      }

      prev = next;
      next = scn.nextLine().trim();
    }

    // Main algorithm
    LinkedList<Character> ordering = new LinkedList<Character>();
    while (!noIncoming.isEmpty()) {
      char from = noIncoming.pollFirst();
      ordering.add(from);

      // remove edges
      Set<Character> outgoing = out.remove(from);
      if (outgoing != null ) {
        for (char to : outgoing) {
          Set<Character> fromSet = in.get(to); 
          fromSet.remove(from);
          if (fromSet.isEmpty()) {
            noIncoming.add(to);
            in.remove(to);
          }
        }
      }
    } 

    output(ordering);
  }

  private static class Edge {
    char from, to;
  }
  private static Edge readEdge(String a, String b) {
    // System.out.println("Comparing " + a + " to " + b);
    for (int i = 0; i < a.length() && i < b.length(); i++) {
      // System.out.println("i = " + i);
      // System.out.println("Comparing " + a.charAt(i) + " to " + b.charAt(i));
      if (a.charAt(i) != b.charAt(i)) {
        Edge e = new Edge();
        e.from = a.charAt(i);
        e.to = b.charAt(i);
        return e;
      }
    }
    return null;
  }

  private static void output(List<Character> ordering) {
    StringBuilder outBuff = new StringBuilder();
    for (char i : ordering) {
      outBuff.append(i);
    }
    System.out.println(outBuff.toString());
  }

  private static void put(HashMap<Character, Set<Character>> set, char key, char value) {
    Set<Character> inner = set.get(key);
    if (inner == null) {
      inner = new TreeSet<Character>();
      set.put(key, inner);
    }
    inner.add(value);
  }
}
