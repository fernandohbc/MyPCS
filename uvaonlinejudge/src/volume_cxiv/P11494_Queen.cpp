/* MyPCS - My Programming Contests Solutions
 *
 * email: fernandohbc@gmail.com
 * Google+: plus.google.com/117689849496467534996
 *  
 * 
 * SPOILER ALERT!
 * These are the solutions for problems from Programming Contests and Online
 * Judges. Seeing an accepted code before getting accepted by oneself is uncool.
 * 
 * Q: So why are the solutions being made available?
 * A: For educational purposes only. Some of the problems can be used in Contests
 * training (even if it is to show how NOT to do :-) ) and also can serve to
 * compare solutions and algorithms. Also, the author thinks it is cool to have
 * his code well versioned.
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

