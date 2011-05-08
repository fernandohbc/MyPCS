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

using namespace std;

int calculateCycleLength(int n) {
  int length = 1;

  while (n != 1) {
    length++;
    if ( n % 2 == 1 ) {
      n = 3*n + 1;
    } else {
      n = n / 2;
    }
  }

  return length;
}

int main() {
  // Leitura dos números
  long i, j;

  while ( cin >> i >> j) {
    // Verifica quem é o maior e quem é o menor
    long max = (j >= i)?j:i;
    long min = (i <= j)?i:j;

    // Variavel temporaria que tem o maior ciclo ate agora
    long maxCycle = 0;

    // Varre em busca do maior ciclo
    for ( long n = min; n <= max; n++ ) {
      int cycleLength = calculateCycleLength(n);
      if (cycleLength > maxCycle) {
        maxCycle = cycleLength;
      }
    }
  
    // Imprime na mesma ordem da entrada, adicionando o maior ciclo
    cout << i << " " << j << " " << maxCycle << endl;
  }
  return 0;
}
