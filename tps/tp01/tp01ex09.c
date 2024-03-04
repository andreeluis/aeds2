#include <stdio.h>

int main() {
  FILE *file = fopen("file.txt", "wb");
  int qtde, numInt;
  float num;

  scanf("%d", &qtde);

  for (int i = 0; i < qtde; i++) {
    scanf("%f", &num);
    fwrite(&num, sizeof(float), 1, file);
  }

  fclose(file);

  file = fopen("file.txt", "rb");

  // ponteiro no final do arquivo
  fseek(file, 0, SEEK_END);

  for (int i = qtde - 1; i >= 0; i--) {
    // move o ponteiro para tras
    fseek(file, i * sizeof(float), SEEK_SET);

    fread(&num, sizeof(float), 1, file);

    numInt = (int)num;

    if (numInt - num == 0)
      printf("%d\n", numInt);
    else
      printf("%g\n", num);
  }

  fclose(file);

  return 0;
}