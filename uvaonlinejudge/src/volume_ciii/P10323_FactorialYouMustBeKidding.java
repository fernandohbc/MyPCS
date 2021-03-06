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

//Problem P10323: Factorial! You Must be Kidding!!!
package volume_ciii;

import java.util.Scanner;

public class P10323_FactorialYouMustBeKidding {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    while (scn.hasNextInt()) {
      System.out.println(weirdFactorial(scn.nextInt()));
    }
  }

  // Factorial from 8 to 13
  private static String[] validFactorial = { "40320", "362880", "3628800",
      "39916800", "479001600", "6227020800" };

  public static String weirdFactorial(int i) {
    if (i < 0) {
      return (i % 2) == 0 ? "Underflow!" : "Overflow!";
    }
    if (i < 8) {
      return "Underflow!";
    }
    if (i > 13) {
      return "Overflow!";
    }
    return validFactorial[i - 8];
  }
}