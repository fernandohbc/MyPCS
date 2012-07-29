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
package volume_iv;

import java.util.HashMap;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #417 - Word Index
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P417_WordIndex {

  private static Scanner scn = new Scanner(System.in);

  // Last word of each size
  private static String[] suffix = { "", "z", "yz", "xyz", "wxyz" };

  // Cache
  private static HashMap<String, Integer> cache = new HashMap<String, Integer>();

  public static void main(String[] args) {
    while (scn.hasNextLine()) {
      String word = scn.nextLine();
      if (!isValid(word)) {
        System.out.println("0");
      } else {
        System.out.println(index(word));
      }
    }
  }

  private static int index(String word) {
    if (cache.containsKey(word)) {
      return cache.get(word);
    }
    String rev = new StringBuilder(word).reverse().toString();
    int idx = ord(rev.charAt(0));
    for (int i = 1; i < rev.length(); i++) {
      idx += index(dec(rev.charAt(i)) + suffix[i])
          - index(rev.charAt(i) + suffix[i - 1]);
    }
    cache.put(word, idx);
    return idx;
  }

  private static String dec(char c) {
    String dec = "";
    if (c != 'a') {
      dec += (char) (ord(c) - 2 + 'a');
    }
    return dec;
  }

  // Ordinal of the char, from 'a'
  private static int ord(char c) {
    return c - 'a' + 1;
  }

  // Valid iff ci < ci+1 for all chars in word
  private static boolean isValid(String word) {
    for (int i = 0; i <= word.length() - 2; i++) {
      if (word.charAt(i) >= word.charAt(i + 1)) {
        return false;
      }
    }
    return true;
  }
}
