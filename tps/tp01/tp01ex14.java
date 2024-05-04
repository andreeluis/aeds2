import java.util.Scanner;

public class tp01ex14 {
  private static String substituiValores(int[] portas, String texto) {
    String novoTexto = "";

    // remover espaços em branco
    // substitui os valores de A, B e C
    for (int i = 0; i < texto.length(); i++) {
      if (texto.charAt(i) != ' ') {
        if (texto.charAt(i) == 'A')
          novoTexto += portas[0];
        else if (texto.charAt(i) == 'B')
          novoTexto += portas[1];
        else if (texto.charAt(i) == 'C')
          novoTexto += portas[2];
        else
          novoTexto += texto.charAt(i);
      }
    }

    return novoTexto;
  }

  private static String not(String texto) {
    String novoTexto = "";

    for (int i = 0; i < texto.length(); i++) {
      // verifica se o texto contem not na posição i
      //   not(A)
      // i+012345
      if (texto.charAt(i) == 'n' && texto.charAt(i + 2) == 't' &&
          (texto.charAt(i + 4) == '1' || texto.charAt(i + 4) == '0')) {
        novoTexto += texto.charAt(i + 4) == '1' ? 0 : 1;
        i += 5;
      } else
        novoTexto += texto.charAt(i);
    }

    return novoTexto;
  }

  private static String and(String texto) {
    String novoTexto = "";

    for (int i = 0; i < texto.length(); i++) {
      // verifica se o texto contem and na posição i
      //   and(A,B)
      // i+01234567
      if (texto.charAt(i) == 'a' && texto.charAt(i + 1) == 'n') {
        // and(A,B) - and binário
        if (texto.charAt(i + 7) == ')') {
          novoTexto += (texto.charAt(i + 4) == '1' && texto.charAt(i + 6) == '1') ? '1' : '0';
          i += 7;
        }
        // and(A,B,C) - and ternário
        else if (texto.charAt(i + 9) == ')') {
          novoTexto += (texto.charAt(i + 4) == '1' && texto.charAt(i + 6) == '1' && texto.charAt(i + 8) == '1') ? '1' : '0';
          i += 9;
        }
        // and(A,B,C,D) - and quartenário
        else if (texto.charAt(i + 11) == ')') {
          novoTexto += (texto.charAt(i + 4) == '1' && texto.charAt(i + 6) == '1' && texto.charAt(i + 8) == '1' && texto.charAt(i + 10) == '1') ? '1' : '0';
          i += 11;
        }
        else
          novoTexto += texto.charAt(i);
      } else
        novoTexto += texto.charAt(i);
    }

    return novoTexto;
  }

  private static String or(String texto) {
    String novoTexto = "";

    for (int i = 0; i < texto.length(); i++) {
      // verifica se o texto contem or na posição i
      // or(A,B)
      // i+0123456
      if (texto.charAt(i) == 'o' && texto.charAt(i + 1) == 'r') {
        // or(A,B) - or binário
        if (texto.charAt(i + 6) == ')') {
          novoTexto += (texto.charAt(i + 3) == '1' || texto.charAt(i + 5) == '1') ? '1' : '0';
          i += 6;
        }
        // or(A,B,C) - or ternário
        else if (texto.charAt(i + 8) == ')') {
          novoTexto += (texto.charAt(i + 3) == '1' || texto.charAt(i + 5) == '1' || texto.charAt(i + 7) == '1') ? '1' : '0';
          i += 8;
        }
        // or(A,B,C,D) - or quartenário
        else if (texto.charAt(i + 10) == ')') {
          novoTexto += (texto.charAt(i + 3) == '1' || texto.charAt(i + 5) == '1' || texto.charAt(i + 7) == '1' || texto.charAt(i + 9) == '1') ? '1' : '0';
          i += 10;
        }
        else
          novoTexto += texto.charAt(i);
      } else
        novoTexto += texto.charAt(i);
    }

    return novoTexto;
  }

  private static String recBoolAlgebra(String texto, int inicio) {
    String novoTexto = "";
    int tam = texto.length() - 1;

    //System.out.println(inicio + "-" + fim + ": " + texto.length());

    if (inicio == tam)
      novoTexto = texto;
    else if (texto.charAt(inicio) == 'n')
      novoTexto = not(recBoolAlgebra(texto, inicio + 4));
    else if (texto.charAt(inicio) == 'o')
      novoTexto = or(recBoolAlgebra(texto, inicio + 3));
    else if (texto.charAt(inicio) == 'a')
      novoTexto = and(recBoolAlgebra(texto, inicio + 4));
    else
      novoTexto = recBoolAlgebra(texto, ++inicio);

    //System.out.println(texto.charAt(inicio) + novoTexto);


    return novoTexto;
  }

  private static String boolAlgebra(String texto) {
    return recBoolAlgebra(texto, 0);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int qtdePortas = scanner.nextInt();
    String texto;
    int[] portas = new int[3];

    while (qtdePortas != 0) {
      for (int i = 0; i < qtdePortas; i++)
        portas[i] = scanner.nextInt();
      texto = scanner.nextLine();

      texto = substituiValores(portas, texto);

      texto = boolAlgebra(texto);

      System.out.println(texto);

      qtdePortas = scanner.nextInt();
    }

    scanner.close();
  }
}
