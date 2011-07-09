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
package volume_cv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * UVa Online Judge Problem #10528 - Major Scales
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10528_MajorScales {

    static List<List<Integer>> validScales = initAllScales();
    static List<String> noteNames = initNoteNames();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine().trim();
        while (!"END".equals(line)) {
            List<List<Integer>> candidateScales = new ArrayList<List<Integer>>(
                    validScales);
            StringTokenizer notesTokenizer = new StringTokenizer(line);
            while (notesTokenizer.hasMoreTokens() && !candidateScales.isEmpty()) {
                String noteStr = notesTokenizer.nextToken();
                int note = noteNames.indexOf(noteStr);
                for (int i = 0; i < candidateScales.size();) {
                    if (candidateScales.get(i).contains(note)) {
                        i++;
                    } else {
                        candidateScales.remove(i);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < candidateScales.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(noteNames.get(candidateScales.get(i).get(0)));
            }
            System.out.println(sb.toString());
            line = scn.nextLine().trim();
        }
    }

    private static List<String> initNoteNames() {
        List<String> noteNames = new ArrayList<String>();
        noteNames.add("C");
        noteNames.add("C#");
        noteNames.add("D");
        noteNames.add("D#");
        noteNames.add("E");
        noteNames.add("F");
        noteNames.add("F#");
        noteNames.add("G");
        noteNames.add("G#");
        noteNames.add("A");
        noteNames.add("A#");
        noteNames.add("B");
        return noteNames;
    }

    private static List<List<Integer>> initAllScales() {
        List<List<Integer>> allScales = new LinkedList<List<Integer>>();
        for (int i = 0; i < 12; i++) {
            allScales.add(initScale(i));
        }
        return allScales;
    }

    private static List<Integer> initScale(int i) {
        List<Integer> scale = new LinkedList<Integer>();
        int note = i;
        scale.add(note % 12);
        note += 2;
        scale.add(note % 12);
        note += 2;
        scale.add(note % 12);
        note += 1;
        scale.add(note % 12);
        note += 2;
        scale.add(note % 12);
        note += 2;
        scale.add(note % 12);
        note += 2;
        scale.add(note % 12);
        note += 1;
        scale.add(note % 12);
        return scale;
    }
}