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

// @JUDGE_ID:  33089  10370  Java  "Above Average"
package volume_ciii;

import java.util.StringTokenizer;

class P10370_33089 {
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
    (new P10370_33089()).begin();
  }

  private void begin() {
    int c = Integer.parseInt(readLn());
    for (int i = 0; i < c; i++) {
      int n = getNum();
      int grades[] = new int[n];
      long sum = 0;
      for (int j = 0; j < n; j++) {
        grades[j] = getNum();
        sum = sum + grades[j];
      }
      double avg = (double) sum / n;
      int qtdAbove = 0;
      for (int j = 0; j < n; j++) {
        if (grades[j] > avg) {
          qtdAbove++;
        }
      }
      double perc = (double) qtdAbove * 100 / n;
      perc = Math.round(perc * 1000) / (double) 1000;
      String percString = String.valueOf(perc);
      while (percString.indexOf('.') > percString.length() - 4) {
        percString = percString + "0";
      }
      System.out.println(percString + "%");
    }
  }

  String input;
  StringTokenizer st;

  private int getNum() {
    if (st == null || !st.hasMoreTokens()) {
      input = readLn();
      st = new StringTokenizer(input);
    }
    int num = Integer.parseInt(st.nextToken());
    return num;
  }
}
