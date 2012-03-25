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
package volume_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * UVa Online Judge Problem #156 - Ananagrams
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P156_Ananagrams {
  private static Map<String, String> anagramClasses = new HashMap<String, String>();
  private static Set<String> ananagrams = new TreeSet<String>();

  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    String word = scn.next();
    while (!"#".equals(word)) {
      process(word);
      word = scn.next();
    }
    for (String ananagram : ananagrams) {
      System.out.println(ananagram);
    }
  }

  private static void process(String word) {
    String fingerPrint = getFingerPrint(word);
    if (!anagramClasses.containsKey(fingerPrint)) {
      anagramClasses.put(fingerPrint, word); 
      ananagrams.add(word);
    } else if (!word.equals(anagramClasses.get(fingerPrint))) {
      // If contains the key and is not the same word again, it is NOT an Ananagram, so remove it
      // from the ananagrams
      ananagrams.remove(anagramClasses.get(fingerPrint));
    } 
  }

  private static String getFingerPrint(String word) {
    char [] fingerPrintArr = word.toLowerCase().toCharArray();
    Arrays.sort(fingerPrintArr);
    return new String(fingerPrintArr);
  }
}
