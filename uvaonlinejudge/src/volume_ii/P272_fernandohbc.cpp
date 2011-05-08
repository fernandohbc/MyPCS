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
/*
 * P272_fernandohbc.cpp
 * 272 - TEX Quotes
 *
 * Author: Fernando Cardoso (fernandohbc@gmail.com / @fernando_hbc)
 *
 * nandouva - My ACM/UVa programming project
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

#include <string>
#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
  char linha[2000];
  int count = 0;
  while ( gets( linha) ) {
    for ( int i = 0; linha[i] != '\0'; i++ ) {
      if ( linha[i] == '\"' ) {
        if ( count % 2 == 0 ) {
          cout << "``";
        } else {
          cout << "\'\'";
        }
        count ++;
      } else {
        cout << linha[i];
      }
    }
    cout << endl;
  }
  return 0;
}
