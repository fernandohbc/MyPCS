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

#define MAX 100000

using namespace std;

int main() {
  char str[MAX];
  int order[MAX];
  char * numbers[MAX];
  char * tok;
  cin.getline(str, MAX);
  int ntc = atoi(str);
  for ( int tc = 0; tc < ntc; tc++ ) {
    cin.getline(str, MAX); // Ignora a linha em branco
    cin.getline(str, MAX); // Obtem a linha de verdade

    // Quebra de linha se nao for o primeiro tc
    if ( tc != 0 ) {
      cout << endl;
    }

    int n = 0; // Conta os numeros
    tok = strtok(str, " ");
    while ( tok ) {
      int o = atoi(tok);
      order[n++] = o-1;
      tok = strtok(NULL, " ");
    }
    
    // Varre os numeros e imprime na ordem correta:
    cin.getline(str, MAX);
    tok = strtok(str, " ");
    for ( int i = 0; i < n; i++ ) {
      numbers[order[i]] = tok;
      tok = strtok(NULL, " ");
    }

    // Escreve os numeros na ordem correta
    for ( int i = 0; i < n; i++ ) {
      cout << numbers[i] << endl;
    }
  }
  return 0;
}
