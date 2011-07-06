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
package volume_ci;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * UVa Online Judge Problem #10141 - Request for Proposal
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10141_RequestForProposal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        StringTokenizer lineTokenizer = new StringTokenizer(scn.nextLine()
                .trim());

        int n = Integer.parseInt(lineTokenizer.nextToken());
        int p = Integer.parseInt(lineTokenizer.nextToken());
        int tc = 1;

        while (n > 0 || p > 0) {
            for (int i = 0; i < n; i++) {
                // Ignores the requirements names
                scn.nextLine();
            }

            int bestCompliance = -1;
            double bestPrice = Double.MAX_VALUE;
            String bestSupplier = null;

            for (int i = 0; i < p; i++) {
                String supplier = scn.nextLine();
                lineTokenizer = new StringTokenizer(scn.nextLine().trim());
                double price = Double.parseDouble(lineTokenizer.nextToken());
                int compliance = Integer.parseInt(lineTokenizer.nextToken());

                if (compliance > bestCompliance
                        || (compliance == bestCompliance && price < bestPrice)) {
                    bestCompliance = compliance;
                    bestPrice = price;
                    bestSupplier = supplier;
                }

                for (int j = 0; j < compliance; j++) {
                    // Ignores the requirements met
                    scn.nextLine();
                }
            }
            if (tc > 1) {
                System.out.println();
            }
            System.out.println("RFP #" + tc++);
            System.out.println(bestSupplier);

            lineTokenizer = new StringTokenizer(scn.nextLine().trim());

            n = Integer.parseInt(lineTokenizer.nextToken());
            p = Integer.parseInt(lineTokenizer.nextToken());
        }
    }
}
