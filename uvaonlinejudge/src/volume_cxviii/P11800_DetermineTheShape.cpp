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
 *
 *
 *
 * UVa Online Judge Problem #11800 - Determine the Shape
 * 
 * Author: Fernando Cardoso (fernandohbc@gmail.com)
 */

#include <iostream>

#define EPSILON = 1e-15;

using namespace std;

struct Point {
  int x; int y;
}

struct Segment {
  Point p1; Point p2;
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

void getSizes(Segment [] segments, double [] sizes) {
  for (int i = 0; i < 4; i++) {
    sizes[i] = (segments[i].p1.x-segments[i].p2.x)*(segments[i].p1.x-segments[i].p2.x);
    sizes[i] += (segments[i].p1.y-segments[i].p2.y)*(segments[i].p1.y-segments[i].p2.y);
    sizes[i] = sqrt(sizes[i]);
  }
}

void arrangeSegments(Segment [] segments) {

}

    private static boolean areCrossing(Line2D s1, Line2D s2) {
        return s1.intersectsLine(s2) && !s1.getP1().equals(s2.getP1())
                && !s1.getP1().equals(s2.getP2())
                && !s1.getP2().equals(s2.getP1())
                && !s1.getP2().equals(s2.getP2());
    }

void classify(Segment [] segments) {
  arrangeSegments(segments);
  
  double sizes[4];
  getSizes(segments, sizes);

  double angles[] = getAngles(segments, sizes);

  if (allSame(sizes)) {
    if (allSame(angles)) {
      cout << "Square";
    } else {
      cout << "Rhombus";
    }
  }

 if (allSame(angles)) {
   cout << "Rectangle";
 }

 if (sizes[0] == sizes[2] && sizes[1] == sizes[3]) {
   cout << "Parallelogram";
 }

  if (abs(sin(getAngle(segments.get(0), segments.get(2),
                sizes[0], sizes[2]))) < EPSILON
                || abs(sin(getAngle(segments.get(1), segments.get(3),
                        sizes[1], sizes[3]))) < EPSILON) {
    cout << "Trapezium";
  }
  cout << "Ordinary Quadrilateral";
}



int main() {
  int q;
  cin >> q;
  for (int i = 1; i <= q; i++) {
    Point points[4];
    vector<Segment> segments;

    for (int p = 0; p < 4; p++) {
      Point point;

      cin >> point.x;
      cin >> point.y;
    
      for (int pi = 0; pi < p; p++ ) {
        Segment segment;

        segment.p1 = points[pi];
        segment.p2 = point;

        bool crossing = false;
        for (int s = 0; s < segments.size() && !crossing;) {
          Segment currentSegment = segments[s];
          if (areCrossing(segment, currentSegment)) {
            segments.erase(segments.begin()+s);
            crossing = true;
          } else {
            s++;
          }
        }
        if ( !crossing ) {
          segments.push_back(segment);
        }
      }
      points[p] = point;
    }

    Segment segmentArray[4];
    for ( int i = 0; i < 4; i++ ) {
      segmentArray[i] = segments[i];
    }
    
    cout << "Case " << i << ": ";
    classify(segmentArray);
    cout << endl;
  }
}
