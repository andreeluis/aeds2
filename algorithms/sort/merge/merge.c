#include <stdio.h>
#include <limits.h>

void merge(int arr[], int left, int mid, int right){
  int n1 = mid - left + 1;
  int n2 = right - mid;

  int L[n1], R[n2];

  // first half
  for(int i = 0; i < n1; i++){
    L[i] = arr[left + i];
  }

  // second half
  for(int j = 0; j < n2; j++){
    R[j] = arr[mid + 1 + j];
  }

  // sentinel values
  L[n1] = INT_MAX;
  R[n2] = INT_MAX;

  // merge the two halves
  for (int i = 0, j = 0, k = left; k <= right; k++) {
    if (L[i] <= R[j])
      arr[k] = L[i++];
    else
      arr[k] = R[j++];
  }
}

void mergeSort(int arr[], int left, int right){
  if (left < right) {
    int mid = (left + right) / 2;

    // divide the list into two halves
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    // merge the two halves
    merge(arr, left, mid, right);
  }
}

int main(){
  int arr[] = { 12, 11, 13, 5, 6, 7 };
  int arr_size = sizeof(arr) / sizeof(arr[0]);

  mergeSort(arr, 0, arr_size - 1);

  printf("Sorted array: \n");
  for (int i = 0; i < arr_size; i++){
    printf("%d ", arr[i]);
  }
  printf("\n");

  return 0;
}
