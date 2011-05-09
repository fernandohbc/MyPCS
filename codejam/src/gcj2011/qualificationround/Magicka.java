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
package gcj2011.qualificationround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Solution to Google Code Jam 2011 Qualification Round's Problem: Magicka
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 * 
 */
public class Magicka {

    private static HashMap<String, Character> combinations;
    private static HashMap<Character, List<Character>> eliminations;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.valueOf(scn.nextLine());

        for (int tc = 1; tc <= t; tc++) {
            String line = scn.nextLine();
            StringTokenizer st = new StringTokenizer(line);

            // Combinations
            combinations = new HashMap<String, Character>();
            int c = Integer.valueOf(st.nextToken());
            for (int comb = 0; comb < c; comb++) {
                String combination = st.nextToken();
                addCombination(combination);
            }

            // Eliminations
            eliminations = new HashMap<Character, List<Character>>();
            int d = Integer.valueOf(st.nextToken());
            for (int elim = 0; elim < d; elim++) {
                String elimination = st.nextToken();
                addElimination(elimination);
            }

            // Process invokations
            int n = Integer.valueOf(st.nextToken());
            char invokation[] = st.nextToken().toCharArray();
            Deque<Character> result = new LinkedList<Character>();
            char lastChar = '-';
            int histogram[] = new int[26];
            for (int i = 0; i < n; i++) {
                char element = invokation[i];

                // Tests for combination
                Character combResult = combinations
                        .get("" + lastChar + element);
                if (combResult != null) {
                    histogram[idx(lastChar)]--;
                    result.removeLast();
                    result.addLast(combResult);
                    lastChar = combResult;
                    histogram[idx(combResult)]++;
                } else {
                    // Tests for elimination
                    List<Character> elimList = eliminations.get(element);
                    boolean hasCleared = false;
                    if (elimList != null) {
                        for (Character elim : elimList) {
                            if (histogram[idx(elim)] != 0) {
                                result.clear();
                                histogram = new int[26];
                                lastChar = '-';
                                hasCleared = true;
                                break;
                            }
                        }
                    }

                    if (!hasCleared) {
                        result.addLast(element);
                        lastChar = element;
                        histogram[idx(element)]++;
                    }
                }
            }
            Character resultingArray[] = new Character[result.size()];
            resultingArray = result.toArray(resultingArray);
            System.out.println("Case #" + tc + ": "
                    + Arrays.toString(resultingArray));
        }
    }

    private static int idx(char element) {
        return element - 'A';
    }

    private static void addElimination(String elimination) {
        char e0 = elimination.charAt(0);
        char e1 = elimination.charAt(1);

        addElimination(e0, e1);
        addElimination(e1, e0);
    }

    private static void addElimination(char k, char v) {
        List<Character> elimList = null;
        if (eliminations.containsKey(k)) {
            elimList = eliminations.get(k);
        } else {
            elimList = new ArrayList<Character>();
            eliminations.put(k, elimList);
        }
        elimList.add(v);
    }

    private static void addCombination(String combination) {
        char combArr[] = combination.toCharArray();
        char e1 = combArr[0];
        char e2 = combArr[1];
        char r = combArr[2];
        combinations.put("" + e1 + e2, r);
        if (e1 != e2) {
            combinations.put("" + e2 + e1, r);
        }
    }
}
