import java.util.Scanner;

public class tp01ex15 {
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

  private static boolean somenteVogaisRec(String texto, int i) {
    boolean resp = false;
    int tam = texto.length();

    if (tam == i)
      resp = true;
    else if (ehVogal(texto.charAt(i)))
      resp = somenteVogaisRec(texto, ++i);

    return resp;
  }

  private static boolean somenteVogais(String texto) {
    return somenteVogaisRec(texto, 0);
  }

  private static boolean somenteConsoantesRec(String texto, int i) {
    boolean resp = false;
    int tam = texto.length();

    if (tam == i)
      resp = true;
    else if (!ehVogal(texto.charAt(i)) && !ehNumero(texto.charAt(i)))
      resp = somenteConsoantesRec(texto, ++i);

    return resp;
  }

  private static boolean somenteConsoantes(String texto) {
    return somenteConsoantesRec(texto, 0);
  }

  private static boolean somenteInteirosRec(String texto, int i) {
    boolean resp = false;
    int tam = texto.length();

    if (tam == i)
      resp = true;
    else if (ehNumero(texto.charAt(i)))
      resp = somenteInteirosRec(texto, ++i);

    return resp;
  }

  private static boolean somenteInteiros(String texto) {
    return somenteInteirosRec(texto, 0);
  }

  private static boolean somenteFloatRec(String texto, int i, int qtdePontos) {
    boolean resp = false;
    int tam = texto.length();

    if (tam == i)
      resp = true;
    else if (qtdePontos <= 1) {
      if (ehNumero(texto.charAt(i)))
        resp = somenteFloatRec(texto, ++i, qtdePontos);
      else if (ehPonto(texto.charAt(i)))
        resp = somenteFloatRec(texto, ++i, ++qtdePontos);
    }

    return resp;
  }

  private static boolean somenteFloat(String texto) {
    return somenteFloatRec(texto, 0, 0);
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
