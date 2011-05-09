/*******************************************************************************
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
 ******************************************************************************/
package gcj2010.qualificationround;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FairWarning {
    private static final BigInteger UM = new BigInteger("1");

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        for (int i = 1; i <= t; i++) {
            BigInteger steps = new BigInteger("0");

            String linha = scn.nextLine();
            StringTokenizer st = new StringTokenizer(linha);
            int c = Integer.parseInt(st.nextToken());
            BigInteger[] eventsArr = new BigInteger[c];
            for (int e = 0; e < c; e++) {
                BigInteger bigInt = new BigInteger(st.nextToken());
                eventsArr[e] = bigInt;
            }

            Arrays.sort(eventsArr);

            BigInteger gcdDiff = gcdDifference(eventsArr);
            BigInteger gcd = gcd(eventsArr);
            while (!gcdDiff.equals(gcd)) {
                BigInteger add = gcdDiff.subtract(eventsArr[0].mod(gcdDiff));
                steps = steps.add(add);
                for (int e = 0; e < c; e++) {
                    eventsArr[e] = eventsArr[e].add(add);
                }
                gcdDiff = gcdDifference(eventsArr);
                gcd = gcd(eventsArr);
            }
            System.out.println("Case #" + i + ": " + steps);
        }
    }

    private static BigInteger gcdDifference(BigInteger[] events) {
        BigInteger gcdDiff = events[1].subtract(events[0]);
        for (int e = 2; e < events.length; e++) {
            gcdDiff = gcdDiff.gcd(events[e].subtract(events[e - 1]));
        }
        return gcdDiff;
    }

    private static BigInteger gcd(BigInteger[] events) {
        BigInteger result = events[0].gcd(events[1]);
        for (int i = 2; i < events.length; i++) {
            result = result.gcd(events[i]);
            if (result.equals(UM)) {
                return result;
            }
        }
        return result;
    }

}
