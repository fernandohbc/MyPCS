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
package volume_cii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #10281 - Average Speed
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10281_AverageSpeed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double lastSpeedChange = 0;
        double currentSpeed = 0;
        double lastMark = 0;

        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            double time = toTime(line);
            if (isQuery(line)) {
                double mark = lastMark + (time - lastSpeedChange)
                        * currentSpeed;
                System.out.printf("%s %.2f km\n", line, mark);
            } else {
                lastMark = lastMark + (time - lastSpeedChange) * currentSpeed;
                currentSpeed = Double.parseDouble(line.substring(9));
                lastSpeedChange = time;
            }
        }
    }

    private static double toTime(String line) {
        return Double.parseDouble(line.substring(0, 2))
                + Double.parseDouble(line.substring(3, 5)) / 60.0
                + Double.parseDouble(line.substring(6, 8)) / (60.0 * 60.0);
    }

    private static boolean isQuery(String line) {
        return line.length() == 8;
    }
}
