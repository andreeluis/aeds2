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
    this.hogwartsStaff = hogwartsStaff.equals("VERDADEIRO") ? true : false;
  }

  // hogwartsStudent
  public boolean getHogwartsStudent() {
    return hogwartsStudent;
  }

  public void setHogwartsStudent(boolean hogwartsStudent) {
    this.hogwartsStudent = hogwartsStudent;
  }

  public void setHogwartsStudent(String hogwartsStudent) {
    this.hogwartsStudent = hogwartsStudent.equals("VERDADEIRO") ? true : false;
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
    this.alive = alive.equals("VERDADEIRO") ? true : false;
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

  public int compareHairColourTo(Personagem other) {
    return this.getHairColour().compareTo(other.getHairColour());
  }

  public int compareNameTo(Personagem other) {
    return this.getName().compareTo(other.getName());
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

class HeapSort {
  private Personagem[] array;
  private int tam;

  public Personagem[] getArray() {
    return array;
  }

  public HeapSort(Personagem[] array, int tam) {
    this.array = array;
    this.tam = tam;
  }

  public void imprimir() {
    for (int i = 0; i < tam; i++) {
      array[i].imprimir();
    }
  }

  public void sort() {
    //Alterar o vetor ignorando a posicao zero
    Personagem[] tmp = new Personagem[tam + 1];

    for(int i = 0; i < tam; i++){
      tmp[i + 1] = array[i];
    }
    array = tmp;

    //Contrucao do heap
    for(int tamHeap = 2; tamHeap <= tam; tamHeap++){
      construir(tamHeap);
    }

    //Ordenacao propriamente dita
    int tamHeap = tam;
    while(tamHeap > 1){
      swap(1, tamHeap--);
      reconstruir(tamHeap);
    }

    //Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new Personagem[tam];
    for(int i = 0; i < tam; i++){
      array[i] = tmp[i + 1];
    }
  }

  public void construir(int tamHeap){
    for(int i = tamHeap; i > 1; i /= 2){
      int hairDiff = array[i].compareHairColourTo(array[i / 2]);
      int nameDiff = array[i].compareNameTo(array[i / 2]);

      if (hairDiff > 0 || (hairDiff == 0 && nameDiff > 0)) {
        swap(i, i/2);
      }
    }
  }

  public void reconstruir(int tamHeap){
    int i = 1;

    while(i <= (tamHeap / 2)){
      int filho = getMaiorFilho(i, tamHeap);
      int hairDiff = array[i].compareHairColourTo(array[filho]);
      int nameDiff = array[i].compareNameTo(array[filho]);

      if (hairDiff < 0 || (hairDiff == 0 && nameDiff < 0)) {
        swap(i, filho);
        i = filho;
      } else {
        i++;
      }
    }
  }

  public int getMaiorFilho(int i, int tamHeap){
    int filho;
    int hairDiff = array[2 * i].compareHairColourTo(array[2 * i + 1]);
    int nameDiff = array[2 * i].compareNameTo(array[2 * i + 1]);

    if (2 * i == tamHeap || hairDiff > 0 || (hairDiff == 0 && nameDiff > 0)) {
      filho = 2 * i;
    } else {
      filho = 2 * i + 1;
    }

    return filho;
  }

  private void swap(int i, int j) {
    Personagem tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}

public class TP02EX09 {
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
    Personagem[] pSelecionados = new Personagem[50];
    int tam = 0;
    String id = sc.nextLine();
    while (!id.equals("FIM")) {
      for (Personagem personagem : personagens) {
        if (personagem.getId().equals(id)) {
          pSelecionados[tam++] = personagem;
          break;
        }
      }

      id = sc.nextLine();
    }

    HeapSort heapSort = new HeapSort(pSelecionados, tam);
    heapSort.sort();
    heapSort.imprimir();

    // for (int i = 0; i < tam; i++) {
    //   heapSort.getArray()[i].imprimir();
    //   //System.out.println(pSelecionados[i].getHairColour());
    // }

    sc.close();
  }
}
