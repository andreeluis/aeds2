/* Fila implementada com inserir no fim e remover do fim. A pilha é uma estrutura de dados LIFO (last-in first-out), em que o primeiro elemento a entrar é o último a sair. Esse algoritmo tem o custo de:
  - O(1): para remover do fim;
  - O(1): para inserir no fim;
*/

import java.util.Scanner;

class Pilha {
  private static int tam = 5;
  private static int Pilha[] = new int[tam];
  private static int qtde = 0;

  public static void insere(int valor) {
    if (qtde < tam) {
      //Pilha[qtde] = valor;
      qtde++;
    }
    else {
      System.out.println("Pilha cheia!");
    }
  }

  public static void remove() {
    if (qtde > 0) {
      qtde--;
      System.out.println(Pilha[qtde]);
    }
    else {
      System.out.println("Pilha vazia!");
    }
  }

  public static void imprimePilha() {
    if (qtde > 0) {
      for (int i = 0; i < qtde; i++) {
        System.out.print(Pilha[i] + " ");
      }
      System.out.println();
    } else {
      System.out.println("Pilha vazia!");
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("\nMenu:");
      System.out.println("1. Imprimir a Pilha");
      System.out.println("2. Inserir valor");
      System.out.println("3. Remover valor");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          imprimePilha();
          break;
        case 2:
          System.out.print("Digite o valor a ser inserido: ");
          int valor = scanner.nextInt();
          insere(valor);
          imprimePilha();
          break;
        case 3:
          remove();
          imprimePilha();
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
