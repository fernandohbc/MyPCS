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
package volume_iii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * UVa Online Judge Problem #394: Mapmaker
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / twitter: fernando_hbc)
 */
public class P394_Mapmaker {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        StringTokenizer st = tokenizeNextLine();

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Map<String, Arrayy> arrayMap = new HashMap<String, Arrayy>();

        for (int i = 0; i < n; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int bounds[] = new int[2 * d];
            for (int bd = 0; bd < 2 * d; bd++) {
                bounds[bd] = Integer.parseInt(st.nextToken());
            }

            Arrayy array = new Arrayy(b, size, d, bounds);
            arrayMap.put(arrayName, array);
        }

        for (int i = 0; i < r; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            ArrayList<Integer> arguments = new ArrayList<Integer>();
            while (st.hasMoreTokens()) {
                arguments.add(Integer.parseInt(st.nextToken()));
            }

            Arrayy array = arrayMap.get(arrayName);
            if (array != null) {
                int pos = array.calcPos(arguments);
                System.out.println(arrayName + arguments + " = " + pos);
            }
        }
    }

    private static StringTokenizer tokenizeNextLine() {
        return new StringTokenizer(scn.nextLine());
    }
}

class Arrayy {

    private final int c[];

    public Arrayy(int b, int size, int d, int[] bounds) {
        this.c = new int[d + 1];
        this.c[d] = size;

        for (int i = d - 1; i > 0; i--) {
            this.c[i] = this.c[i + 1] * (bounds[2 * i + 1] - bounds[2 * i] + 1);
        }

        this.c[0] = b;
        for (int i = 1; i <= d; i++) {
            this.c[0] -= this.c[i] * bounds[2 * i - 2];
        }
    }

    public int calcPos(ArrayList<Integer> arguments) {
        int pos = this.c[0];
        for (int i = 0; i < arguments.size(); i++) {
            pos += this.c[i + 1] * arguments.get(i);
        }
        return pos;
    }

}