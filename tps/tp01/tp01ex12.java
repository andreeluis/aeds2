import java.util.Scanner;

class tp01ex12 {
  private static String cifraCesar(String texto) {
    return cifraCesar(texto, 0);
  }

  private static String cifraCesar(String texto, int i) {
    int tam = texto.length() - 1;
    String resp = "";

    if (texto.charAt(i) <= 127 && texto.charAt(i) >= 0)
      resp += (char)(texto.charAt(i) + 3);
    else
      resp += (char)(texto.charAt(i));

    if (tam > i)
      resp += cifraCesar(texto, ++i);

    return resp;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String texto;

    texto = sc.nextLine();

    while (!texto.equals("FIM")) {
      System.out.println(cifraCesar(texto));

      texto = sc.nextLine();
    }

    sc.close();
  }
}