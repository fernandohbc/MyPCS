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
 * SPOJ Problem #4888. Copa do mundo
 * 
 * Author: Fernando Cardoso (fernandohbc@gmail.com)
 */
#include <string>
#include <iostream>

using namespace std;

static int totTimes;
static int totPartidas;
static int pontuacao;
static int totPontos;
static int difPontos;

int main()
{
  cin >> totTimes >> totPartidas;
  while(totTimes > 0 )
  {
    totPontos = 0;
    for(int i = 0; i < totTimes; i++)
    {
      string time;
      cin >> time >> pontuacao;
      totPontos += pontuacao;
    }    
    difPontos = (totPartidas * 3) - totPontos;
    cout << difPontos  << endl;
    cin >> totTimes >> totPartidas;
  }
  return 0;
}
