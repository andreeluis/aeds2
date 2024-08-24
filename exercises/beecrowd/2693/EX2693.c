#include <stdio.h>
#include <string.h>

typedef struct Passageiro
{
  char nome[50];
  char regiao;
  int distancia;
} Passageiro;

int main() {
  int q;

  while(scanf("%d", &q) != EOF) {
    scanf("%d", &q);
    Passageiro passageiros[q];

    for (int i = 0; i < q; i++) {
      scanf("%s %c %d", passageiros[i].nome, &passageiros[i].regiao, &passageiros[i].distancia);
    }

    for (int i = 0; i < q; i++) {
      int menor = i;

      for (int j = i; j < q; j++) {
        int distDiff = passageiros[j].distancia - passageiros[menor].distancia;
        int regDiff = passageiros[j].regiao - passageiros[menor].regiao;
        int nomeDiff = strcmp(passageiros[j].nome, passageiros[menor].nome);

        if (distDiff < 0 || (distDiff == 0 && passageiros[j].regiao < passageiros[menor].regiao) || (distDiff == 0 && passageiros[j].regiao == passageiros[menor].regiao && nomeDiff < 0))
          menor = j;
      }

      Passageiro aux = passageiros[i];
      passageiros[i] = passageiros[menor];
      passageiros[menor] = aux;

      printf("%s\n", passageiros[i].nome);
    }
  }

  return 0;
}
