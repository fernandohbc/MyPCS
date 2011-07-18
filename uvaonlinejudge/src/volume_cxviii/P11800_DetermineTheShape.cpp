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
#include <vector>
#include <math.h>

#define EPSILON  1e-15

using namespace std;

struct Point {
  int x; int y;
};

struct Segment {
  Point p1; Point p2;
};

double getAngle(Segment s1, Segment s2, double norm1, double norm2) {
  double pi = (s1.p1.x - s1.p2.x)*(s2.p1.x-s2.p2.x) + (s1.p1.y-s1.p2.y)*(s2.p1.y-s2.p2.y);
  double angle = acos(pi / (norm1 * norm2));
  return angle;
}

bool allSame(double d[]) {
  return d[0] == d[1] && d[0] == d[2] && d[0] == d[3];
}

void getAngles(Segment segments[], double sizes[], double angles[]) {
  for (int i = 0; i < 4; i++) {
    angles[i] = getAngle(segments[i], segments[(i + 1) % 4], sizes[i], sizes[(i + 1) % 4]);
  }
}

void getSizes(Segment segments[], double sizes[]) {
  for (int i = 0; i < 4; i++) {
    sizes[i] = (segments[i].p1.x-segments[i].p2.x)*(segments[i].p1.x-segments[i].p2.x);
    sizes[i] += (segments[i].p1.y-segments[i].p2.y)*(segments[i].p1.y-segments[i].p2.y);
    sizes[i] = sqrt(sizes[i]);
  }
}

bool equals(Point p1, Point p2) {
  return p1.x == p2.x && p1.y == p2.y;
}

bool isAdjacent(Segment s1, Segment s2) {
  return equals(s1.p1, s2.p1) || equals(s1.p1, s2.p2) || equals(s1.p2, s2.p1) || equals(s1.p2, s2.p2);
}

void arrangeSegments(Segment segments[]) {
  for ( int i = 0; i <=2; i++ ) {
    int k = i + 1;
    while (!isAdjacent(segments[i], segments[k])) {
      k++;
    }
    Segment temp = segments[i+1];
    segments[i+1] = segments[k];
    segments[k] = temp;
  }
}

Point minusPoints(Point p1, Point p2) {
  Point result;
  result.x = p1.x-p2.x;
  result.y = p1.y-p2.y;
  return result;
}

double dot(Point p1, Point p2) {
  return p1.x*p2.x+p1.y*p2.y;
}

bool areCrossing(Segment ab, Segment cd) {
  Point e = minusPoints(ab.p2, ab.p1);
  Point f = minusPoints(cd.p2, cd.p1);

  Point p;
  p.x = -e.y;
  p.y = e.x;

  double  h = dot(minusPoints(ab.p1,cd.p1), p) / dot(f, p);

  return h > 0 && h < 1;
}

double abs(double d) {
  return d>=0?d:-d;
}

void print(Point p) {
  cout << "(" << p.x << ", " << p.y << ")";
}

void print(Segment s) {
  cout << "{";
  print(s.p1);
  cout << ", ";
  print(s.p2);
  cout << "}";
}

void print(Segment s[]) {
  cout << "[";
  for (int i = 0; i < 4; i++ ) {
    print(s[i]);
    if ( i < 3 ) {
      cout << "; ";
    }
  }
  cout << "]" << endl;

}

void print(double d[]) {
  cout << "[";
  for (int i = 0; i < 4; i++ ) {
    cout << d[i];
    if ( i < 3 ) {
      cout << ", ";
    }
  }
  cout << "]" << endl;
}

bool isVertical(Segment s) {
  return s.p1.x == s.p2.x;
}

double slope(Segment s) {
  // print(s);
  double result = 1.0*(s.p2.y-s.p1.y)/(s.p2.x-s.p1.x);
//  cout << " slope is " << result << endl;
  return result; 
}

bool parallel(Segment s1, Segment s2) {
  bool result;
  if ( isVertical(s1) ) {
    result = isVertical(s2);
  } else if ( isVertical(s2) ) {
    result = false;
  } else {
    result = slope(s1) == slope(s2);
  }
  
  //if ( result ) {
  //  print(s1);
  //  cout << " and ";
  //  print(s2);
  //  cout << " are parallel.";
  //}

  return result;
}

void classify(Segment segments[]) {
//  print(segments);
  arrangeSegments(segments);
//  print(segments);
  
  double sizes[4];
  getSizes(segments, sizes);
//  print(sizes);

  double angles[4];
  getAngles(segments, sizes, angles);
  // print(angles);

  if (allSame(sizes)) {
    if (allSame(angles)) {
      cout << "Square";
      return;
    } else {
      cout << "Rhombus";
      return;
    }
  }

 if (allSame(angles)) {
   cout << "Rectangle"; return;
 }

 if (sizes[0] == sizes[2] && sizes[1] == sizes[3]) {
   cout << "Parallelogram"; return;
 }

  if ( parallel( segments[0], segments[2]) || parallel(segments[1], segments[3])) {
    cout << "Trapezium"; return;
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
      for (int pi = 0; pi < p; pi++ ) {
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
    for ( int s = 0; s < 4; s++ ) {
      segmentArray[s] = segments[s];
    }
    
    cout << "Case " << i << ": ";
    classify(segmentArray);
    cout << endl;
  }
}
