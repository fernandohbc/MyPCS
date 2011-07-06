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
package volume_ix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #941 - Permutations
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P941_Permutations {
    static long factorial[];

    static {
        factorial = new long[21];
        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = Integer.parseInt(scn.nextLine().trim());
        for (int i = 0; i < tc; i++) {
            char[] word = scn.nextLine().trim().toCharArray();
            long n = Long.parseLong(scn.nextLine().trim());
            Arrays.sort(word);
            System.out.println(perm(word, n));
        }
    }

    private static String perm(char[] word, long n) {
        if (word.length == 1) {
            return new String(word);
        }
        int t = word.length;
        int i = (int) (n / factorial[t - 1]);
        long m = n % factorial[t - 1];

        return word[i] + perm(remove(word, i), m);
    }

    private static char[] remove(char[] word, int i) {
        char[] newWord = new char[word.length - 1];

        for (int k = 0; k < i; k++) {
            newWord[k] = word[k];
        }

        for (int k = i + 1; k < word.length; k++) {
            newWord[k - 1] = word[k];
        }

        return newWord;
    }
}
