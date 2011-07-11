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
package volume_cxii;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #11223 - O: dah dah dah!
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11223_O_DahDahDah {

    private static Map<String, Character> morseMap = initMorseMap();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = Integer.parseInt(scn.nextLine().trim());
        for (int i = 1; i <= tc; i++) {
            if (i > 1) {
                System.out.println();
            }
            String words[] = scn.nextLine().trim().split("  ");
            StringBuilder msg = new StringBuilder("Message #" + i + "\n");
            for (String word : words) {
                String letters[] = word.split(" ");
                for (String letter : letters) {
                    if (letter != null && !letter.trim().equals("")) {
                        msg.append(morseMap.get(letter));
                    }
                }
                msg.append(" ");
            }
            System.out.println(msg.toString().trim());
        }
    }

    private static Map<String, Character> initMorseMap() {
        Map<String, Character> theMap = new HashMap<String, Character>();
        theMap.put(".-", 'A');
        theMap.put("-...", 'B');
        theMap.put("-.-.", 'C');
        theMap.put("-..", 'D');
        theMap.put(".", 'E');
        theMap.put("..-.", 'F');
        theMap.put("--.", 'G');
        theMap.put("....", 'H');
        theMap.put("..", 'I');
        theMap.put(".---", 'J');
        theMap.put("-.-", 'K');
        theMap.put(".-..", 'L');
        theMap.put("--", 'M');
        theMap.put("-.", 'N');
        theMap.put("---", 'O');
        theMap.put(".--.", 'P');
        theMap.put("--.-", 'Q');
        theMap.put(".-.", 'R');
        theMap.put("...", 'S');
        theMap.put("-", 'T');
        theMap.put("..-", 'U');
        theMap.put("...-", 'V');
        theMap.put(".--", 'W');
        theMap.put("-..-", 'X');
        theMap.put("-.--", 'Y');
        theMap.put("--..", 'Z');
        theMap.put("-----", '0');
        theMap.put(".----", '1');
        theMap.put("..---", '2');
        theMap.put("...--", '3');
        theMap.put("....-", '4');
        theMap.put(".....", '5');
        theMap.put("-....", '6');
        theMap.put("--...", '7');
        theMap.put("---..", '8');
        theMap.put("----.", '9');
        theMap.put(".-.-.-", '.');
        theMap.put("--..--", ',');
        theMap.put("..--..", '?');
        theMap.put(".----.", '\'');
        theMap.put("-.-.--", '!');
        theMap.put("-..-.", '/');
        theMap.put("-.--.", '(');
        theMap.put("-.--.-", ')');
        theMap.put(".-...", '&');
        theMap.put("---...", ':');
        theMap.put("-.-.-.", ';');
        theMap.put("-...-", '=');
        theMap.put(".-.-.", '+');
        theMap.put("-....-", '-');
        theMap.put("..--.-", '_');
        theMap.put(".-..-.", '"');
        theMap.put(".--.-.", '@');
        return theMap;
    }
}
