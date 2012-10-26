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
package volume_ciii;

import java.util.Scanner;

public class P10361_AutomaticPoetry {
  private static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scn.nextInt();
    // Ignores rest of the line.
    scn.nextLine();

    for (int i = 0; i < n; i++) {
      executeTestCase();
    }
  }

  private static void executeTestCase() {
    String line1 = scn.nextLine();
    String[] splt = line1.split("[<>]");
    String[] s = new String[5];
    for (int i = 0; i < 5; i++) {
      s[i] = i < splt.length ? splt[i] : "";
    }
    System.out.println(s[0] + s[1] + s[2] + s[3] + s[4]);
    String line2 = scn.nextLine();
    System.out.println(line2.substring(0, line2.indexOf('.')) + s[3] + s[2]
        + s[1] + s[4]);
  }
}
