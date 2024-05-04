#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

// String
// remove um caractere de uma string
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
typedef struct StringList
{
  char *string;
  struct StringList *next;
} StringList;

StringList *newStringList()
{
  StringList *list = (StringList *)malloc(sizeof(StringList));

  list->string = NULL;
  list->next = NULL;

  return list;
}

void addStringToList(StringList **head, char *string)
{
  if (*head == NULL)
  {
    // se a lista estiver vazia, cria o primeiro nó
    *head = newStringList();
    (*head)->string = string;
    (*head)->next = NULL;
  }
  else
  {
    // se a lista não estiver vazia, adiciona um novo nó no final
    StringList *current = *head;

    // percorre a lista até o último elemento
    while (current->next != NULL)
    {
      current = current->next;
    }

    // adiciona um novo nó no final
    current->next = newStringList();
    current->next->string = string;
  }
}

char *stringListToString(StringList *head)
{
  StringList *current = head->next; // pulando o primeiro elemento que é nulo

  // se a lista estiver vazia, retorna uma string vazia
  if (current == NULL)
  {
    return "";
  }

  char *str = (char *)malloc(150 * sizeof(char)); // aloca memória para 150 caracteres

  // current->next para ir até o penúltimo elemento
  while (current->next != NULL)
  {
    cleanString(current->string);
    strcat(str, current->string);
    strcat(str, ", ");

    current = current->next;
  }
  // último elemento
  cleanString(current->string);
  strcat(str, current->string);

  return str;
}

StringList *stringListFromString(char str[])
{
  StringList *list = newStringList();

  // Cria uma cópia da string de entrada
  char *strCopy = strdup(str);

  char *token = strCopy;
  while ((token = strsep(&strCopy, ",")) != NULL)
  {
    addStringToList(&list, token + 1);
  }

  // Libera a memória alocada para a cópia da string
  free(strCopy);

  return list;
}

// Date
typedef struct Date
{
  int dia;
  int mes;
  int ano;
} Date;

char *dateToString(Date date)
{
  char *str = (char *)malloc(sizeof(char));

  sprintf(str, "%02d-%02d-%04d", date.dia, date.mes, date.ano);

  return str;
}

Date stringToDate(char *str)
{
  Date date;

  if (strchr(str, '-') != NULL)
  {
    // Formato de data é "dd-mm-yyyy"
    sscanf(str, "%d-%d-%d", &date.dia, &date.mes, &date.ano);
  }
  else if (strchr(str, '/') != NULL)
  {
    // Formato de data é "dd/mm/yyyy"
    sscanf(str, "%d/%d/%d", &date.dia, &date.mes, &date.ano);
  }

  return date;
}
// Personagem
typedef struct Personagem
{
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
char *getId(Personagem *personagem)
{
  return personagem->id;
}

void setId(Personagem *personagem, char *id)
{
  personagem->id = strdup(id);
}

// name
char *getName(Personagem *personagem)
{
  return personagem->name;
}

void setName(Personagem *personagem, char *name)
{
  personagem->name = strdup(name);
}

// alternateNames
StringList *getAlternateNames(Personagem *personagem)
{
  return personagem->alternateNames;
}

void setAlternateNamesList(Personagem *personagem, StringList *alternateNames)
{
  personagem->alternateNames = alternateNames;
}


// house
char *getHouse(Personagem *personagem)
{
  return personagem->house;
}

void setHouse(Personagem *personagem, char *house)
{
  personagem->house = strdup(house);
}

// ancestry
char *getAncestry(Personagem *personagem)
{
  return personagem->ancestry;
}

void setAncestry(Personagem *personagem, char *ancestry)
{
  personagem->ancestry = strdup(ancestry);
}

// species
char *getSpecies(Personagem *personagem)
{
  return personagem->species;
}

void setSpecies(Personagem *personagem, char *species)
{
  personagem->species = strdup(species);
}

// patronus
char *getPatronus(Personagem *personagem)
{
  return personagem->patronus;
}

void setPatronus(Personagem *personagem, char *patronus)
{
  personagem->patronus = strdup(patronus);
}

// hogwartsStaff
bool getHogwartsStaff(Personagem *personagem)
{
  return personagem->hogwartsStaff;
}

void setHogwartsStaffBool(Personagem *personagem, bool hogwartsStaff)
{
  personagem->hogwartsStaff = hogwartsStaff;
}

void setHogwartsStaffString(Personagem *personagem, char *hogwartsStaff)
{
  personagem->hogwartsStaff = strcmp(hogwartsStaff, "VERDADEIRO") == 0;
}

// hogwartsStudent
bool getHogwartsStudent(Personagem *personagem)
{
  return personagem->hogwartsStudent;
}

void setHogwartsStudentBool(Personagem *personagem, bool hogwartsStudent)
{
  personagem->hogwartsStudent = hogwartsStudent;
}

void setHogwartsStudentString(Personagem *personagem, char *hogwartsStudent)
{
  personagem->hogwartsStudent = strcmp(hogwartsStudent, "VERDADEIRO") == 0;
}

// actorName
char *getActorName(Personagem *personagem)
{
  return personagem->actorName;
}

void setActorName(Personagem *personagem, char *actorName)
{
  personagem->actorName = strdup(actorName);
}

// alive
bool getAlive(Personagem *personagem)
{
  return personagem->alive;
}

void setAliveBool(Personagem *personagem, bool alive)
{
  personagem->alive = alive;
}

void setAliveString(Personagem *personagem, char *alive)
{
  personagem->alive = strcmp(alive, "VERDADEIRO") == 0;
}

// alternateActors
StringList *getAlternateActors(Personagem *personagem)
{
  return personagem->alternateActors;
}

void setAlternateActors(Personagem *personagem, StringList *alternateActors)
{
  personagem->alternateActors = alternateActors;
}

// dateOfBirth
Date getDateOfBirth(Personagem *personagem)
{
  return personagem->dateOfBirth;
}

void setDateOfBirthDate(Personagem *personagem, Date dateOfBirth)
{
  personagem->dateOfBirth = dateOfBirth;
}

void setDateOfBirthString(Personagem *personagem, char *dateOfBirth)
{
  personagem->dateOfBirth = stringToDate(dateOfBirth);
}

// yearOfBirth
int getYearOfBirth(Personagem *personagem)
{
  return personagem->yearOfBirth;
}

void setYearOfBirth(Personagem *personagem, int yearOfBirth)
{
  personagem->yearOfBirth = yearOfBirth;
}

// eyeColour
char *getEyeColour(Personagem *personagem)
{
  return personagem->eyeColour;
}

void setEyeColour(Personagem *personagem, char *eyeColour)
{
  personagem->eyeColour = strdup(eyeColour);
}

// gender
char *getGender(Personagem *personagem)
{
  return personagem->gender;
}

void setGender(Personagem *personagem, char *gender)
{
  personagem->gender = strdup(gender);
}

// hairColour
char *getHairColour(Personagem *personagem)
{
  return personagem->hairColour;
}

void setHairColour(Personagem *personagem, char *hairColour)
{
  personagem->hairColour = strdup(hairColour);
}

// wizard
bool getWizard(Personagem *personagem)
{
  return personagem->wizard;
}

void setWizardBool(Personagem *personagem, bool wizard)
{
  personagem->wizard = wizard;
}

void setWizardString(Personagem *personagem, char *wizard)
{
  personagem->wizard = strcmp(wizard, "VERDADEIRO") == 0;
}

int compareHairTo(Personagem *a, Personagem *b)
{
  return strcmp(a->hairColour, b->hairColour);
}

int compareNameTo(Personagem *a, Personagem *b)
{
  return strcmp(a->name, b->name);
}


Personagem novoPersonagem(
    char *id,
    char *name,
    StringList *alternateNames,
    char *house,
    char *ancestry,
    char *species,
    char *patronus,
    char *hogwartsStaff,
    char *hogwartsStudent,
    char *actorName,
    char *alive,
    StringList *alternateActors,
    char *dateOfBirth,
    int yearOfBirth,
    char *eyeColour,
    char *gender,
    char *hairColour,
    char *wizard)
{
  Personagem personagem;

  setId(&personagem, id);
  setName(&personagem, name);
  setAlternateNamesList(&personagem, alternateNames);
  setHouse(&personagem, house);
  setAncestry(&personagem, ancestry);
  setSpecies(&personagem, species);
  setPatronus(&personagem, patronus);
  setHogwartsStaffString(&personagem, hogwartsStaff);
  setHogwartsStudentString(&personagem, hogwartsStudent);
  setActorName(&personagem, actorName);
  setAliveString(&personagem, alive);
  setAlternateActors(&personagem, alternateActors);
  setDateOfBirthString(&personagem, dateOfBirth);
  setYearOfBirth(&personagem, yearOfBirth);
  setEyeColour(&personagem, eyeColour);
  setGender(&personagem, gender);
  setHairColour(&personagem, hairColour);
  setWizardString(&personagem, wizard);

  return personagem;
}

void imprimirPersonagem(Personagem *personagem)
{
  printf("[%s ## ", getId(personagem));
  printf("%s ## ", getName(personagem));
  printf("{%s} ## ", stringListToString(getAlternateNames(personagem)));
  printf("%s ## ", getHouse(personagem));
  printf("%s ## ", getAncestry(personagem));
  printf("%s ## ", getSpecies(personagem));
  printf("%s ## ", getPatronus(personagem));
  printf("%s ## ", getHogwartsStaff(personagem) ? "true" : "false");
  printf("%s ## ", getHogwartsStudent(personagem) ? "true" : "false");
  printf("%s ## ", getActorName(personagem));
  printf("%s ## ", getAlive(personagem) ? "true" : "false");
  printf("%s ## ", dateToString(getDateOfBirth(personagem)));
  printf("%d ## ", getYearOfBirth(personagem));
  printf("%s ## ", getEyeColour(personagem));
  printf("%s ## ", getGender(personagem));
  printf("%s ## ", getHairColour(personagem));
  printf("%s]\n", getWizard(personagem) ? "true" : "false");
}

void imprimirPersonagens(Personagem personagens[], int n)
{
  for (int i = 0; i < n; i++)
  {
    imprimirPersonagem(&personagens[i]);
  }
}

// Heap Sort Parcial - Hair Colour
void construir(Personagem personagens[], int tamHeap){
  for (int i = tamHeap; i > 1 && compareHairTo(&personagens[i], &personagens[i / 2]) > 0; i /= 2){
    Personagem tmp = personagens[i];
    personagens[i] = personagens[i/2];
    personagens[i/2] = tmp;
  }
}

int getMaiorFilho(Personagem personagens[], int i, int tamHeap){
  int filho;

  if (2 * i == tamHeap || compareHairTo(&personagens[2 * i], &personagens[2 * i + 1]) > 0){
    filho = 2*i;
  } else {
    filho = 2*i + 1;
  }

  return filho;
}

void reconstruir(Personagem personagens[], int tamHeap){
  int i = 1;

  while(i <= (tamHeap / 2)){
    int filho = getMaiorFilho(personagens, i, tamHeap);
    if(compareHairTo(&personagens[i], &personagens[filho]) > 0) {
      Personagem tmp = personagens[i];
      personagens[i] = personagens[filho];
      personagens[filho] = tmp;

      i = filho;
    } else {
      i = tamHeap;
    }
  }
}

void heapSort(Personagem personagens[], int n) {
  //Alterar o vetor ignorando a posicao zero
  Personagem personagensTmp[n + 1];

  for(int i = 0; i < n; i++){
    personagensTmp[i + 1] = personagens[i];
  }

  //Contrucao do heap
  for(int tamHeap = 2; tamHeap <= n; tamHeap++){
    construir(personagensTmp, tamHeap);
  }

  //Ordenacao propriamente dita
  int tamHeap = n;
  while(tamHeap > 1){
    Personagem tmp = personagensTmp[1];
    personagensTmp[1] = personagensTmp[tamHeap + 1];
    personagensTmp[tamHeap + 1] = tmp;
    tamHeap--;

    reconstruir(personagensTmp, tamHeap);
  }

  //Alterar o vetor para voltar a posicao zero
  for(int i = 0; i < n; i++){
    personagens[i] = personagensTmp[i+1];
  }
}



int main()
{
  // LER CSV
  char *path = "/tmp/characters.csv";
  FILE *file = fopen(path, "r");

  Personagem personagens[404];
  int n = 0;

  char line[300];
  fgets(line, sizeof(line), file); // Ignora a primeira linha de cabeçalho
  while (fgets(line, sizeof(line), file) != NULL)
  {
    char *token = line;
    char bufferName[150];
    char bufferActor[150];

    char *id = strsep(&token, ";");
    char *name = strsep(&token, ";");

    strcpy(bufferName, strsep(&token, ";"));
    StringList *alternateNames = stringListFromString(bufferName);

    char *house = strsep(&token, ";");
    char *ancestry = strsep(&token, ";");
    char *species = strsep(&token, ";");
    char *patronus = strsep(&token, ";");
    char *hogwartsStaff = strsep(&token, ";");
    char *hogwartsStudent = strsep(&token, ";");
    char *actorName = strsep(&token, ";");
    char *alive = strsep(&token, ";");

    strcpy(bufferActor, strsep(&token, ";"));
    StringList *alternateActors = stringListFromString(bufferActor);

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

    personagens[n] = personagem;

    n++;
  }
  fclose(file);

  Personagem pSelecionados[50];
  int tam = 0;
  char id[36];
  scanf("%s", id);
  while (strcmp(id, "FIM"))
  {
    // Buscar personagem pelo id
    for (int i = 0; i < n; i++)
    {
      if (strcmp(id, personagens[i].id) == 0)
      {
        pSelecionados[tam++] = personagens[i];
        break;
      }
    }

    scanf("%s", id);
  }

  heapSort(pSelecionados, tam);
  imprimirPersonagens(pSelecionados, tam);

  return 0;
}
