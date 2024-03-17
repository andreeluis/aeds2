/* A ideia central do algoritmo de Inserção é percorrer o vetor de elementos da esquerda para a direita e à medida que avança vai ordenando os elementos à esquerda.
  O custo do algoritmo de ordenação por inserção é:
  - O(n): no melhor caso;
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

void ordenaInsercao(int vetor[], int qtd)
{
  for (int i = 1; i < qtd; i++)
  {
    int aux = vetor[i];
    int j = i - 1;

    while ((j >= 0) && (vetor[j] > aux))
    {
      vetor[j + 1] = vetor[j];
      j--;
    }

    vetor[j + 1] = aux;
  }
}

int main()
{
  int vetor[TAM];

  preencheVetor(vetor, TAM);
  exibeVetor(vetor, TAM);

  ordenaInsercao(vetor, TAM);
  exibeVetor(vetor, TAM);
}
