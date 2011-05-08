/*******************************************************************************
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. In other words, use it
 * at your own risk.
 * 
 * If you find this a little useful, you can buy the author some beer.
 * If you find this really useful, you can buy a kid a book, and help making
 * the world more literate.
 ******************************************************************************/
#include <iostream>

#define MAXLINE 50

using namespace std;

/*
 * TODO: This is an incomplete code.
 * Must be completed before submission
 */

int main() {
  // Number of test cases
  char line[MAXLINE];
  cin.getline(line, MAXLINE);
  int nOfTestCases = atoi(line);

  for ( int i = 0; i < nOfTestCases; i++ ) {
    // Ignores blank line
    cin.getline(line, MAXLINE);

    cin.getline(line, MAXLINE);
    while (!cin.eof() && strlen(line) > 0 ) {
      // TODO: Get rid of this line.
      // This is a test line and must be deleted before submission
      cout << line << endl;

      cin.getline(line, MAXLINE);
    }
  }

  return 0;
}
