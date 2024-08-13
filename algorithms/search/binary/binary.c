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

void selecSort(int vetor[], int qtde)
{
  int menor, aux;

  for (int i = 0; i < (qtde - 1); i++)
  {
    menor = i;
    for (int j = (i + 1); j < qtde; j++)
    {
      if (vetor[j] < vetor[menor])
        menor = j;
    }

    aux = vetor[i];
    vetor[i] = vetor[menor];
    vetor[menor] = aux;
  }
}

bool pesquisaBin(int vetor[], int qtde, int valor)
{
  int inicio = 0, fim = (qtde - 1), meio;

  while (inicio <= fim)
  {
    meio = (inicio + fim) / 2;

    if (vetor[meio] == valor)
      return true;
    else if (vetor[meio] < valor)
      inicio = meio + 1;
    else
      fim = meio - 1;
  }

  return false;
}

int main()
{
  int valor, vetor[TAM];

  printf("BUSCA BINÁRIA:\n\n");

  printf("Vetor desordenado: ");
  preencheVetor(vetor, TAM);
  exibeVetor(vetor, TAM);

  printf("   Vetor ordenado: ");
  selecSort(vetor, TAM);
  exibeVetor(vetor, TAM);

  printf("\nDigite o valor que quer pesquisar no vetor: ");
  scanf("%d", &valor);

  if (pesquisaBin(vetor, TAM, valor))
    printf("%d está no vetor.", valor);
  else
    printf("%d não está no vetor.", valor);

  return 0;
}
