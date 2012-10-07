/* MyPCS - My Programming Contests Solutions
 *
 * email: fernandohbc@gmail.com
 * Google+: plus.google.com/117689849496467534996
 *  
 * 
 * SPOILER ALERT!
 * These are the solutions for problems from Programming Contests and Online
 * Judges. Seeing an accepted code before getting accepted by oneself is uncool.
 * 
 * Q: So why are the solutions being made available?
 * A: For educational purposes only. Some of the problems can be used in Contests
 * training (even if it is to show how NOT to do :-) ) and also can serve to
 * compare solutions and algorithms. Also, the author thinks it is cool to have
 * his code well versioned.
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
#include <string.h>
#include <stdlib.h>

#define MAX_AGE 100

using namespace std;

typedef int integer;

/*
 * Initializes the bucket with all zeroes
 */
void init(integer bucket[]) {
    for (int i = 0; i < MAX_AGE; i++) {
        bucket[i] = 0;
    }
}

int main() {
    // Length of the sequence
    int n = 0;

    // Main loop
    cin >> n;
    integer bucket[MAX_AGE];
    while (n != 0) {
        // Initializes the bucket
        init(bucket);

        // Reads the numbers and fills the buckets
        int age = 0;
        for (int i = 0; i < n; i++) {
            cin >> age;
            bucket[age - 1]++;
        }

        // Prints the ordered sequence
        bool first = true;
        for (int i = 1; i <= MAX_AGE; i++) {
            for (int k = 0; k < bucket[i - 1]; k++) {
                if (first) {
                    cout << i;
                    first = false;
                } else {
                    cout << " " << i;
                }
            }
        }
        cout << endl;

        cin >> n;
    }

    return 0;
}
