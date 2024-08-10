#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

// String remove um caractere de uma string
void cleanString(char *str) {
	char garbage[] = {'\'', '[', ']'};
	int garbageSize = sizeof(garbage) / sizeof(garbage[0]);
	int index = 0;

	for (int i = 0; str[i]; i++) {
		int isGarbage = 0;
		for (int j = 0; j < garbageSize; j++) {
			if (str[i] == garbage[j]) {
				isGarbage = 1;
				break;
			}
		}
		if (!isGarbage) {
			str[index++] = str[i];
		}
	}

	str[index] = '\0';
}

// StringList
typedef struct Node {
	char *string;
	struct Node *next;
} Node;

typedef struct StringList {
	Node *head;
	int tam;
} StringList;


StringList *newStringList() {
	StringList *list = malloc(sizeof(StringList*));

	list->head = malloc(sizeof(Node*));
	list->tam = 0;

	return list;
}

void addStringToList(StringList *list, char *string) {
	Node *curr;
	for (curr = list->head; curr->next != NULL; curr = curr->next);

	curr->next = malloc(sizeof(Node*));
	curr->next->string = string;

	list->tam++;
}

char *stringListToString(StringList *list) {
	if (list->tam < 1)
		return "";

	char *str = calloc(150, sizeof(char*));

	// até o penúltimo elemento
	Node *curr;
	for (curr = list->head->next; curr->next != NULL; curr = curr->next) {
		cleanString(curr->string);
		strcat(str, curr->string);
		strcat(str, ", ");
	}

	// último elemento
	cleanString(curr->string);
	strcat(str, curr->string);

	return str;
}


StringList *stringListFromString(char str[]) {
	StringList *list = newStringList();

	// Cria uma cópia da string de entrada
	char *strCopy = strdup(str);

	char *token = strCopy;
	while ((token = strsep(&strCopy, ",")) != NULL) {
		addStringToList(list, token + 1);
	}

	return list;
}

// Date
typedef struct Date {
	int dia;
	int mes;
	int ano;
} Date;

char *dateToString(Date date) {
	char *str = (char *)malloc(sizeof(char));

	sprintf(str, "%02d-%02d-%04d", date.dia, date.mes, date.ano);

	return str;
}

Date stringToDate(char *str) {
	Date date;

	if (strchr(str, '-') != NULL) {
		// Formato de data é "dd-mm-yyyy"
		sscanf(str, "%d-%d-%d", &date.dia, &date.mes, &date.ano);
	}	else if (strchr(str, '/') != NULL) {
		// Formato de data é "dd/mm/yyyy"
		sscanf(str, "%d/%d/%d", &date.dia, &date.mes, &date.ano);
	}

	return date;
}
// Personagem
typedef struct Personagem {
	char *id;
	char *name;
	StringList *alternateNames;
	char *house;
	char *ancestry;
	char *species;
	char *patronus;
	bool hogwartsStaff;
	bool hogwartsStudent;
	char *actorName;
	bool alive;
	StringList *alternateActors;
	Date dateOfBirth;
	int yearOfBirth;
	char *eyeColour;
	char *gender;
	char *hairColour;
	bool wizard;
} Personagem;

// id
char *getId(Personagem *personagem) {
	return personagem->id;
}

void setId(Personagem *personagem, char *id) {
	personagem->id = strdup(id);
}

// name
char *getName(Personagem *personagem) {
	return personagem->name;
}

void setName(Personagem *personagem, char *name) {
	personagem->name = strdup(name);
}

// alternateNames
char *getAlternateNames(Personagem *personagem) {
	return stringListToString(personagem->alternateNames);
}

void setAlternateNames(Personagem *personagem, StringList *alternateNames) {
	personagem->alternateNames = alternateNames;
}

// house
char *getHouse(Personagem *personagem) {
	return personagem->house;
}

void setHouse(Personagem *personagem, char *house) {
	personagem->house = strdup(house);
}

// ancestry
char *getAncestry(Personagem *personagem) {
	return personagem->ancestry;
}

void setAncestry(Personagem *personagem, char *ancestry) {
	personagem->ancestry = strdup(ancestry);
}

// species
char *getSpecies(Personagem *personagem) {
	return personagem->species;
}

void setSpecies(Personagem *personagem, char *species) {
	personagem->species = strdup(species);
}

// patronus
char *getPatronus(Personagem *personagem) {
	return personagem->patronus;
}

void setPatronus(Personagem *personagem, char *patronus) {
	personagem->patronus = strdup(patronus);
}

// hogwartsStaff
bool getHogwartsStaff(Personagem *personagem) {
	return personagem->hogwartsStaff;
}

void setHogwartsStaffBool(Personagem *personagem, bool hogwartsStaff) {
	personagem->hogwartsStaff = hogwartsStaff;
}

void setHogwartsStaffString(Personagem *personagem, char *hogwartsStaff) {
	personagem->hogwartsStaff = strcmp(hogwartsStaff, "VERDADEIRO") == 0;
}

// hogwartsStudent
bool getHogwartsStudent(Personagem *personagem) {
	return personagem->hogwartsStudent;
}

void setHogwartsStudentBool(Personagem *personagem, bool hogwartsStudent) {
	personagem->hogwartsStudent = hogwartsStudent;
}

void setHogwartsStudentString(Personagem *personagem, char *hogwartsStudent) {
	personagem->hogwartsStudent = strcmp(hogwartsStudent, "VERDADEIRO") == 0;
}

// actorName
char *getActorName(Personagem *personagem) {
	return personagem->actorName;
}

void setActorName(Personagem *personagem, char *actorName) {
	personagem->actorName = strdup(actorName);
}

// alive
bool getAlive(Personagem *personagem) {
	return personagem->alive;
}

void setAliveBool(Personagem *personagem, bool alive) {
	personagem->alive = alive;
}

void setAliveString(Personagem *personagem, char *alive) {
	personagem->alive = strcmp(alive, "VERDADEIRO") == 0;
}

// alternateActors
StringList *getAlternateActors(Personagem *personagem) {
	return personagem->alternateActors;
}

void setAlternateActors(Personagem *personagem, StringList *alternateActors) {
	personagem->alternateActors = alternateActors;
}

// dateOfBirth
char *getDateOfBirth(Personagem *personagem) {
	return dateToString(personagem->dateOfBirth);
}

void setDateOfBirthDate(Personagem *personagem, Date dateOfBirth) {
	personagem->dateOfBirth = dateOfBirth;
}

void setDateOfBirthString(Personagem *personagem, char *dateOfBirth) {
	personagem->dateOfBirth = stringToDate(dateOfBirth);
}

// yearOfBirth
int getYearOfBirth(Personagem *personagem) {
	return personagem->yearOfBirth;
}

void setYearOfBirth(Personagem *personagem, int yearOfBirth) {
	personagem->yearOfBirth = yearOfBirth;
}

// eyeColour
char *getEyeColour(Personagem *personagem) {
	return personagem->eyeColour;
}

void setEyeColour(Personagem *personagem, char *eyeColour) {
	personagem->eyeColour = strdup(eyeColour);
}

// gender
char *getGender(Personagem *personagem) {
	return personagem->gender;
}

void setGender(Personagem *personagem, char *gender) {
	personagem->gender = strdup(gender);
}

// hairColour
char *getHairColour(Personagem *personagem) {
	return personagem->hairColour;
}

void setHairColour(Personagem *personagem, char *hairColour) {
	personagem->hairColour = strdup(hairColour);
}

// wizard
bool getWizard(Personagem *personagem) {
	return personagem->wizard;
}

void setWizardBool(Personagem *personagem, bool wizard) {
	personagem->wizard = wizard;
}

void setWizardString(Personagem *personagem, char *wizard) {
	personagem->wizard = strcmp(wizard, "VERDADEIRO") == 0;
}

Personagem novoPersonagem(char *id, char *name, char *alternateNames, char *house, char *ancestry, char *species, char *patronus, char *hogwartsStaff, char *hogwartsStudent, char *actorName, char *alive, char *alternateActors, char *dateOfBirth, int yearOfBirth, char *eyeColour, char *gender, char *hairColour, char *wizard) {
	Personagem *personagem = malloc(sizeof(Personagem));

	setId(personagem, id);
	setName(personagem, name);
	setAlternateNames(personagem, stringListFromString(alternateNames));
	setHouse(personagem, house);
	setAncestry(personagem, ancestry);
	setSpecies(personagem, species);
	setPatronus(personagem, patronus);
	setHogwartsStaffString(personagem, hogwartsStaff);
	setHogwartsStudentString(personagem, hogwartsStudent);
	setActorName(personagem, actorName);
	setAliveString(personagem, alive);
	//setAlternateActors(personagem, alternateActors);
	setDateOfBirthString(personagem, dateOfBirth);
	setYearOfBirth(personagem, yearOfBirth);
	setEyeColour(personagem, eyeColour);
	setGender(personagem, gender);
	setHairColour(personagem, hairColour);
	setWizardString(personagem, wizard);

	return *personagem;
}

void imprimirPersonagem(Personagem *personagem) {
	printf("[%s ## ", getId(personagem));
	printf("%s ## ", getName(personagem));
	printf("{%s} ## ", getAlternateNames(personagem));
	printf("%s ## ", getHouse(personagem));
	printf("%s ## ", getAncestry(personagem));
	printf("%s ## ", getSpecies(personagem));
	printf("%s ## ", getPatronus(personagem));
	printf("%s ## ", getHogwartsStaff(personagem) ? "true" : "false");
	printf("%s ## ", getHogwartsStudent(personagem) ? "true" : "false");
	printf("%s ## ", getActorName(personagem));
	printf("%s ## ", getAlive(personagem) ? "true" : "false");
	printf("%s ## ", getDateOfBirth(personagem));
	printf("%d ## ", getYearOfBirth(personagem));
	printf("%s ## ", getEyeColour(personagem));
	printf("%s ## ", getGender(personagem));
	printf("%s ## ", getHairColour(personagem));
	printf("%s]\n", getWizard(personagem) ? "true" : "false");
}

int lerArquivo(char *path, Personagem *personagens) {
	FILE *file = fopen(path, "r");

	int n = 0;

	char line[300];
	fgets(line, sizeof(line), file);
	while (fgets(line, sizeof(line), file) != NULL) {
		char *token = line;

		char *id = strsep(&token, ";");
		char *name = strsep(&token, ";");
		char *alternateNames = strsep(&token, ";");
		char *house = strsep(&token, ";");
		char *ancestry = strsep(&token, ";");
		char *species = strsep(&token, ";");
		char *patronus = strsep(&token, ";");
		char *hogwartsStaff = strsep(&token, ";");
		char *hogwartsStudent = strsep(&token, ";");
		char *actorName = strsep(&token, ";");
		char *alive = strsep(&token, ";");
		char *alternateActors = strsep(&token, ";");
		char *dateOfBirth = strsep(&token, ";");
		int yearOfBirth = atoi(strsep(&token, ";"));
		char *eyeColour = strsep(&token, ";");
		char *gender = strsep(&token, ";");
		char *hairColour = strsep(&token, ";");
		char *wizard = strsep(&token, ";\r\n");

		Personagem personagem = novoPersonagem(
			id,
			name,
			alternateNames,
			house,
			ancestry,
			species,
			patronus,
			hogwartsStaff,
			hogwartsStudent,
			actorName,
			alive,
			alternateNames,
			dateOfBirth,
			yearOfBirth,
			eyeColour,
			gender,
			hairColour,
			wizard
		);

		personagens[n++] = personagem;
	}
	fclose(file);

	return n;
}

Personagem* buscarPersonagem(char *id, Personagem *personagens, int qtde) {
	for (int i = 0; i < qtde; i++) {
		if (strcmp(id, personagens[i].id) == 0)
			return &personagens[i];
	}
}

int compare(Personagem *p1, Personagem *p2) {
  int houseDiff = strcmp(getHouse(p1), getHouse(p2));
  int nameDiff = strcmp(getName(p1), getName(p2));

  if (houseDiff != 0)
    return houseDiff;
  else
    return nameDiff;
}

// Lista sequencial de personagens
#define MAX 5

typedef struct Celula {
  Personagem *personagem;
  struct Celula *prox;
  struct Celula *ant;
} Celula;

typedef struct Lista {
	Celula *pri;
  Celula *ult;
  int n;
} Lista;

Lista newLista() {
	Lista lista;
  lista.n = 0;

	lista.pri = lista.ult = malloc(sizeof(Celula));

  return lista;
}

void imprimirLista(Lista *lista) {
  for (Celula *i = lista->pri->prox; i != NULL; i = i->prox) {
    imprimirPersonagem(i->personagem);
  }
}

void inserirFim(Lista *lista, Personagem *personagem) {
  Celula *nova = malloc(sizeof(Celula));
  nova->personagem = personagem;
	nova->prox = NULL;
  nova->ant = NULL;

  lista->ult->prox = nova;
  lista->ult->prox->ant = lista->ult;
  lista->ult = lista->ult->prox;

  lista->n++;
}

// utils Lista
void swap(Lista *lista, int a, int b) {
  Celula *aCurr = lista->pri->prox;
  for (int i = 0; i < a; i++, aCurr = aCurr->prox);

  Celula *bCurr = lista->pri->prox;
  for (int i = 0; i < b; i++, bCurr = bCurr->prox);

  Personagem *aux = aCurr->personagem;
  aCurr->personagem = bCurr->personagem;
  bCurr->personagem = aux;
}

Personagem *getPersonagem(Lista *lista, int pos) {
  Celula *curr = lista->pri->prox;
  for (int i = 0; i < pos; i++, curr = curr->prox);

  return curr->personagem;
}

void quickSort(Lista *lista, int left, int right) {
  int i = left;
  int j = right;
  Personagem *pivot = getPersonagem(lista, i);

  while (i <= j) {
    while (compare(getPersonagem(lista, i), pivot) < 0) {
      i++;
    }

    while (compare(getPersonagem(lista, j), pivot) > 0) {
      j--;
    }

    if (i <= j) {
      swap(lista, i, j);
      i++;
      j--;
    }
  }

  if (left < j)
    quickSort(lista, left, j);
  if (i < right)
    quickSort(lista, i, right);
}

void quicksort(Lista *lista) {
  quickSort(lista, 0, lista->n - 1);
}

int main() {
	// LER CSV
	Personagem personagens[404];

	int tot = lerArquivo("/tmp/characters.csv", personagens);

	Lista listaPersonagens = newLista();

	char id[36];
	scanf("%s", id);
	while (strcmp(id, "FIM")) {
		// Busca personagem pelo id e insere no fim da lista
		inserirFim(&listaPersonagens, buscarPersonagem(id, personagens, tot));

		scanf("%s", id);
	}

  quicksort(&listaPersonagens);
  imprimirLista(&listaPersonagens);

	return 0;
}
