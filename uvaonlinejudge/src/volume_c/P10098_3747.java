/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified
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
package volume_c;

import java.util.Scanner;
import java.util.Arrays;

public class P10098_3747 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        (new P10098_3747()).begin();
    }

    private void begin() {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < n; i++) {
            String str = scn.nextLine();
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            str = new String(chArr);
            permutate("", str);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void permutate(String prefix, String suffix) {
        if (suffix.length() == 0) {
            sb.append(prefix);
            sb.append("\n");
        } else {
            char prev = '#';
            for (int i = 0; i < suffix.length(); i++) {
                char c = suffix.charAt(i);
                if (c != prev) {
                    permutate(prefix + c, suffix.substring(0, i)
                            + suffix.substring(i + 1, suffix.length()));
                    prev = c;
                }
            }
        }
    }
}
