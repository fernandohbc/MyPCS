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

/**
 * UVa Online Judge Problem #10324 - Zeros and Ones
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10324_ZerosAndOnes {
  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    int tc = 1;
    while (scn.hasNextLine()) {
      System.out.println("Case " + tc++ + ":");
      String line = scn.nextLine();
      Interval [] intervals = parse(line);

      int q = scn.nextInt();
      for (int i = 0; i < q; i++) {
        Interval query = new Interval(scn);
        boolean isAllSame = isAllSame(query, intervals);

        System.out.println(isAllSame?"Yes":"No");
      }

      // Let go the rest of the line
      scn.nextLine();
    }
  }

  private static boolean isAllSame(Interval query, Interval [] intervals) {
    Interval overlapping = getOverlappingInterval(query, intervals);
    return (query.start >= overlapping.start && query.end <= overlapping.end);
  }

  private static Interval getOverlappingInterval(Interval query, Interval [] intervals) {
    int b = 0;
    int e = intervals.length;

    while (b<=e) {
      int m = (b+e)/2;
      Interval median = intervals[m];
      if (median.start <= query.start && median.end >= query.start) {
        return median;
      }

      // Update search range
      if (median.start > query.start) {
        e = m-1;
      } else {
        b = m+1;
      }
    }

    return null;
  }

  private static Interval[] parse(String line) {
    List<Interval> intervalList = new LinkedList<Interval>();
    char [] lineArr = line.toCharArray(); 
    char currChar = lineArr[0];
    int currStart = 0;
    for (int i = 1; i < lineArr.length; i++) {
      if (lineArr[i] != currChar) {
        intervalList.add(new Interval(currStart, i-1));
        currStart = i;
        currChar = lineArr[i];
      }
    }

    // For the last interval
    intervalList.add(new Interval(currStart, lineArr.length-1));

    return intervalList.toArray(new Interval[0]);
  }

  private static class Interval {
    int start;
    int end;

    Interval(int a, int b) {
      this.start = Math.min(a,b);
      this.end = Math.max(a,b);
    }

    Interval(Scanner scn) {
      this(scn.nextInt(), scn.nextInt());
    }
  }
}
