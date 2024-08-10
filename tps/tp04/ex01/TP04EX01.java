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
    return this.getName().compareTo(p.getName());
  }
}

class Node {
  Personagem personagem;
  Node esq;
  Node dir;

  public Node() {
    this.personagem = null;
    this.esq = this.dir = null;
  }

  public Node(Personagem p) {
    this.personagem = p;
    this.esq = this.dir = null;
  }
}

class ArvoreBinaria {
  private Node head;

  public ArvoreBinaria() {
    this.head = null;
  }

  public void inserir(Personagem p) {
    head = inserir(p, head);
  }

  private Node inserir(Personagem p, Node node) {
    if (node == null)
      node = new Node(p);
    else if (p.compareTo(node.personagem) < 0)
      node.esq = inserir(p, node.esq);
    else if (p.compareTo(node.personagem) > 0)
      node.dir = inserir(p, node.dir);

    return node;
  }

  public boolean pesquisar(String name) {
    System.out.print("raiz ");
    return pesquisar(name, head);
  }

  private boolean pesquisar(String name, Node node) {
    boolean resp = false;

    if (node == null) {
      resp = false;
    } else if (name.compareTo(node.personagem.getName()) < 0) {
      System.out.print("esq ");
      resp = pesquisar(name, node.esq);
    } else if (name.compareTo(node.personagem.getName()) > 0) {
      System.out.print("dir ");
      resp = pesquisar(name, node.dir);
    } else {
      resp = true;
    }

    return resp;
  }
}

public class TP04EX01 {
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
    ArvoreBinaria personagens = new ArvoreBinaria();

    String id = scanner.nextLine();
    while (!id.equals("FIM")) {
      personagens.inserir(findPersonagem(id));

      id = scanner.nextLine();
    }

    String name = scanner.nextLine();
    while (!name.equals("FIM")) {
      System.out.print(name + " => ");

      if (personagens.pesquisar(name))
        System.out.println("SIM");
      else
        System.out.println("NAO");

      name = scanner.nextLine();
    }

    scanner.close();
  }
}
