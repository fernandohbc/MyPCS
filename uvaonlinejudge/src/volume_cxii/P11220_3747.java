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
//11220 - Decoding the message
package volume_cxii;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P11220_3747 {
    public static void main(String[] args) {
        (new P11220_3747()).begin();
    }

    private void begin() {
        Scanner scn = new Scanner(System.in);
        int t = Integer.valueOf(scn.nextLine().trim());
        // Desconsidera a primeira linha
        scn.nextLine();

        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Case #" + tc + ":");
            String linha = scn.nextLine();
            while (!linha.trim().equals("")) {
                StringTokenizer tok = new StringTokenizer(linha);
                int pos = 0;
                StringBuilder decod = new StringBuilder();
                while (tok.hasMoreTokens()) {
                    String palavra = tok.nextToken();
                    if (palavra.length() >= pos + 1) {
                        decod.append(palavra.charAt(pos++));
                    }
                }
                System.out.println(decod);
                linha = scn.nextLine();
            }
            if (tc != t) {
                System.out.println();
            }
        }
    }
}
