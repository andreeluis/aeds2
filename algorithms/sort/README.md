# Sort Algorithms

## [Selection Sort](selection)
### Complexity
- **Time**:
  - Best: `O(n²)`
  - Worst: `O(n²)`
- **Space**: `O(1)` (in-place)

### Description
The algorithm repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it with the first element of the unsorted part. This process is repeated for the remaining unsorted portion until the entire list is sorted. Selection sort is an <ins>in-place</ins> comparison sort algorithm and is <ins>not stable</ins>.

### Code
```c
void selectionSort(int arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    int min = i;

    // find the index of the minimum element
    for (int j = i + 1; j < n; j++) {
      if (arr[j] < arr[min])
        min = j;
    }
    // swap
    if (min != i) {
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }
}
```

## [Insertion Sort](insertion)
### Complexity
- **Time**:
  - Best: `O(n)`
  - Worst: `O(n²)`
- **Space**: `O(1)` (in-place)

### Description
The algorithm builds the final sorted list one element at a time. It takes each element from the unsorted portion and inserts it into its correct position in the sorted portion. Insertion sort is an <ins>in-place</ins> comparison sort algorithm and is <ins>stable</ins>.

### Code
```c
void insertionSort(int arr[], int n) {
  for (int i = 1; i < n; i++) {
    int tmp = arr[i];
    int j = i - 1;

    // find the correct position to insert the tmp element
    while ((j >= 0) && (arr[j] > tmp)) {
      arr[j + 1] = arr[j];
      j--;
    }

    arr[j + 1] = tmp;
  }
}
```

## [Bubble Sort](bubble)
### Complexity
- **Time**:
  - Best: `O(n)`
  - Worst: `O(n²)`
- **Space**: `O(1)` (in-place)

### Description
The algorithm repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. Bubble sort is an <ins>in-place</ins> comparison sort algorithm and is <ins>stable</ins>.

### Code
```c
void bubbleSort(int arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = tmp;
      }
    }
  }
}
```

## [Merge Sort](merge)
### Complexity
- **Time**:
  - Best: `O(n log n)`
  - Worst: `O(n log n)`
- **Space**: `O(n)` (not in-place)

### Description
The algorithm divides the list into two halves, recursively sorts the two halves, and then merges the sorted halves. Merge sort is a <ins>stable</ins> comparison sort algorithm. It is also a <ins>divide and conquer</ins> algorithm.

### Code
```c
void mergeSort(int arr[], int left, int right) {
  if (left < right) {
    int mid = (left + right) / 2;

    // divide the list into two halves
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    // merge the two halves
    merge(arr, left, mid, right);
  }
}

void merge(int arr[], int left, int mid, int right) {
  // n is the length of subarray
  int n1 = mid - left + 1;
  int n2 = right - mid;

  // create both subarray
  int L[n1], R[n2];

  // first half
  for (int i = 0; i < n1; i++) {
    L[i] = arr[left + i];
  }

  // second half
  for (int j = 0; j < n2; j++) {
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
```

## [Quick Sort](quick)
### Complexity
- **Time**:
  - Best: `O(n log n)`
  - Worst: `O(n²)`
- **Space**: `O(log n)` (not in-place)

### Description
The algorithm picks an element as a pivot and partitions the array around the pivot. The pivot is placed in its correct position in the sorted array, and the array is divided into two subarrays. The process is repeated for the two subarrays. Quick sort is an <ins>in-place</ins> comparison sort algorithm and is <ins>not stable</ins>. It is also a <ins>divide and conquer</ins> algorithm. The choice of the pivot element can affect the performance of the algorithm.

### Code
```c
void quickSort(int arr[], int left, int right) {
  int i = left, j = right;
  int pivot = arr[(right + left) / 2];

  while (i <= j) {
    while (arr[i] < pivot) i++;
    while (arr[j] > pivot) j--;

    if (i <= j) {
      // swap
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;

      i++;
      j--;
    }
  }

  if (left < j)
    quickSort(arr, left, j);
  if (i < right)
    quickSort(arr, i, right);
}
```

## [Heap Sort](heap)
### Complexity
- **Time**:
  - Best: `O(n log n)`
  - Worst: `O(n log n)`
- **Space**: `O(1)` (in-place)

### Description
The algorithm builds a max heap from the input array and repeatedly extracts the maximum element from the heap and places it at the end of the array. The heap is then reduced in size, and the process is repeated until the entire array is sorted. Heap sort is an <ins>in-place</ins> comparison sort algorithm and is <ins>not stable</ins>.

### Code
```c
void heapSort(int arr[], int n) {
  // Aux array to start at index 1
  int auxArr[n + 1];
  for (int i = 0; i < n; i++) {
    auxArr[i + 1] = arr[i];
  }

  // Build the heap
  for (int heapSize = 2; heapSize <= n; heapSize++) {
    for (int i = heapSize; i > 1 && auxArr[i] > auxArr[i / 2]; i /= 2) {
      // swap
      int tmp = auxArr[i];
      auxArr[i] = auxArr[i / 2];
      auxArr[i / 2] = tmp;
    }
  }

  // Sort the heap
  int heapSize = n;
  while (heapSize > 1) {
    // swap
    int tmp = auxArr[1];
    auxArr[1] = auxArr[heapSize];
    auxArr[heapSize] = tmp;

    heapSize--;

    // rebuild the heap
    int i = 1;
    while (i <= heapSize / 2) {
      // get the largest child
      int child;
      if (2 * i == heapSize || arr[2 * i] > arr[2 * i + 1])
        child = 2 * i;
      else
        child = 2 * i + 1;

      if (auxArr[i] < auxArr[child]) {
        // swap
        int tmp = auxArr[i];
        auxArr[i] = auxArr[child];
        auxArr[child] = tmp;
      } else {
        i = heapSize;
      }
    }
  }

  // Back to the original array (starting at index 0)
  for (int i = 0; i < n; i++) {
    arr[i] = auxArr[i + 1];
  }
}
```
