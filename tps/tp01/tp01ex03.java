import java.util.Scanner;

class tp01ex03 {
  private static String cifraCesar(String texto) {
    int tam = texto.length() - 1;

    char[] textoArray = texto.toCharArray();

    //System.out.println(texto);

    for (int i = 0; i <= tam; i++) {
      if (texto.charAt(i) >= 0 && texto.charAt(i) <= 127) //verifica se não é char especial
        textoArray[i] += 3;
      else
        textoArray[i] = textoArray[i];
    }

    return String.copyValueOf(textoArray);
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