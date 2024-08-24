#include <stdio.h>

int main() {
  int nota;

  scanf("%d", &nota);

  switch(nota) {
    case 0:
      printf("E\n");
      break;
    case 1 ... 35:
      printf("D\n");
      break;
    case 36 ... 60:
      printf("C\n");
      break;
    case 61 ... 85:
      printf("B\n");
      break;
    case 86 ... 100:
      printf("A\n");
      break;
    default:
      break;
  }

  return 0;
}
