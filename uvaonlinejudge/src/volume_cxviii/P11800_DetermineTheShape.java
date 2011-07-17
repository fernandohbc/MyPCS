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
package volume_cxviii;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #11800 - Determine the Shape
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P11800_DetermineTheShape {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int i = 1; i <= q; i++) {
            List<Point2D> points = new ArrayList<Point2D>();
            List<Line2D> segments = new ArrayList<Line2D>();
            for (int p = 0; p < 4; p++) {
                Point2D point = new Point2D.Float(scn.nextInt(), scn.nextInt());
                point_loop: for (Point2D inTheList : points) {
                    Line2D segment = new Line2D.Float(point, inTheList);
                    for (int s = 0; s < segments.size();) {
                        Line2D currentSegment = segments.get(s);
                        if (areCrossing(segment, currentSegment)) {
                            segments.remove(s);
                            continue point_loop;
                        } else {
                            s++;
                        }
                    }
                    segments.add(segment);
                }
                points.add(point);
            }

            print(segments);
            System.out.println("Case " + i + ": " + classify(segments));
        }
    }

    private static void print(List<Line2D> segments) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        sb.append("(" + segments.get(0).getP1() + ", "
                + segments.get(0).getP2() + "); ");
        sb.append("(" + segments.get(1).getP1() + ", "
                + segments.get(1).getP2() + "); ");
        sb.append("(" + segments.get(2).getP1() + ", "
                + segments.get(2).getP2() + "); ");
        sb.append("(" + segments.get(3).getP1() + ", "
                + segments.get(3).getP2() + ")");

        sb.append(']');
        System.out.println(sb.toString());
    }

    private static String classify(List<Line2D> segments) {
        segments = arrangeSegments(segments);
        print(segments);
        return null;
    }

    private static List<Line2D> arrangeSegments(List<Line2D> segments) {
        ArrayList<Line2D> arranged = new ArrayList<Line2D>();
        Line2D segment = segments.remove(0);
        arranged.add(segment);
        for (int i = 0; i < 3; i++) {
            Point2D begin = segment.getP1();
            Point2D end = segment.getP2();
            for (int s = 0; s < segments.size(); s++) {
                Line2D next = segments.get(s);
                if (next.getP1().equals(end) || next.getP2().equals(end)
                        || next.getP1().equals(begin)
                        || next.getP2().equals(begin)) {
                    segment = next;
                    arranged.add(next);
                    segments.remove(s);
                    break;
                }
            }
        }
        return arranged;
    }

    private static boolean areCrossing(Line2D s1, Line2D s2) {
        return s1.intersectsLine(s2) && !s1.getP1().equals(s2.getP1())
                && !s1.getP1().equals(s2.getP2())
                && !s1.getP2().equals(s2.getP1())
                && !s1.getP2().equals(s2.getP2());
    }
}
