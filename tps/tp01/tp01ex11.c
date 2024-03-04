#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool palindromo(char texto[], int i)
{
  bool resp;
  int tam = strlen(texto);

  if (tam == i)
    resp = true;
  else if (texto[i] != texto[tam - 1 - i])
    resp = false;
  else
    resp = palindromo(texto, ++i);

  return resp;
}

bool ehPalindromo(char texto[])
{
  return palindromo(texto, 0);
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