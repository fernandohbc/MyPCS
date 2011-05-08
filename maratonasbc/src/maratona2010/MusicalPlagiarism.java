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
package maratona2010;

import java.util.Scanner;

public class MusicalPlagiarism {
    public static void main(String[] args) {
        new MusicalPlagiarism().begin();
    }

    private void begin() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.trim().equals("0 0")) {
            line = sc.nextLine();
            String original = toCanonicalString(line);
            line = sc.nextLine();
            String plagio = toCanonicalString(line);
            
            System.out.println(original.matches(".*"+plagio+".*") ? "S" : "N");

            line = sc.nextLine();
        }
    }

    private String toCanonicalString(String line) {
        StringBuilder result = new StringBuilder();

        String notes[] = line.split(" ");
        int currNote = toInt(notes[0]);
        for (int i = 1; i < notes.length; i++) {
            int prevNote = currNote;
            currNote = toInt(notes[i]);
            int delta = (12 + currNote - prevNote) % 12;
            result.append((char)(delta+'a'));
        }

        return result.toString();
    }

    private int toInt(String string) {
        int result = 12;
        switch (string.charAt(0)) {
        case 'A':
            result += 0;
            break;
        case 'B':
            result += 2;
            break;
        case 'C':
            result += 3;
            break;
        case 'D':
            result += 5;
            break;
        case 'E':
            result += 7;
            break;
        case 'F':
            result += 8;
            break;
        case 'G':
            result += 10;
            break;
        }

        if (string.length() == 2) {
            char mod = string.charAt(1);
            if (mod == '#') {
                result++;
            } else {
                result--;
            }
        }

        return result % 12;
    }
}
