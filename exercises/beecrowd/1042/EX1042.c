#include <stdio.h>

void quickSort(int arr[], int left, int right) {
  int i = left, j = right;
  int pi = arr[left];

  while (i <= j) {
    while (arr[i] < pi) i++;
    while (arr[j] > pi) j--;

    if (i <= j) {
      int aux = arr[i];
      arr[i] = arr[j];
      arr[j] = aux;

      i++;
      j--;
    }
  }

  if (left < j)
    quickSort(arr, left, j);
  if (right > i)
    quickSort(arr, i, right);
}

int main() {
  int qtde = 3;
  int arr[qtde], arrb[qtde];

  for (int i = 0; i < qtde; i++) {
    scanf("%d", &arr[i]);
    arrb[i] = arr[i];
  }

  quickSort(arr, 0, qtde - 1);

  for (int i = 0; i < qtde; i++) {
    printf("%d\n", arr[i]);
  }

  printf("\n");

  for (int i = 0; i < qtde; i++) {
    printf("%d\n", arrb[i]);
  }

  return 0;
}
