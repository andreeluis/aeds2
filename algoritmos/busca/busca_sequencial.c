/* O algoritmo de busca sequencial é algoritmo de busca. Ele pode receber tanto uma lista ordenada de elementos ou desordenada, e consegue fazer a busca em:
  - O(n): no pior caso
  - O(1): no melhor caso
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

#define TAM 10

void preencheVetor(int vetor[], int qtd)
{
  srand(time(NULL));

  for (int i = 0; i < qtd; i++)
  {
    vetor[i] = rand() % 100;
  }
}

void exibeVetor(int vetor[], int qtd)
{
  for (int i = 0; i < qtd; i++)
  {
    printf("%d ", vetor[i]);
  }

  printf("\n");
}

bool pesquisaSeq(int vetor[], int qtde, int valor) {
  for (int i = 0; i < qtde; i++) {
    if (vetor[i] == valor)
      return true;
  }
  return false;
}

int main()
{
  int valor, vetor[TAM];

  printf("BUSCA SEQUENCIAL:\n\n");

  printf("Vetor: ");
  preencheVetor(vetor, TAM);
  exibeVetor(vetor, TAM);

  printf("\nDigite o valor que quer pesquisar no vetor: ");
  scanf("%d", &valor);

  if (pesquisaSeq(vetor, TAM, valor))
    printf("%d está no vetor.", valor);
  else
    printf("%d não está no vetor.", valor);

  return 0;
}
