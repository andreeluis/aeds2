#include <stdio.h>
#include <stdbool.h>
#include <string.h>

char* alterAleatoria(char* texto, int i)
{

  return texto;
}

char* alterAleat(char* texto)
{
  return alterAleatoria(texto, 0);
}

int main()
{
  char texto[1000];

  scanf(" %[^\n]", texto);

  while (strcmp(texto, "FIM"))
  {
    printf("%s", alterAleat(texto));

    scanf(" %[^\n]", texto);
  }

  return 0;
}