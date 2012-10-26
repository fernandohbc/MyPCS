package volume_civ;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #10474 - Where is the Marble
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10474_WhereIsTheMarble {
  // public class Main {
  private static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    int tc = 1;
    while (executeTestCase(tc++)) {
    }
  }

  private static boolean executeTestCase(int tc) {
    int n = scn.nextInt();
    int q = scn.nextInt();

    if (n == 0 && q == 0) {
      return false;
    }

    System.out.println("CASE# " + tc + ":");
    int[] marbles = new int[10001];
    for (int i = 0; i < n; i++) {
      int x = scn.nextInt();
      marbles[x]++;
    }

    // Processing
    int lastIdx = 0;
    for (int x = 1; lastIdx < n; x++) {
      if (marbles[x] != 0) {
        int tmp = lastIdx;
        lastIdx = lastIdx + marbles[x];
        marbles[x] = tmp + 1;
      }
    }

    for (int i = 0; i < q; i++) {
      int x = scn.nextInt();
      int pos = marbles[x];
      if (pos > 0) {
        System.out.println(x + " found at " + pos);
      } else {
        System.out.println(x + " not found");
      }
    }

    return true;
  }
}
