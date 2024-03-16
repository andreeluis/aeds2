/* Fila implementada com inserir no inicio e remover do fim. A fila é uma estrutura de dados FIFO (first-in first-out), em que o primeiro elemento a entrar é o primeiro a sair. Porém com essa implementação (fila tradicional), temos um custo ótimo na inserção/remoção no ínicio, e um custo mais elevado na inserção/remoção no final. A implementação da fila depende do par de inserção e remoção invertido, sendo assim ela pode ser:
  - Inserção no ínicio e remoção no final;
  - Inserção no final e remoção no ínicio.
  Dessa forma, o algoritmo tem o custo de:
  - O(1): para remover do fim;
  - O(n): para inserir no inicio.
*/

import java.util.Scanner;

class Fila {
  private static int tam = 5;
  private static int[] Fila = new int[tam];
  private static int qtde = 0;

  // INICIO
  public static void insere(int valor) {
    if (qtde < tam) {
      for (int i = qtde; i > 0; i--) {
        Fila[i] = Fila[i - 1];
      }
      qtde++;

      Fila[0] = valor;
    } else {
      System.out.println("Fila cheia!");
    }
  }

  public static void remove() {
    if (qtde > 0) {
      //System.out.println(Fila[qtde - 1]);

      qtde--;
    } else {
      System.out.println("Fila cheia!");
    }
  }

  public static void imprimeFila() {
    if (qtde > 0) {
      for (int i = 0; i < qtde; i++) {
        System.out.print(Fila[i] + " ");
      }
      System.out.println();
    } else {
      System.out.println("Fila Vazia!");
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("\nMenu:");
      System.out.println("1. Imprimir a Fila");
      System.out.println("2. Inserir valor");
      System.out.println("3. Remover valor");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          imprimeFila();
          break;
        case 2:
          System.out.print("Digite o valor a ser inserido: ");
          int valor = scanner.nextInt();
          insere(valor);
          imprimeFila();
          break;
        case 3:
          remove();
          imprimeFila();
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 0);

    scanner.close();
  }
}
