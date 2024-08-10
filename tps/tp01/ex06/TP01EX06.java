import java.util.Scanner;

public class TP01EX06 {
  private static boolean ehVogal(char letra) {
    char[] vogais = { 'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u' };

    for (int i = 0; i < 10; i++)
      if (letra == vogais[i])
        return true;

    return false;
  }

  private static boolean ehNumero(char letra) {
    char[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    for (int i = 0; i < 10; i++)
      if (letra == numeros[i])
        return true;

    return false;
  }

  private static boolean ehPonto(char letra) {
    char[] pontos = { ',', '.' };

    for (int i = 0; i < 2; i++)
      if (letra == pontos[i])
        return true;

    return false;
  }

  private static boolean somenteVogais(String texto) {
    for (int i = 0; i < texto.length(); i++)
      if (!ehVogal(texto.charAt(i)))
        return false;

    return true;
  }

  private static boolean somenteConsoantes(String texto) {
    for (int i = 0; i < texto.length(); i++)
      if (ehVogal(texto.charAt(i)) || ehNumero(texto.charAt(i)))
        return false;

    return true;
  }

  private static boolean somenteInteiros(String texto) {
    for (int i = 0; i < texto.length(); i++)
      if (!ehNumero(texto.charAt(i)))
        return false;

    return true;
  }

  private static boolean somenteFloat(String texto) {
    int qtdePontos = 0;

    for (int i = 0; i < texto.length(); i++)
      if (!ehNumero(texto.charAt(i)))
        if (!ehPonto(texto.charAt(i)) || qtdePontos > 0) // caso não seja ponto ou já tenha um ponto na frase
          return false;
        else
          qtdePontos++;

    return true;
  }

  private static void testaCondicoes(String texto) {
    System.out.print(somenteVogais(texto) ? "SIM " : "NAO ");
    System.out.print(somenteConsoantes(texto) ? "SIM " : "NAO ");
    System.out.print(somenteInteiros(texto) ? "SIM " : "NAO ");
    System.out.println(somenteFloat(texto) ? "SIM " : "NAO ");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String texto = scanner.nextLine();

    while (!texto.equals("FIM")) {
      testaCondicoes(texto);

      texto = scanner.nextLine();
    }

    scanner.close();
  }
}
