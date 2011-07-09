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
package volume_xxi;

import java.util.Scanner;

/**
 * ICPC Archive Problem #2189 - Mobile Casanova
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P2189_MobileCasanova {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int qty = Integer.parseInt(scn.nextLine().trim());
        int tc = 1;
        while (qty != 0) {
            if (tc > 1) {
                System.out.println();
            }
            String firstOfSequence = scn.nextLine().trim();
            String lastOfSequence = firstOfSequence;
            int lastNumber = Integer.parseInt(lastOfSequence);
            System.out.println("Case " + tc++);
            for (int i = 1; i < qty; i++) {
                String phone = scn.nextLine().trim();
                int phoneNumber = Integer.parseInt(phone);
                int diff = phoneNumber - lastNumber;
                if (diff == 1) {
                    lastOfSequence = phone;
                    lastNumber = phoneNumber;
                } else {
                    print(firstOfSequence, lastOfSequence);
                    firstOfSequence = phone;
                    lastOfSequence = phone;
                    lastNumber = Integer.parseInt(lastOfSequence);
                }

            }
            print(firstOfSequence, lastOfSequence);
            qty = Integer.parseInt(scn.nextLine().trim());
        }
    }

    private static void print(String firstOfSequence, String lastOfSequence) {
        if (firstOfSequence.equals(lastOfSequence)) {
            System.out.println(firstOfSequence);
        } else {
            int beginIndex = findBeginIndex(firstOfSequence, lastOfSequence);
            System.out.println(firstOfSequence + "-"
                    + lastOfSequence.substring(beginIndex));
        }
    }

    private static int findBeginIndex(String firstOfSequence,
            String lastOfSequence) {
        for (int i = 0; i < lastOfSequence.length(); i++) {
            if (firstOfSequence.charAt(i) != lastOfSequence.charAt(i)) {
                return i;
            }
        }
        return 0;
    }
}
