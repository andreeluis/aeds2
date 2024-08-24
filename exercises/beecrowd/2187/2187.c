#include <stdio.h>

int main() {
  // Notas: B$ 50,00, B$10,00, B$5,00 e B$1,00
  int n = 0, v, b50, b10, b5;

  while (scanf("%d", &v) && v != 0)
  {
    n++;
    b50 = b10 = b5 = 0;

    for (v; v >= 50; v -= 50, b50++);

    for (v; v >= 10; v -= 10, b10++);

    for (v; v >= 5; v -= 5, b5++);

    printf("Teste %d\n%d %d %d %d\n\n", n, b50, b10, b5, v);
  }

  return 0;
}
