#include <stdio.h>

int main() {
  int val, i;

  scanf("%d", &val);

  // 100, 50, 20, 10, 5, 2, 1
  printf("%d\n", val);

  i = 0;
  while (val >= 100) {
    i++;
    val -= 100;
  }
  printf("%d nota(s) de R$ 100,00\n", i);

  i = 0;
  while (val >= 50) {
    i++;
    val -= 50;
  }
  printf("%d nota(s) de R$ 50,00\n", i);

  i = 0;
  while (val >= 20) {
    i++;
    val -= 20;
  }
  printf("%d nota(s) de R$ 20,00\n", i);

  i = 0;
  while (val >= 10) {
    i++;
    val -= 10;
  }
  printf("%d nota(s) de R$ 10,00\n", i);

  i = 0;
  while (val >= 5) {
    i++;
    val -= 5;
  }
  printf("%d nota(s) de R$ 5,00\n", i);

  i = 0;
  while (val >= 2) {
    i++;
    val -= 2;
  }
  printf("%d nota(s) de R$ 2,00\n", i);

  // 1
  printf("%d nota(s) de R$ 1,00\n", val);


  return 0;
}
