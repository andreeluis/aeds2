#include <stdio.h>

typedef struct Avistamento {
  int hora;
  int minuto;
  char nome[105];
} Avistamento;

int main() {
  int p, q;

  scanf("%d %d", &p, &q);

  Avistamento avistamentos[q];

  for (int i = 0; i < q; i++) {
    scanf("%d:%d %s", &avistamentos[i].hora, &avistamentos[i].minuto, avistamentos[i].nome);
  }

  for (int i = 0; i < q; i++) {
    Avistamento tmp = avistamentos[i];
    int j = i - 1;

    while (j >= 0 &&
      (avistamentos[j].hora < tmp.hora ||
      (avistamentos[j].hora == tmp.hora &&
        avistamentos[j].minuto > tmp.minuto)))
    {
      avistamentos[j + 1] = avistamentos[j];
      j--;
    }

    avistamentos[j + 1] = tmp;
  }

  for (int i = 0; i < q; i++) {
    if (avistamentos[i].hora == 0 && avistamentos[i].minuto <= p)
      printf("%s\n", avistamentos[i].nome);
    else if (avistamentos[i].hora == 23 && (60 - avistamentos[i].minuto) <= p)
      printf("%s\n", avistamentos[i].nome);
  }

  return 0;
}
