#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool ehPalindromo(char texto[])
{
  int tam = strlen(texto) - 1;

  for (int i = 0; i <= tam; i++)
  {
    if (texto[i] != texto[tam - i])
      return false;
  }

  return true;
}

int main()
{
  char texto[1000];

  scanf(" %[^\n]", texto);

  while (strcmp(texto, "FIM"))
  {
    if (ehPalindromo(texto))
      printf("SIM\n");
    else
      printf("NAO\n");

    scanf(" %[^\n]", texto);
  }

  return 0;
}