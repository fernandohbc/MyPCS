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

public class OpticalReader {
    public static void main(String[] args) {
        new OpticalReader().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            for ( int i = 0; i < n; i++ ) {
                char ans = ' ';
                for ( int m = 0; m < 5; m++) {
                    int rd = sc.nextInt();
                    if ( rd <= 127 ) {
                        if ( ans == ' ') {
                            ans = (char)('A' + m);
                        } else {
                            ans = '*';
                        }
                    }
                }
                if ( ans == ' ') {
                    ans = '*';
                }
                System.out.println(ans);
            }
            n = sc.nextInt();
        }
    }
}
