#include <stdio.h>

void ordena(int arr[], int n) {
  int i = 0;
  int j = n - 1;

  while (i < j) {
    int menorPar = i + 1;
    int menorImpar = j - 1;

    for (int k = i; k < j; k++) {
      if (arr[k] % 2 == 0 && arr[k] < arr[menorPar]) {
        menorPar = k;
      } else if (arr[k] % 2 != 0 && arr[k] < arr[menorImpar]) {
        menorImpar = k;
      }
    }

    if (arr[menorPar] % 2 == 0) {
      int aux = arr[i];
      arr[i] = arr[menorPar];
      arr[menorPar] = aux;

      i++;
    }

    if (arr[menorImpar] % 2 != 0) {
      int aux = arr[j];
      arr[j] = arr[menorImpar];
      arr[menorImpar] = aux;

      j--;
    }
  }
}

int main() {
  long int n;
  scanf("%ld", &n);

  unsigned int nums[n];
  for (int i = 0; i < n; i++) {
    scanf("%u", &nums[i]);
  }

  ordena(nums, n);

  for (int i = 0; i < n; i++) {
    printf("%d\n", nums[i]);
  }

  return 0;
}
