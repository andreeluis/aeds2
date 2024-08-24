#include <stdio.h>

int main() {
  int t, aux, acertos = 0;

  scanf("%d", &t);

  for (int i = 1; i <= 5; i++) {
    scanf("%d", &aux);

    if (aux == t) {
      acertos++;
    }
  }

  printf("%d\n", acertos);
}
