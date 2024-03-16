/* Fila circular, é uma alteração da fila. A fila é uma estrutura de dados FIFO (first-in first-out), em que o primeiro elemento a entrar é o primeiro a sair. A fila circular, apesar de ter uma complexidade adicional na implementação, tem um custo menor que o da fila tradicional. A fila circular tem o custo de:
  - O(1): para remover
  - O(1): para inserir
*/

import java.util.Scanner;

class FilaCircular {
  private static int tam = 5;
  private static int[] Fila = new int[tam + 1];
  private static int p = 0;
  private static int u = 0;

  // INICIO
  public static void insere(int valor) {
    if (((u + 1) % tam) == p) {
      System.out.println("A fila está cheia!");
    } else {
      Fila[u] = valor;
      u = (u + 1) % tam;
    }
  }

  public static void remove() {
    if (p == u) {
      System.out.println("A fila está vazia!");
    } else {
      System.out.println(Fila[p]);
      p = (p + 1) % tam;
    }
  }

  public static void imprimeFila() {
    if (p != u) {
      int i = p;

      while (i != u) {
        System.out.print(Fila[i] + " ");
        i = (i + 1) % tam;
      }
      System.out.println();
    }
    else {
      System.out.println("A fila está vazia!");
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
