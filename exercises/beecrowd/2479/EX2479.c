#include <stdio.h>
#include <stdbool.h>
#include <string.h>

typedef struct Crianca {
  char nome[21];
} Crianca;

int main() {
  int n, comportaram = 0;
  char comportamento;
  scanf("%d", &n);

  Crianca criancas[n];
  for (int i = 0; i < n; i++) {
    scanf(" %c %[^\n]", &comportamento, criancas[i].nome);

    if (comportamento == '+')
      comportaram++;
  }

  for (int i = 1; i < n; i++) {
    Crianca temp = criancas[i];
    int j = i - 1;

    while (j >= 0 && strcmp(criancas[j].nome, temp.nome) > 0)
    {
      criancas[j + 1] = criancas[j];
      j--;
    }
    criancas[j + 1] = temp;
  }

  for (int i = 0; i < n; i++) {
    printf("%s\n", criancas[i].nome);
  }

  printf("Se comportaram: %d | Nao se comportaram: %d", comportaram, (n - comportaram));

  return 0;
}
