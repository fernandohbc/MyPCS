#include <iostream>
#include <stdlib.h>

using namespace std;

bool executeTestCase(int tc) {
  int n, q;
  cin >> n;
  cin >> q;

  if (n == 0 && q == 0) {
    return false;
  }

  cout << "CASE# " << tc << ":" << endl;
  int marbles[10001];
  for (int i = 0; i <= 10000; i++) {
    marbles[i] = 0;
  }
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    marbles[x]++;
  }

  // Processing
  int lastIdx = 0;
  for (int x = 1; lastIdx < n; x++) {
    if (marbles[x] != 0) {
      int tmp = lastIdx;
      lastIdx = lastIdx + marbles[x];
      marbles[x] = tmp + 1;
    }
  }

  for (int i = 0; i < q; i++) {
    int x;
    cin >> x;
    int pos = marbles[x];
    if (pos > 0) {
      cout << x << " found at " << pos << endl;
    } else {
      cout << x << " not found" << endl;
    }
  }

  return true;
}

int main() {
  int tc = 1;
  while (executeTestCase(tc++)) {}
  return 0;
}

