#include <stdio.h>

void construir(int arr[], int tam) {
  for (int i = tam; i > 1 && arr[i] > arr[i / 2]; i /= 2) {
    int aux = arr[i];
    arr[i] = arr[i / 2];
    arr[i / 2] = aux;
  }
}

int maiorFilho(int arr[], int tam, int i) {
  if (2 * i == tam || arr[2 * i] > arr[2 * i + 1])
    return 2 * i;
  else
    return 2 * i + 1;
}

void reconstruir(int arr[], int tam) {
  int i = 1;
  while (i <= (tam / 2)) { // enquanto o elemento tiver filho
    int iMaior = maiorFilho(arr, tam, i);

    // se o pai é menor que o filho
    if (arr[i] < arr[iMaior]) {
      int aux = arr[i];
      arr[i] = arr[iMaior];
      arr[iMaior] = aux;

      i = iMaior;
    } else {
      i = tam;
    }
  }
}

void heapSort(int arr[], int n) {
  // deslocar 1 para frente
  int arrTmp[n + 1];
  for (int i = 0; i < n; i++) {
    arrTmp[i + 1] = arr[i];
  }

  // construir
  for (int tam = 2; tam <= n; tam++) {
    construir(arrTmp, tam);
  }

  // ordenação
  int tam = n;
  while (tam > 1) {
    int aux = arrTmp[tam];
    arrTmp[tam] = arrTmp[1];
    arrTmp[1] = aux;

    tam--;

    reconstruir(arrTmp, tam);
  }

  // deslocar 1 para tras
  for (int i = 0; i < n; i++) {
    arr[i] = arrTmp[i + 1];
  }
}

int main() {
  int n;

  while(scanf("%d", &n) != EOF) {
    int cod[n];

    for (int i = 0; i < n; i++) {
      scanf("%d", &cod[i]);
    }

    heapSort(cod, n);

    for (int i = 0; i < n; i++) {
      printf("%04d\n", cod[i]);
    }
  }

  return 0;
}
