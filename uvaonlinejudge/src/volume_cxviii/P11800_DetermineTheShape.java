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
    private static final double EPSILON = 1e-15;
    private static long parsingPoints;
    private static long mountingOutput;
    private static long classifying;
    private static long printing;
    private static long readingPoints;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scn = new Scanner(System.in);
        long ini = System.currentTimeMillis();
        long end;
        int q = scn.nextInt();
        for (int i = 1; i <= q; i++) {
            List<Point2D> points = new ArrayList<Point2D>();
            List<Line2D> segments = new ArrayList<Line2D>();
            for (int p = 0; p < 4; p++) {
                Point2D point = new Point2D.Float(scn.nextInt(), scn.nextInt());

                end = System.currentTimeMillis();
                readingPoints += (end - ini);
                ini = end;

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

            end = System.currentTimeMillis();
            parsingPoints += (end - ini);
            ini = end;

            // print(segments);
            sb.append("Case ");
            sb.append(i);
            sb.append(": ");

            end = System.currentTimeMillis();
            mountingOutput += (end - ini);
            ini = end;

            String clazz = classify(segments);

            end = System.currentTimeMillis();
            classifying += (end - ini);
            ini = end;

            sb.append(clazz);
            sb.append('\n');

            end = System.currentTimeMillis();
            mountingOutput += (end - ini);
            ini = end;
        }
        System.out.println(sb.toString());
        end = System.currentTimeMillis();
        printing += (end - ini);

        System.out.println("Reading: " + readingPoints);
        System.out.println("Parsing: " + parsingPoints);
        System.out.println("Classifying: " + classifying);
        System.out.println("Mounting: " + mountingOutput);
        System.out.println("Printing: " + printing);

    }

    private static String classify(List<Line2D> segments) {
        segments = arrangeSegments(segments);
        // print(segments);
        double sizes[] = getSizes(segments);
        // System.out.println(Arrays.toString(sizes));
        double angles[] = getAngles(segments, sizes);
        // System.out.println(Arrays.toString(angles));

        if (allSame(sizes)) {
            if (allSame(angles)) {
                return "Square";
            } else {
                return "Rhombus";
            }
        }

        if (allSame(angles)) {
            return "Rectangle";
        }

        if (sizes[0] == sizes[2] && sizes[1] == sizes[3]) {
            return "Parallelogram";
        }

        if (Math.abs(Math.sin(getAngle(segments.get(0), segments.get(2),
                sizes[0], sizes[2]))) < EPSILON
                || Math.abs(Math.sin(getAngle(segments.get(1), segments.get(3),
                        sizes[1], sizes[3]))) < EPSILON) {
            return "Trapezium";
        }

        return "Ordinary Quadrilateral";

    }

    private static double getAngle(Line2D l1, Line2D l2, double d1, double d2) {
        double pi = (l1.getX2() - l1.getX1()) * (l2.getX2() - l2.getX1())
                + (l1.getY2() - l1.getY1()) * (l2.getY2() - l2.getY1());
        double angle = Math.acos(pi / (d1 * d2));
        return angle;
    }

    private static boolean allSame(double[] d) {
        return d[0] == d[1] && d[0] == d[2] && d[0] == d[3];
    }

    private static double[] getAngles(List<Line2D> segments, double[] sizes) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = getAngle(segments.get(i), segments.get((i + 1) % 4),
                    sizes[i], sizes[(i + 1) % 4]);
        }
        return result;
    }

    private static double[] getSizes(List<Line2D> segments) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = segments.get(i).getP1()
                    .distance(segments.get(i).getP2());
        }
        return result;
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
