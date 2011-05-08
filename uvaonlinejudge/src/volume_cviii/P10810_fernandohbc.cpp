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
 * P10810_fernandohbc.cpp
 * 10810 - Ultra Quick Sort
 *
 *  Created on: Apr 2, 2011
 *  Author: Fernando Cardoso (fernandohbc@gmail.com / @fernando_hbc)
 *
 * nandouva - My ACM/UVa programming project
 * Copyright (C) 2011  Fernando Cardoso
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
#include <iostream>
#include <string.h>
#include <stdlib.h>

using namespace std;

typedef unsigned long long integer;

//void print(int sequence[], int m, int n) {
//    for (int i = m; i < n; i++) {
//        cout << sequence[i] << " ";
//    }
//    cout << endl;
//}

/*
 * Merges two portions of the array
 */
integer merge(int sequence[], int begin, int middle, int end) {
    integer swapcount = 0;

    // Temporary array
    int temp[end - begin];

    // Indexes for merge control
    int tempIdx = 0;
    int leftIdx = begin;
    int rightIdx = middle;

    // Go merge
    while (leftIdx < middle && rightIdx < end) {
        if (sequence[rightIdx] < sequence[leftIdx]) {
            temp[tempIdx++] = sequence[rightIdx++];
            swapcount += middle - leftIdx;
        } else {
            temp[tempIdx++] = sequence[leftIdx++];
        }
    }

    // If there are left indexes to be run
    while (leftIdx < middle) {
        temp[tempIdx++] = sequence[leftIdx++];
    }

    // Sets back to the sequence
    int seqIdx = begin;
    for (int i = 0; i < tempIdx; i++) {
        sequence[seqIdx++] = temp[i];
    }

    return swapcount;
}

/*
 * Performs mergeSort counting swaps between elements
 */
integer mergeSortCountingSwaps(int sequence[], int begin, int end) {
    // cout << "Beginning of the call" << endl;
    // cout << "sequence(" << begin << ", " << end << "): ";
    // print(sequence, begin, end);
    integer swapcount = 0;

    // If there are more than one element
    if (end - begin != 1) {
        // Middle point
        int middle = (begin + end) >> 1;

        // Sorts each subarray
        swapcount += mergeSortCountingSwaps(sequence, begin, middle);
        if (swapcount < 0) {
            cout << "mergeSortCountingSwaps(int[], int, int): swapcount = "
                    << swapcount << endl;
        }
        // cout << "Sorted left side" << endl;
        // cout << "sequence(" << begin << ", " << middle << "): ";
        // print(sequence, begin, middle);
        swapcount += mergeSortCountingSwaps(sequence, middle, end);
        if (swapcount < 0) {
            cout << "mergeSortCountingSwaps(int[], int, int): swapcount = "
                    << swapcount << endl;
        }
        // cout << "Sorted right side" << endl;
        // cout << "sequence(" << middle << ", " << end << "): ";
        // print(sequence, middle, end);

        // Performs merge
        swapcount += merge(sequence, begin, middle, end);
        if (swapcount < 0) {
            cout << "mergeSortCountingSwaps(int[], int, int): swapcount = "
                    << swapcount << endl;
        }
        // cout << "Merged" << endl;
        // cout << "sequence(" << begin << ", " << end << "): ";
        // print(sequence, begin, end);
    }

    return swapcount;
}

int main() {
    // Length of the sequence
    int n = 0;

    // Main loop
    cin >> n;
    while (n != 0) {
        // Reads the sequence
        int sequence[n];
        for (int i = 0; i < n; i++) {
            cin >> sequence[i];
            // cout << "main(): " << sequence[i] << endl;
        }

        // Counts the swaps and prints it
        integer swaps = mergeSortCountingSwaps(sequence, 0, n);
        cout << swaps << endl;

        cin >> n;
    }

    return 0;
}
