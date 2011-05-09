/*******************************************************************************
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
 ******************************************************************************/

#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stack>
#include <vector>

#define MAX_LINE 78
#define CARDS_PER_LINE 26

using namespace std;

struct Card {
    char rank;
    char suit;
};

typedef stack<Card> Pile;

void print(Card c) {
    cout << c.rank << c.suit;
}

bool matches(Card c, Card d) {
    return c.rank == d.rank || c.suit == d.suit;
}

void moveOnto(Pile from, Pile to) {
    Pile aux;
    while (!from.empty()) {
        aux.push(from.top());
        from.pop();
    }

    while (!aux.empty()) {
        to.push(aux.top());
        aux.pop();
    }
}

bool moveShift(int & idx, int & shift, vector<Pile> * piles) {
    if (idx + shift < 0 || idx + shift >= piles->size()) {
        return false;
    }
    if (matches((*piles)[idx].top(), (*piles)[idx + shift].top())) {
        moveOnto((*piles)[idx], (*piles)[idx + shift]);
        piles->erase(idx);
        idx = idx + shift;
        return true;
    }
    return false;
}

int main() {
    // Reads the first line
    char line[MAX_LINE];
    cin.getline(line, MAX_LINE);

    // Main loop
    while (line[0] != '#') {
        vector<Pile> * piles = new vector<Pile> ();
        for (int l = 0; l < 2; l++) {
            for (int i = 0; i < CARDS_PER_LINE; i++) {
                // Parses the card
                char* cardStr = strtok((i == 0 ? line : NULL), " ");
                Card card;
                card.rank = cardStr[0];
                card.suit = cardStr[1];

                // Puts in the list
                Pile pile;
                pile.push(card);
                piles->push_back(pile);

                // Moves around
                int size = piles->size() - 1;
                int idx = size;
                bool moved = false;
                do {
                    moved = false;
                    int shift = -3;
                    while (shift <= 3 && !moved) {
                        moved = moveShift(idx, shift, piles);
                    }
                } while (moved);
            }
            cin.getline(line, MAX_LINE);
        }

        // Result
        cout << piles->size() << " piles remaining: ";
        for ( int i = 0; i < piles->size(); i++ ) {
            cout << piles[i].size() << " ";
        }
        cout << endl;
        delete piles;
    }
    return 0;
}
