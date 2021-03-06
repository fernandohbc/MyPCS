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

// @JUDGE_ID:  33089  10302  Java  "Summation of Polynomials"
package volume_ciii;

class P10302_33089 {
  // Rotina de Leitura
  static String readLn() {
    String newLine = System.getProperty("line.separator");
    StringBuffer buffer = new StringBuffer();
    int car = -1;
    try {
      car = System.in.read();
      while ((car > 0) && (car != newLine.charAt(0))) {
        buffer.append((char) car);
        car = System.in.read();
      }
      if (car == newLine.charAt(0)) {
        System.in.skip(newLine.length() - 1);
      }
    } catch (java.io.IOException e) {
      return (null);
    }
    if ((car < 0) && (buffer.length() == 0)) {
      return (null);
    }
    return (buffer.toString().trim());
  }

  public static void main(String[] args) {
    (new P10302_33089()).begin();
  }

  private void begin() {
    String input = readLn();
    while (input != null) {
      long n = Integer.parseInt(input);
      System.out.println(sumOfCubes(n));
      input = readLn();
    }
  }

  private long sumOfCubes(long n) {
    return (n * (n + 1) / 2) * (n * (n + 1) / 2);
  }
}
