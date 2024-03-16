/* A lista é uma estrutura de dados que possui 6 métodos:
  - Inserir no ínicio: com custo O(n);
  - Inserir no fim: com custo O(1);
  - Inserir na posição: com custo O(n);
  - Remover do ínicio: com custo O(n)
  - Remover do fim: com custo O(1)
  - Remover da posição: com custo O(n)
  A partir das listas, podemos derivar a implementação de pilhas e filas.
*/

import java.util.Scanner;

class Lista {
  private static int tam = 5;
  private static int[] lista = new int[tam];
  private static int qtde = 0;

  // INICIO
  public static void insereInicio(int valor) {
    if (qtde < tam) {
      for (int i = qtde; i > 0; i--) {
        lista[i] = lista[i - 1];
      }
      qtde++;

      lista[0] = valor;
    }
    else {
      System.out.println("Lista cheia!");
    }
  }

  public static void removeInicio() {
    if (qtde > 0) {
      //System.out.println(lista[0]);

      for (int i = 0; i < qtde - 1; i++) {
        lista[i] = lista[i + 1];
      }

      qtde--;

      lista[qtde] = 0;
    }
    else {
      System.out.println("Lista Vazia!");
    }
  }

  // FIM
  public static void insereFim(int valor) {
    if (qtde < tam) {
      lista[qtde] = valor;
      qtde++;
    }
    else {
      System.out.println("Lista cheia!");
    }
  }

  public static void removeFim() {
    if (qtde > 0) {
      //System.out.println(lista[qtde - 1]);

      qtde--;
    }
    else {
      System.out.println("Lista cheia!");
    }
  }

  // INDEX
  public static void insereIndex(int valor, int index) {
    if (qtde < tam) {
      if (index < tam && index <= qtde) {
        for (int i = qtde; i > index; i--) {
          lista[i] = lista[i - 1];
        }
        qtde++;

        lista[index] = valor;
      }
      else {
        System.out.println("Index inválido!");
      }
    }
    else {
      System.out.println("Lista cheia!");
    }
  }

  public static void removeIndex(int index) {
    if (qtde > 0) {
      if (index < tam && index < qtde) {
        //System.out.println(lista[index]);

        for (int i = index; i < qtde - 1; i++) {
          lista[i] = lista[i + 1];
        }

        qtde--;
      }
      else {
        System.out.println("Index inválido!");
      }
    }
    else {
      System.out.println("Lista vazia!");
    }
  }

  public static void imprimeLista() {
    if (qtde > 0) {
      for (int i = 0; i < qtde; i++) {
        System.out.print(lista[i] + " ");
      }
      System.out.println();
    }
    else {
      System.out.println("Lista Vazia!");
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int opcao, index, valor;

    do {
      System.out.println("\nMenu:");
      System.out.println("1. Imprimir lista");
      System.out.println("2. Inserir no início");
      System.out.println("3. Remover do início");
      System.out.println("4. Inserir no fim");
      System.out.println("5. Remover do fim");
      System.out.println("6. Inserir em um índice específico");
      System.out.println("7. Remover de um índice específico");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          imprimeLista();
          break;
        case 2:
          System.out.print("Digite o valor a ser inserido no início: ");
          valor = scanner.nextInt();
          insereInicio(valor);
          imprimeLista();
          break;
        case 3:
          removeInicio();
          imprimeLista();
          break;
        case 4:
          System.out.print("Digite o valor a ser inserido no fim: ");
          valor = scanner.nextInt();
          insereFim(valor);
          imprimeLista();
          break;
        case 5:
          removeFim();
          imprimeLista();
          break;
        case 6:
          System.out.print("Digite o índice em que deseja inserir: ");
          index = scanner.nextInt();
          System.out.print("Digite o valor a ser inserido no index[" + index + "]: ");
          valor = scanner.nextInt();
          insereIndex(valor, index);
          imprimeLista();
          break;
        case 7:
          System.out.print("Digite o índice a ser removido: ");
          index = scanner.nextInt();
          removeIndex(index);
          imprimeLista();
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
