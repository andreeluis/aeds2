#include <stdio.h>
#include <stdlib.h>

typedef struct {
  char nome[100];
  int ouro;
  int prata;
  int bronze;
} Pais;

int compare(const void *a, const void *b) {
  // Convertendo os ponteiros genéricos para ponteiros de países
  const Pais *p1 = (const Pais *)a;
  const Pais *p2 = (const Pais *)b;

  // Comparando o número de medalhas de ouro
  int ouroDiff = p2->ouro - p1->ouro;
  if (ouroDiff != 0)
    return ouroDiff;

  // Se o número de medalhas de ouro for igual, comparar o número de medalhas de prata
  int prataDiff = p2->prata - p1->prata;
  if (prataDiff != 0)
    return prataDiff;

  // Se o número de medalhas de prata também for igual, comparar o número de medalhas de bronze
  return p2->bronze - p1->bronze;
}

int main() {
  int n;
  scanf("%d", &n);

  Pais paises[n];
  for (int i = 0; i < n; i++) {
    scanf("%s %d %d %d", paises[i].nome, &paises[i].ouro, &paises[i].prata, &paises[i].bronze);
  }

  qsort(paises, n, sizeof(Pais), compare);

  for (int i = 0; i < n; i++) {
    printf("%s %d %d %d\n", paises[i].nome, paises[i].ouro, paises[i].prata, paises[i].bronze);
  }

  return 0;
}
