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
#define MAX 2000

using namespace std;

int main() {
  char line[MAX];
  cin.getline(line, MAX);
  while (strlen(line) == 0 || line[0] != '#') {
    int hexCode = 0;
    for ( int i = 0; line[i] != '\0'; i++ ) {
      hexCode <<= 8;
      hexCode += line[i];
      hexCode %= 34943;
    }

    hexCode = (((hexCode << 8) % 34943) << 8) % 34943;


    if (hexCode == 0) {
      cout << "00 00" << endl;
    } else {
      int crc = 34943 - hexCode;
      printf("%02X %02X\n", crc >> 8, crc & 255);
    }
    cin.getline(line, MAX);
  }
  return 0;
}
