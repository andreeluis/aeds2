#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
  char text[201];
} String;

String telefones[100000];


int main() {
  long int n;

  while(scanf("%li", &n) != EOF){
    int eco = 0;

    // ler todos os telefones
    for (int i = 0; i < n; i++) {
      scanf(" %s", telefones[i].text);
    }

    // ordenar todos os telefones em ordem alfabetica (bubble sort)
    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < n - i - 1; j++) {
    //     if (strcmp(telefones[j].text, telefones[j + 1].text) > 0) {
    //       String aux = telefones[j];
    //       telefones[j] = telefones[j + 1];
    //       telefones[j + 1] = aux;
    //     }
    //   }
    // }

    // ordenar todos os telefones em ordem alfabetica (qsort)
    qsort(telefones, n, sizeof(String), strcmp);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < strlen(telefones[i - 1].text); j++) {
        if (telefones[i - 1].text[j] == telefones[i].text[j])
          eco++;
        else
          break;
      }
    }

    printf("%d\n", eco);
  }

  return 0;
}
