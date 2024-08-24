#include <stdio.h>

int main() {
  long long int a, b;

  while(scanf("%lld %lld", &a, &b) != EOF) {
    // Bitwise XOR
    printf("%lld\n", a ^ b);
  }

  return 0;
}
