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
// @JUDGE_ID:  33089  477  Java  "Points in Figures: Rectangles and Circles"
package volume_iv;

import java.util.StringTokenizer;
import java.util.Vector;

class P477_33089 {
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
        return (buffer.toString().trim());
    }

    public static void main(String[] args) {
        (new P477_33089()).begin();
    }

    private void begin() {
        String input = P477_33089.readLn();
        Vector<Figure> v = new Vector<Figure>();
        StringTokenizer st;
        while (!input.equals("*")) {
            st = new StringTokenizer(input);
            String type = st.nextToken();
            if (type.equals("r")) {
                double ulx = new Double(st.nextToken()).doubleValue();
                double uly = new Double(st.nextToken()).doubleValue();
                double lrx = new Double(st.nextToken()).doubleValue();
                double lry = new Double(st.nextToken()).doubleValue();
                Rectangle r = new Rectangle(ulx, uly, lrx, lry);
                v.addElement(r);
            } else {
                double cx = new Double(st.nextToken()).doubleValue();
                double cy = new Double(st.nextToken()).doubleValue();
                double r = new Double(st.nextToken()).doubleValue();
                Circle c = new Circle(cx, cy, r);
                v.addElement(c);
            }
            input = P477_33089.readLn();
        }
        input = P477_33089.readLn();
        int tc = 0;
        while (!input.equals("9999.9 9999.9")) {
            st = new StringTokenizer(input);
            tc++;
            boolean contains = false;
            double x = new Double(st.nextToken()).doubleValue();
            double y = new Double(st.nextToken()).doubleValue();
            for (int i = 0; i < v.size(); i++) {
                Figure f = v.elementAt(i);
                if (f.contains(x, y)) {
                    System.out.println("Point " + tc
                            + " is contained in figure " + (i + 1));
                    contains = true;
                }
            }
            if (!contains) {
                System.out.println("Point " + tc
                        + " is not contained in any figure");

            }
            input = P477_33089.readLn();
        }
    }
}

interface Figure {
    public boolean contains(double x, double y);
}

class Rectangle implements Figure {
    private final double ulx;
    private final double uly;
    private final double lrx;
    private final double lry;

    public Rectangle(double ulx, double uly, double lrx, double lry) {
        this.ulx = ulx;
        this.uly = uly;
        this.lrx = lrx;
        this.lry = lry;
    }

    @Override
    public boolean contains(double x, double y) {
        return (x > this.ulx && x < this.lrx) && (y > this.lry && y < this.uly);
    }

}

class Circle implements Figure {
    private final double cx;
    private final double cy;
    private final double r;

    public Circle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public boolean contains(double x, double y) {
        return Math.sqrt((x - this.cx) * (x - this.cx) + (y - this.cy)
                * (y - this.cy)) < this.r;
    }

}
