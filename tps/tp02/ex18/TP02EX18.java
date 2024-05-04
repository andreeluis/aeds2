import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
    this.wizard = wizard.equals("VERDADEIRO");
  }

  public int compareNameTo(Personagem other) {
    return getName().compareTo(other.getName());
  }

  public int compareHouseTo(Personagem other) {
    return getHouse().compareTo(other.getHouse());
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

  public void imprimir() {
    System.out.println(this);
  }
}

class QuickSort {
  private Personagem[] array;
  private int tam;
  private int k;

  public Personagem[] getArray() {
    return array;
  }

  public QuickSort(Personagem[] array, int tam) {
    this.array = array;
    this.tam = tam;
    this.k = tam;
  }

  public QuickSort(Personagem[] array, int tam, int k) {
    this.array = array;
    this.tam = tam;
    this.k = k;
  }

  public void imprimir() {
    for (int i = 0; i < k; i++) {
      array[i].imprimir();
    }
  }

  public void sort() {
    quickSort(0, tam - 1);
  }

  private void quickSort(int esq, int dir) {
    int i = esq, j = dir;
    Personagem pivo = array[(dir + esq) / 2];

    while (i <= j) {
      // encontra o primeiro elemento a esquerda que é maior que o pivo
      while ((array[i].compareHouseTo(pivo) < 0) || (array[i].compareHouseTo(pivo) == 0 && array[i].compareNameTo(pivo) < 0)) i++;
      // encontra o primeiro elemento a direita que é menor que o pivo
      while ((array[j].compareHouseTo(pivo) > 0) || (array[j].compareHouseTo(pivo) == 0 && array[j].compareNameTo(pivo) > 0))
        j--;

      if (i <= j) {
        swap(i, j);
        i++;
        j--;
      }
    }

    if ((esq < j) || (j - esq + 1 >= k)) quickSort(esq, j);
    if ((i < dir) || (dir - i + 1 >= k)) quickSort(i, dir);
  }

  private void swap(int i, int j) {
    Personagem temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

public class TP02EX18 {
  public static void main(String[] args) {
    String csvPath = "/tmp/characters.csv";

    // le personagens a partir de um csv
    ArrayList<Personagem> personagens = new ArrayList<Personagem>();
    try {
      Scanner scanner = new Scanner(new File(csvPath));
      scanner.nextLine(); // skip header

      while (scanner.hasNextLine()) {
        personagens.add(new Personagem(scanner.nextLine()));
      }

      scanner.close();
    } catch (Exception e) { }

    Scanner sc = new Scanner(System.in);

    // le id e armazena o personagem em uma lista
    Personagem[] personOrd = new Personagem[50];
    int tam = 0;
    String id = sc.nextLine();
    while (!id.equals("FIM")) {
      for (Personagem personagem : personagens) {
        if (personagem.getId().equals(id)) {
          personOrd[tam++] = personagem;
          break;
        }
      }

      id = sc.nextLine();
    }

    // ordena pelo nome e imprime os personagens
    QuickSort quickSort = new QuickSort(personOrd, tam, 10);
    quickSort.sort();
    quickSort.imprimir();

    sc.close();
  }
}
