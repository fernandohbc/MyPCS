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
// @JUDGE_ID:  33089  568  Java  "Just the Facts"
package volume_v;

class P568_33089 {
    // Rotina de Leitura
    static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char) car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) {
                System.in.skip(newLine.length() - 1);
            }
        } catch (java.io.IOException e) {
            return (null);
        }
        if ((car < 0) && (buffer.length() == 0)) {
            return (null);
        }
        return (buffer.toString());
    }

    // Entrada do programa
    public static void main(String args[]) // entry point from OS
    {
        P568_33089 myWork = new P568_33089(); // create a dinamic instance
        myWork.Begin();
    }

    // Metodo principal
    void Begin() {
        String input = P568_33089.readLn();
        while (input != null) {
            long n = Integer.parseInt(input);
            long just = this.justTheFacts(n);
            this.output(n, just);
            input = P568_33089.readLn();
        }
    }

    private void output(long n, long just) {
        String nOut = String.valueOf(n);
        while (nOut.length() < 5) {
            nOut = " " + nOut;
        }
        nOut = nOut + " -> ";
        nOut = nOut + just;
        System.out.println(nOut);
    }

    @SuppressWarnings("unused")
    private void precalc() {
        for (int i = 0; i <= 10000; i++) {
            System.out.println("just[" + i + "] = " + this.justTheFacts(i));
        }

    }

    private long justTheFacts(long n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
            while (result % 10 == 0) {
                result = result / 10;
            }
            result = result % 1000000;
            // System.out.println(result);
        }
        return result % 10;
    }
}
