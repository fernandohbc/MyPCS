/*******************************************************************************
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
 ******************************************************************************/
package africa2010.qualificationround;

import java.util.Scanner;

public class T9Spelling {

    public static void main(String[] args) {
        (new T9Spelling()).begin();
    }

    private void begin() {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        String[] seq = { "2", "22", "222", "3", "33", "333", "4", "44", "444",
                "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777",
                "8", "88", "888", "9", "99", "999", "9999" };
        for (int i = 1; i <= n; i++) {
            String str = scn.nextLine();
            StringBuilder sb = new StringBuilder("Case #");
            sb.append(i);
            sb.append(": ");
            String prev = "n";
            String curr = null;
            int inta = 'a';
            for (char c : str.toCharArray()) {
                if (c == ' ') {
                    curr = "0";
                } else {
                    curr = seq[c - inta];
                }
                if (curr.charAt(0) == prev.charAt(0)) {
                    sb.append(' ');
                }
                sb.append(curr);
                prev = curr;
            }
            System.out.println(sb);
        }
    }
}
