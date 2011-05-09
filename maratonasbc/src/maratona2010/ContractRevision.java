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
package maratona2010;

import java.util.Scanner;

public class ContractRevision {
    public static void main(String[] args) {
        new ContractRevision().run();
    }

    private void run() {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        while (!line.trim().equals("0 0")) {
            String input[] = line.trim().split(" ");
            char key = input[0].charAt(0);
            String value = input[1];
            StringBuilder rev = new StringBuilder();
            boolean isNonZero = false;
            for (char c : value.toCharArray()) {
                if (c != key && (c != '0' || isNonZero)) {
                    rev.append(c);
                }
            }
            String revStr = rev.toString();
            if (revStr.equals("")) {
                System.out.println(0);
            } else {
                System.out.println(revStr);
            }
            line = scn.nextLine();
        }
    }
}
