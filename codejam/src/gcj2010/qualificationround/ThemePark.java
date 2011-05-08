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
package gcj2010.qualificationround;

import java.util.Scanner;

public class ThemePark {

    public class Element {
        long i = 0;
        Element next = null;

        public Element(long i) {
            this.i = i;
        }
    }

    public class CircularQueue {
        private Element last = null;
        private Element first = null;

        public void add(long i) {
            Element e = new Element(i);
            if (this.last == null) {
                this.first = e;
                this.last = e;
                e.next = e;
            } else {
                this.last.next = e;
                e.next = this.first;
                this.last = e;
            }
        }

        public long nextQuorum(long k) {
            long result = 0;
            Element current = this.first;
            while (current.i <= (k - result)) {
                result += current.i;
                current = current.next;
            }
            this.first = current;
            return result;
        }
    }

    public static void main(String[] args) {
        new ThemePark().begin();
    }

    private void begin() {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 1; i <= t; i++) {
            long r = scn.nextInt();
            long k = scn.nextInt();
            long n = scn.nextInt();

            // Reads the groups of people
            CircularQueue queue = new CircularQueue();
            long sum = 0;
            for (int g = 0; g < n; g++) {
                long size = scn.nextInt();
                queue.add(size);
                sum += size;
            }
            long total = 0;
            if (sum <= k) {
                total = r * sum;
            } else {
                for (long roller = 0; roller < r; roller++) {
                    total += queue.nextQuorum(k);
                }
            }
            System.out.println("Case #" + i + ": " + total);
        }
    }
}
