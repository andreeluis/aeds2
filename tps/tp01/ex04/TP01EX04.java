import java.util.Random;
import java.util.Scanner;

public class TP01EX04 {
  private static Random gerador = new Random();

  private static void trocaLetra(String texto) {
    char letraAntiga = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
    char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

    String novoTexto = texto.replace(letraAntiga, letraNova);
    System.out.println(novoTexto);
  }

  public static void main(String[] args) {
    gerador.setSeed(4);

    Scanner scanner = new Scanner(System.in);

    String texto = scanner.nextLine();

    while (!texto.equals("FIM")) {
      trocaLetra(texto);

      texto = scanner.nextLine();
    }

    scanner.close();
  }
}
