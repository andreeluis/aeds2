#include <stdio.h>
#include <string.h>

#define MAX_NAME 21

void merge(char arr[][MAX_NAME], int left, int mid, int right) {
  int n1 = mid - left + 1;
  int n2 = right - mid;

  char L[n1][MAX_NAME], R[n2][MAX_NAME];

  for (int i = 0; i < n1; i++) {
    strcpy(L[i], arr[left + i]);
  }

  for (int j = 0; j < n2; j++) {
    strcpy(R[j], arr[mid + 1 + j]);
  }

  // merge the two halves
  int i = 0, j = 0, k;
  for (k = left; k <= right && i < n1 && j < n2; k++) {
    if (strcmp(L[i], R[j]) <= 0)
      strcpy(arr[k], L[i++]);
    else
      strcpy(arr[k], R[j++]);
  }

  while (i < n1) {
    strcpy(arr[k++], L[i++]);
  }

  while (j < n2) {
    strcpy(arr[k++], R[j++]);
  }
}

void mergeSort(char arr[][MAX_NAME], int left, int right) {
  if (left < right) {
    int mid = (left + right) / 2;

    // divide
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    // intercalar
    merge(arr, left, mid, right);
  }
}

int main() {
  int n, k;

  scanf("%d %d", &n, &k);
  char alunos[n][MAX_NAME];

  for (int i = 0; i < n; i++) {
    scanf("%s", alunos[i]);
  }

  mergeSort(alunos, 0, n - 1);

  printf("%s\n", alunos[k - 1]);

  return 0;
}
