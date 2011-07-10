#include <iostream>
#include <stdio.h>

using namespace std;

long toDecadary(long dodec) {
  int cc = dodec % 100;

  dodec /= 100;
  cc += (dodec % 100) * 100;

  dodec /= 100;
  cc += (dodec % 100) * 100 * 60;

  dodec /= 100;
  cc += dodec * 100 * 60 * 60;

  return cc * 125 / 108;
}

int main() {
  long dodec = 0;
  while ( cin >> dodec ) {
    long dec = toDecadary(dodec);
    printf("%07d\n", dec);
  }
  return 0;
}
