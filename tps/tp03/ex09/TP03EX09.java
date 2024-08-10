import java.util.Scanner;

class Node {
  int value;
  Node up;
  Node right;
  Node down;
  Node left;

  public Node() {
    this.up = this. down = this.right = this.left = null;
  }

  public Node(int value) {
    this();
    this.value = value;
  }
}

class Matriz {
  Node head;
  int totLn;
  int totCol;

  public Matriz(int ln, int col, Scanner sc) {
    this.totLn = ln;
    this.totCol = col;

    // cria e popula a matriz
    Node start = new Node();
    Node aux = new Node();

    for (int i = 0; i < ln; i++) {

      for (int j = 0; j < col; j++) {
        Node newNode = new Node(sc.nextInt());

        if (i == 0 && j == 0) {
          this.head = newNode;
          start = newNode;
          aux = newNode;
        } else if (i == 0) {
          newNode.left = aux;
          aux.right = newNode;
          aux = aux.right;
        } else if (j == 0) {
          newNode.up = start;
          start.down = newNode;
          aux = newNode;
        } else {
          newNode.left = aux;
          aux.right = newNode;
          newNode.left.up.right.down = newNode;
          newNode.up = newNode.left.up.right;
          aux = aux.right;
        }
      }

      if (i != 0)
        start = start.down;

      aux = start;
    }
  }

  public void mostrarDiagonalPrincipal() {
    if (this.totLn != this.totCol)
      return;

    Node curr = head;
    while (curr != null) {
      System.out.print(curr.value + " ");

      if (curr.down == null) // Se chegou no final da coluna, pare
        break;

      curr = curr.down.right;
    }

    System.out.println();
  }

  public void mostrarDiagonalSecundaria() {
    if (this.totLn != this.totCol)
      return;

    Node curr = head;

    // Move curr para o último nó da primeira linha
    while (curr.right != null) {
      curr = curr.right;
    }

    // Percorre a diagonal secundária e imprime os valores
    while (curr != null) {
      System.out.print(curr.value + " ");

      if (curr.left == null)
        break;

      curr = curr.left.down;
    }

    System.out.println();
  }

  public static void soma(Matriz m1, Matriz m2) {
    Node aux1 = m1.head;
    Node aux2 = m2.head;

    while (aux1 != null && aux2 != null) {
      Node curr1 = aux1;
      Node curr2 = aux2;

      while (curr1 != null && curr2 != null) {
        int sum = curr1.value + curr2.value;
        System.out.print(sum + " ");

        curr1 = curr1.right;
        curr2 = curr2.right;
      }

      System.out.println();

      aux1 = aux1.down;
      aux2 = aux2.down;
    }
  }

  public static void multiplicar(Matriz m1, Matriz m2) {
    Node aux1 = m1.head;

    while (aux1 != null) {
      Node aux2 = m2.head;

      while (aux2 != null) {
        int sum = 0;

        Node curr1 = aux1;
        Node curr2 = aux2;

        while (curr1 != null && curr2 != null) {
          sum += curr1.value * curr2.value;
          curr1 = curr1.right;
          curr2 = curr2.down;
        }

        System.out.print(sum + " ");

        aux2 = aux2.right;
      }

      System.out.println();

      aux1 = aux1.down;
    }
  }
}

public class TP03EX09 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int qtde = sc.nextInt();
    for (int v = 0; v < qtde; v++) {
      int ln = sc.nextInt();
      int col = sc.nextInt();
      Matriz m1 = new Matriz(ln, col, sc);

      int ln2 = sc.nextInt();
      int col2 = sc.nextInt();
      Matriz m2 = new Matriz(ln2, col2, sc);

      m1.mostrarDiagonalPrincipal();
      m1.mostrarDiagonalSecundaria();
      Matriz.soma(m1, m2);
      Matriz.multiplicar(m1, m2);
    }

    sc.close();
  }
}
