/* MyPCS - My Programming Contests Solutions
 *
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
package volume_cvi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #10608 - Friends
 */
public class P10608_Friends {
  private static class Vertex {
    boolean grouped = false;

    List<Vertex> adjacency = new LinkedList<Vertex>();
  }

  private static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    int totTc = scn.nextInt();
    for (int tc = 0; tc < totTc; tc++) {
      executeTestCase();
    }
  }

  private static void executeTestCase() {
    // Builds the adjacency list
    int n = scn.nextInt();
    Vertex[] graph = new Vertex[n + 1];
    for (int v = 1; v <= n; v++) {
      graph[v] = new Vertex();
    }

    // Reads the edges
    int m = scn.nextInt();
    for (int e = 0; e < m; e++) {
      int e1 = scn.nextInt();
      int e2 = scn.nextInt();
      graph[e1].adjacency.add(graph[e2]);
      graph[e2].adjacency.add(graph[e1]);
    }

    // Runs a BSF for every ungrouped
    int group = -1;
    for (int v = 1; v <= n; v++) {
      if (!graph[v].grouped) {
        group = Math.max(group, extractGroup(graph[v]));
      }
    }

    System.out.println(group);
  }

  private static int extractGroup(Vertex vertex) {
    Queue<Vertex> queue = new LinkedList<Vertex>();
    queue.add(vertex);
    int size = 0;
    while (!queue.isEmpty()) {
      Vertex v = queue.poll();
      if (!v.grouped) {
        size++;
        v.grouped = true;
        for (Vertex a : v.adjacency) {
          queue.add(a);
        }
      }
    }
    return size;
  }
}
