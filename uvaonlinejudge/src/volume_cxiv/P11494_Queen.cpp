#include <iostream>
#include <stdlib.h>

using namespace std;

int totMovimentos(int x1, int y1, int x2, int y2) {
 if(x1 == x2 && y1 == y2) {
   return 0;
 }
 if(x1 == x2 || y1 == y2 || abs(x1-x2) == abs (y1-y2) ) {
   return 1;
 }
 return 2;
}

int main() {
 int x1, y1, x2, y2;
 cin >> x1;
 cin >> y1;
 cin >> x2;
 cin >> y2;
 while (x1 != 0) {
   cout << totMovimentos(x1, y1, x2, y2) << endl;
   cin >> x1;
   cin >> y1;
   cin >> x2;
   cin >> y2;
 }
 return 0;
}

