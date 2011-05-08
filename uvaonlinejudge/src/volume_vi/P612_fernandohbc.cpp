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
 * P612_fernandohbc.cpp
 * 612 - DNA Sorting
 *
 *  Created on: Mar 30, 2011
 *      Author: Fernando Cardoso (fernandohbc@gmail.com / @fernando_hbc)
 */
#include <iostream>
#include <string.h>
#include <stdlib.h>

#define MAX_LINE 51

using namespace std;

int getSortedness(char * dna, int n) {
    bool swapped = false;
    int swapcount = 0;

    // Clones the dna sequence
    char clone[n + 1];
    strcpy(clone, dna);

    //    cout << "getSortedness(): DNA = [" << dna <<  "]"<< endl;
    //    cout << "getSortedness(): Before Sorting Cloned = [" << clone << "]" << endl;
    do {
        swapped = false;
        for (int i = 1; i < n; i++) {
            if (clone[i - 1] > clone[i]) {
                char tmp = clone[i - 1];
                clone[i - 1] = clone[i];
                clone[i] = tmp;
                swapped = true;
                swapcount++;
            }
        }
    } while (swapped);
    //    cout << "getSortedness(): After Sorting Cloned = [" << clone << "]" << endl;
    return swapcount;
}

int main() {
    // Number of test cases
    int qtc = 0;
    cin >> qtc;

    // Discards the rest of the first line
    char line[MAX_LINE];
    //    cout << "main(): Created the line" << endl;
    cin.getline(line, MAX_LINE);

    // For each test case...
    for (int tc = 0; tc < qtc; tc++) {
        // Prints an extra line after each test case
        if ( tc > 0 ) {
            cout << endl;
        }

        // Reads a blank line
        cin.getline(line, MAX_LINE);
        //        cout << "main(): Read the blank line: [" << line << "]" << endl;

        /* Reads
         *  n = string length
         *  m = qty of strings
         */
        cin.getline(line, MAX_LINE);
        //        cout << "main(): Read the line: [" << line << "]" << endl;

        int n = atoi(strtok(line, " "));
        int m = atoi(strtok(NULL, " "));
        //        cout << "main(): Read m and n" << endl;

        // Reads the m strings
        char dnatable[m][n + 1];
        for (int s = 0; s < m; s++) {
            cin.getline(line, MAX_LINE);
            strcpy(dnatable[s], line);
        }

        // Calcula o messiness de cada um
        int messiness[m];
        //        cout << "main(): Before calling getSortendess" << endl;
        for (int s = 0; s < m; s++) {
            messiness[s] = getSortedness(dnatable[s], n);
            //            cout << "main(): messiness[" << s << "] = " << messiness[s] << endl;
        }

        //Ordena tanto o messiness quanto o dnatable
        bool swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < m; i++) {
                if (messiness[i - 1] > messiness[i]) {
                    //                    cout << "main(): Will Swap" << endl;
                    //                    cout << "main(): " << dnatable[i-1] << "\t" << dnatable[i] << endl;
                    int tmp = messiness[i - 1];
                    char tmpChr[n + 1];
                    strcpy(tmpChr, dnatable[i - 1]);
                    //                    cout << "main(): TmpChr is " << tmpChr << endl;

                    messiness[i - 1] = messiness[i];
                    strcpy(dnatable[i - 1], dnatable[i]);

                    messiness[i] = tmp;
                    strcpy(dnatable[i], tmpChr);

                    //                    cout << "main(): " << dnatable[i-1] << "\t" << dnatable[i] << endl;
                    swapped = true;
                }
            }
        } while (swapped);

        /*
         *  TODO: continue from her
         *  Just printing the dna sequences
         */
        for (int s = 0; s < m; s++) {
            cout << dnatable[s] << endl;
        }
    }

    return 0;
}
