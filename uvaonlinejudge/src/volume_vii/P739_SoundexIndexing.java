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
package volume_vii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #739: Soundex Indexing
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / twitter: fernando_hbc)
 */
public class P739_SoundexIndexing {
    private static int[] charCodes = { 0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5,
            5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2 };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("%-9s%-25s%-11s\n", "", "NAME", "SOUNDEX CODE");
        while (scn.hasNextLine()) {
            String word = scn.nextLine().trim();
            String soundex = generateSoundex(word);
            System.out.printf("%-9s%-25s%-4s\n", "", word, soundex);
        }
        System.out.printf("%-19s%-13s\n", "", "END OF OUTPUT");
    }

    private static String generateSoundex(String word) {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        char wordChr[] = word.toCharArray();
        int lastCode = charCodes[wordChr[0] - 'A'];
        sb.append(word.charAt(0));
        while (sb.length() < 4 && i < wordChr.length) {
            int code = charCodes[wordChr[i++] - 'A'];
            if (code != 0 && code != lastCode) {
                sb.append(code);
            }
            lastCode = code;
        }

        while (sb.length() < 4) {
            sb.append(0);
        }
        return sb.toString();
    }
}
