/* O algoritmo de ordenação da bolha (bubble sort) funciona percorrendo a lista de elementos do início ao fim, comparando pares de elementos adjacentes e trocando-os de lugar se estiverem na ordem errada. Este processo é repetido até que a lista esteja ordenada.
  A cada passagem pela lista, o maior elemento "borbulha" até o final da lista, daí o nome "Bubble Sort".
  O custo do algoritmo da bolha é:
  - O(n): no melhor caso;
  - O(n²): no pior caso.
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

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

void ordenaBolha(int vetor[], int qtd)
{
  for (int i = 0; i < qtd - 1; i++)
  {
    for (int j = 0; j < qtd - (i + 1); j++)
    {
      if (vetor[j] > vetor[j + 1])
      {
        int aux = vetor[j];
        vetor[j] = vetor[j + 1];
        vetor[j + 1] = aux;
      }
    }
  }
}

int main()
{
  int vetor[TAM];

  preencheVetor(vetor, TAM);
  exibeVetor(vetor, TAM);

  ordenaBolha(vetor, TAM);
  exibeVetor(vetor, TAM);
}
