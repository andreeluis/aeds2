#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
  char letter;
  Node *next;
} Node;

Node *newNode(char letter) {
  Node *new = malloc(sizeof(Node));
  new->letter = letter;
  new->next = NULL;

  return new;
}

void insertNode(Node **head, char letter) {
  Node *new = newNode(letter);

  if (*head == NULL) {
    *head = new;
  } else {
    Node *tmp = *head;

    while (tmp->next != NULL) {
      tmp = tmp->next;
    }

    tmp->next = new;
  }
}

int main() {
  char texto[100000];

  while (scanf("%s", texto) != EOF) {
    Node *result = NULL;
    Node *aux = NULL;

    for (int i = 0; i < strlen(texto); i++) {
    


    }
  }

  return 0;
}
