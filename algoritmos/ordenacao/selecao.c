/* A ideia central do algoritmo de seleção é, em cada iteração, escolher o menor elemento da parte não ordenada para colocá-lo na parte ordenada.
  O custo do algoritmo de seleção é:
  - O(n²): no melhor caso;
  - O(n²): no pior caso.
*/

#include <stdio.h>
#include <stdlib.h>
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

void ordenaSelecao(int vetor[], int qtd)
{
  int menor, aux;
  for (int i = 0; i < qtd - 1; i++)
  {
    menor = i;

    for (int j = i + 1; j < qtd; j++)
    {
      if (vetor[j] < vetor[menor])
        menor = j;
    }

    aux = vetor[i];
    vetor[i] = vetor[menor];
    vetor[menor] = aux;
  }
}

int main()
{
  int vetor[TAM];

  preencheVetor(vetor, TAM);
  exibeVetor(vetor, TAM);

  ordenaSelecao(vetor, TAM);
  exibeVetor(vetor, TAM);
}
