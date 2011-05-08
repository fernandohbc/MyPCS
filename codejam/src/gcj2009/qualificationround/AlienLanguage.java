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
package gcj2009.qualificationround;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlienLanguage {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String firstLine = scn.nextLine();
        String[] ldn = firstLine.split(" ");
        int l = Integer.parseInt(ldn[0]);
        int d = Integer.parseInt(ldn[1]);
        int n = Integer.parseInt(ldn[2]);

        List<String> language = new LinkedList<String>();
        for (int i = 0; i < d; i++) {
            String word = scn.nextLine();
            language.add(word);
        }

        for (int i = 1; i <= n; i++) {
            // Cada iteração é um teste...
            List<String> langClone = new LinkedList<String>(language);
            String readWord = scn.nextLine();

            for (int w = 0; w < l && langClone.size() > 0; w++) {
                String possible = "";
                if (readWord.charAt(0) == '(') {
                    int closeIdx = readWord.indexOf(')');
                    possible = readWord.substring(0, closeIdx);
                    readWord = readWord.substring(closeIdx + 1);
                } else {
                    possible = possible + readWord.charAt(0);
                    readWord = readWord.substring(1);
                }

                // Faz a poda
                for (int c = 0; c < langClone.size();) {
                    String word = langClone.get(c);
                    if (possible.indexOf(word.charAt(w)) == -1) {
                        langClone.remove(c);
                    } else {
                        c++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + langClone.size());
        }
    }
}
