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
#include <iostream>

using namespace std;

int reverse(unsigned int num) {
  unsigned int result = 0;
  for (int i = 0; i < 4; i++ ) {
    // cout << i << "\t" << num << "\t" << result << endl;
    result = result << 8;
    result = result + (num & 255);
    num = num >> 8;
  }
  // cout << "32" << "\t" << num << "\t" << result << endl;
  return result;
}

int main() {
  int n;
  while (cin >> n)
    cout << n << " converts to " << reverse(n) << endl;
}
