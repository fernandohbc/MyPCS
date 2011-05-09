/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
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
// @JUDGE_ID:  33089  694  Java  "The Collatz Sequence"
package volume_vi;

import java.util.StringTokenizer;

class P694_33089 {

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
                       if (car == newLine.charAt(0))
                               System.in.skip(newLine.length() - 1);
               } catch (java.io.IOException e) {
                       return (null);
               }
               if ((car < 0) && (buffer.length() == 0))
                       return (null);
               return (buffer.toString().trim());
       }

       public static void main(String[] args) {
               String input = readLn();
               StringTokenizer st = new StringTokenizer( input );
               long a = Long.parseLong( st.nextToken() );
               long l = Long.parseLong( st.nextToken() );
               int tc = 0;
               while (a >= 0 || l >= 0 ) {
                       tc++;
                       long n = a;
                       long count = 1;
                       while ( n != 1 && n <= l) {
                               if ( n%2 == 0 ) {
                                       n = n / 2;
                                       count++;
                               } else {
                                       n = 3 * n + 1;
                                       if ( n <= l ) {
                                               count++;
                                       }
                               }
                       }
                       System.out.println("Case "+tc+": A = "+a+", limit = "+l+", number of terms = "+count);
                       input = readLn();
                       st = new StringTokenizer( input );
                       a = Long.parseLong( st.nextToken() );
                       l = Long.parseLong( st.nextToken() );
               }
       }
}

