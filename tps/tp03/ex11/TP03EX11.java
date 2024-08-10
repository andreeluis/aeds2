import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Personagem {
  private String id;
  private String name;
  private ArrayList<String> alternateNames;
  private String house;
  private String ancestry;
  private String species;
  private String patronus;
  private boolean hogwartsStaff;
  private boolean hogwartsStudent;
  private String actorName;
  private boolean alive;
  private ArrayList<String> alternateActors;
  private LocalDate dateOfBirth;
  private int yearOfBirth;
  private String eyeColour;
  private String gender;
  private String hairColour;
  private boolean wizard;

  public Personagem() { }

  public Personagem(String id,
  String name,
  ArrayList<String> alternateNames,
  String house,
  String ancestry,
  String species,
  String patronus,
  boolean hogwartsStaff,
  String hogwartsStudent,
  String actorName,
  boolean alive,
  ArrayList<String> alternateActors,
  LocalDate dateOfBirth,
  int yearOfBirth,
  String eyeColour,
  String gender,
  String hairColour,
  boolean wizard) {
    setId(id);
    setName(name);
    setAlternateNames(alternateNames);
    setHouse(house);
    setAncestry(ancestry);
    setSpecies(species);
    setPatronus(patronus);
    setHogwartsStaff(hogwartsStaff);
    setHogwartsStudent(hogwartsStudent);
    setActorName(actorName);
    setAlive(alive);
    setAlternateActors(alternateActors);
    setDateOfBirth(dateOfBirth);
    setYearOfBirth(yearOfBirth);
    setEyeColour(eyeColour);
    setGender(gender);
    setHairColour(hairColour);
    setWizard(wizard);
  }

  public Personagem(String csvLine) {
    String[] values = csvLine.split(";");

    setId(values[0]);
    setName(values[1]);
    setAlternateNames(values[2]);
    setHouse(values[3]);
    setAncestry(values[4]);
    setSpecies(values[5]);
    setPatronus(values[6]);
    setHogwartsStaff(values[7]);
    setHogwartsStudent(values[8]);
    setActorName(values[9]);
    setAlive(values[10]);
    setAlternateActors(values[11]);
    setDateOfBirth(values[12]);
    setYearOfBirth(Integer.parseInt(values[13]));
    setEyeColour(values[14]);
    setGender(values[15]);
    setHairColour(values[16]);
    setWizard(values[17]);
  }

  // id
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  // name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // alternateNames
  public ArrayList<String> getAlternateNames() {
    return alternateNames;
  }

  public void setAlternateNames(ArrayList<String> alternateNames) {
    this.alternateNames = alternateNames;
  }

  public void setAlternateNames(String alternateNames) {
    this.alternateNames = new ArrayList<String>(
      Arrays.asList( alternateNames
        .replaceAll("\\[|\\]|'", "") // remove [ ] '
        .split(", ")
      )
    );
  }

  // house
  public String getHouse() {
    return house;
  }

  public void setHouse(String house) {
    this.house = house;
  }

  // ancestry
  public String getAncestry() {
    return ancestry;
  }

  public void setAncestry(String ancestry) {
    this.ancestry = ancestry;
  }

  // species
  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  // patronus
  public String getPatronus() {
    return patronus;
  }

  public void setPatronus(String patronus) {
    this.patronus = patronus;
  }

  // hogwartsStaff
  public boolean isHogwartsStaff() {
    return hogwartsStaff;
  }

  public void setHogwartsStaff(boolean hogwartsStaff) {
    this.hogwartsStaff = hogwartsStaff;
  }

  public void setHogwartsStaff(String hogwartsStaff) {
    this.hogwartsStaff = hogwartsStaff.equals("VERDADEIRO");
  }

  // hogwartsStudent
  public boolean getHogwartsStudent() {
    return hogwartsStudent;
  }

  public void setHogwartsStudent(boolean hogwartsStudent) {
    this.hogwartsStudent = hogwartsStudent;
  }

  public void setHogwartsStudent(String hogwartsStudent) {
    this.hogwartsStudent = hogwartsStudent.equals("VERDADEIRO");
  }

  // actorName
  public String getActorName() {
    return actorName;
  }

  public void setActorName(String actorName) {
    this.actorName = actorName;
  }

  // alive
  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public void setAlive(String alive) {
    this.alive = alive.equals("VERDADEIRO");
  }

  // alternateActors
  public ArrayList<String> getAlternateActors() {
    return alternateActors;
  }

  public void setAlternateActors(ArrayList<String> alternateActors) {
    this.alternateActors = alternateActors;
  }

  public void setAlternateActors(String alternateActors) {
    this.alternateActors = new ArrayList<String>(
      Arrays.asList( alternateActors
        .replaceAll("\\[|\\]|'", "") // remove [ ] '
        .split(", ")
      )
    );
  }

  // dateOfBirth
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    DateTimeFormatter[] formatters = new DateTimeFormatter[] {
      DateTimeFormatter.ofPattern("dd/MM/yyyy"),
      DateTimeFormatter.ofPattern("dd-MM-yyyy"),
      DateTimeFormatter.ofPattern("d-M-yyyy")
    };

    for (DateTimeFormatter formatter : formatters) {
      try {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        return;
      } catch (Exception e) { }
    }
  }

  // yearOfBirth
  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  // eyeColour
  public String getEyeColour() {
    return eyeColour;
  }

  public void setEyeColour(String eyeColour) {
    this.eyeColour = eyeColour;
  }

  // gender
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  // hairColour
  public String getHairColour() {
    return hairColour;
  }

  public void setHairColour(String hairColour) {
    this.hairColour = hairColour;
  }

  // wizard
  public boolean isWizard() {
    return wizard;
  }

  public void setWizard(boolean wizard) {
    this.wizard = wizard;
  }

  public void setWizard(String wizard) {
    this.wizard = wizard.equals("VERDADEIRO") ? true : false;
  }

  @Override
  public String toString() {
    StringBuilder stringB = new StringBuilder();

    stringB.append("[" + getId() + " ## ");
    stringB.append(getName() + " ## ");
    stringB.append("{" + String.join(", ", getAlternateNames()) + "}" + " ## ");
    stringB.append(getHouse() + " ## ");
    stringB.append(getAncestry() + " ## ");
    stringB.append(getSpecies() + " ## ");
    stringB.append(getPatronus() + " ## ");
    stringB.append(isHogwartsStaff() + " ## ");
    stringB.append(getHogwartsStudent() + " ## ");
    stringB.append(getActorName() + " ## ");
    stringB.append(isAlive() + " ## ");
    stringB.append(getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ## ");
    stringB.append(getYearOfBirth() + " ## ");
    stringB.append(getEyeColour() + " ## ");
    stringB.append(getGender() + " ## ");
    stringB.append(getHairColour() + " ## ");
    stringB.append(isWizard() + "]");

    return stringB.toString();
  }

  public String toString(int id) {
    StringBuilder stringB = new StringBuilder();

    stringB.append("[" + id + " ## ");
    stringB.append(getId() + " ## ");
    stringB.append(getName() + " ## ");
    stringB.append("{" + String.join(", ", getAlternateNames()) + "}" + " ## ");
    stringB.append(getHouse() + " ## ");
    stringB.append(getAncestry() + " ## ");
    stringB.append(getSpecies() + " ## ");
    stringB.append(getPatronus() + " ## ");
    stringB.append(isHogwartsStaff() + " ## ");
    stringB.append(getHogwartsStudent() + " ## ");
    stringB.append(getActorName() + " ## ");
    stringB.append(isAlive() + " ## ");
    stringB.append(getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ## ");
    stringB.append(getYearOfBirth() + " ## ");
    stringB.append(getEyeColour() + " ## ");
    stringB.append(getGender() + " ## ");
    stringB.append(getHairColour() + " ## ");
    stringB.append(isWizard() + "]");

    return stringB.toString();
  }

  public int compareTo(Personagem p) {
    int houseDiff = this.getHouse().compareTo(p.getHouse());
    int nameDiff = this.getName().compareTo(p.getName());

    if (houseDiff != 0)
      return houseDiff;
    else
      return nameDiff;
  }
}

class Celula {
  Personagem personagem;
  Celula next;
  Celula prev;

  public Celula() {
    this.personagem = null;
    this.next = null;
    this.prev = null;
  }

  public Celula(Personagem personagem) {
    this.personagem = personagem;
    this.next = null;
    this.prev = null;
  }
}

class Lista {
  Celula head;
  Celula tail;
  int tam;

  public Lista() {
    this.head = this.tail = new Celula();
    tam = 0;
  }

  public void inserirInicio(Personagem personagem) {
    Celula aux = new Celula(personagem);
    aux.prev = head;
    aux.next = head.next;
    head.next = aux;

    if (head == tail)
      tail = aux;
    else
      aux.next.prev = aux;

    aux = null;
    tam++;
  }

  public void inserir(Personagem personagem, int pos) {
    if (pos < 0 || pos > tam) {
      return;
    } else if (pos == 0) {
      inserirInicio(personagem);
    } else if (pos == tam) {
      inserirFim(personagem);
    } else {
      Celula current = head.next;
      for (int i = 1; i < pos; i++, current = current.next);

      Celula aux = new Celula(personagem);
      aux.prev = current;
      aux.next = current.next;
      aux.prev.next = aux.next.prev = aux;

      aux = current = null;

      tam++;
    }
  }

  public void inserirFim(Personagem personagem) {
    tail.next = new Celula(personagem);
    tail.next.prev = tail;
    tail = tail.next;

    tam++;
  }

  public Personagem removerInicio() {
    if (head == tail)
      return null;

    Celula aux = head.next;
    head.next = aux.next;
    head.next.prev = head;

    tam--;
    return aux.personagem;
  }

  public Personagem remover(int pos) {
    if (head == tail || pos < 0 || pos >= tam) {
      return null;
    } else if (pos == 0) {
      return removerInicio();
    } else if (pos == tam - 1) {
      return removerFim();
    } else {
      Celula current = head.next;
      for (int i = 0; i < pos; i++, current = current.next);

      current.prev.next = current.next;
      current.next.prev = current.prev;

      tam--;
      return current.personagem;
    }
  }

  public Personagem removerFim() {
    if (head == tail)
      return null;

    Celula aux = tail;
    tail = tail.prev;
    tail.next.prev = tail.next = null;

    tam--;
    return aux.personagem;
  }

  // utils
  public void imprimir() {
    for (Celula i = head.next; i != null; i = i.next) {
      System.out.println(i.personagem);
    }
  }

  private Personagem getPersonagem(int pos) {
    Celula current = head.next;
    for (int i = 0; i < pos; i++, current = current.next);

    return current.personagem;
  }

  private void swap(int a, int b) {
    Celula aCurrent = head.next;
    for (int i = 0; i < a; i++, aCurrent = aCurrent.next);

    Celula bCurrent = head.next;
    for (int i = 0; i < b; i++, bCurrent = bCurrent.next);

    Personagem aux = aCurrent.personagem;
    aCurrent.personagem = bCurrent.personagem;
    bCurrent.personagem = aux;
  }

  // sort
  public void quickSort() {
    quickSort(0, tam - 1);
  }

  private void quickSort(int left, int right) {
    int i = left;
    int j = right;
    Personagem pivot = getPersonagem(i);

    while (i <= j) {
      while (getPersonagem(i).compareTo(pivot) < 0) {
        i++;
      }

      while (getPersonagem(j).compareTo(pivot) > 0) {
        j--;
      }

      if (i <= j) {
        swap(i, j);
        i++;
        j--;
      }
    }

    if (left < j)
      quickSort(left, j);
    if (i < right)
      quickSort(i, right);
  }
}

public class TP03EX11 {
  private static List<Personagem> personagens = new ArrayList<Personagem>();
  private static Scanner scanner = new Scanner(System.in);

  public static void readFile(String path) {
    try {
      Scanner scanner = new Scanner(new File(path));
      scanner.nextLine(); // skip header

      while (scanner.hasNextLine()) {
        personagens.add(new Personagem(scanner.nextLine()));
      }

      scanner.close();
    } catch (Exception e) { }
  }

  public static Personagem findPersonagem(String id) {
    for (Personagem personagem : personagens) {
      if (personagem.getId().equals(id)) {
        return personagem;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    readFile("/tmp/characters.csv");
    Lista personagensLista = new Lista();

    String id = scanner.nextLine();
    while (!id.equals("FIM")) {
      personagensLista.inserirFim(findPersonagem(id));

      id = scanner.nextLine();
    }

    personagensLista.quickSort();
    personagensLista.imprimir();

    scanner.close();
  }
}
