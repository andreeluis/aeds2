import java.util.Scanner;

class Node {
  int value;
  Node left;
  Node right;

  Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class Tree {
  public Node root;

  Tree() {
    this.root = null;
  }

  public void insert(int value) {
    if (this.root == null) {
      this.root = new Node(value);
    } else {
      insert(this.root, value);
    }
  }

  private void insert(Node node, int value) {
    if (value < node.value) {
      if (node.left == null) {
        node.left = new Node(value);
      } else {
        insert(node.left, value);
      }
    } else {
      if (node.right == null) {
        node.right = new Node(value);
      } else {
        insert(node.right, value);
      }
    }
  }

  public String preOrder(Node node) {
    if (node == null) {
      return "";
    }

    return node.value + " " + preOrder(node.left) + preOrder(node.right);
  }

  public String inOrder(Node node) {
    if (node == null) {
      return "";
    }

    return inOrder(node.left) + node.value + " " + inOrder(node.right);
  }

  public String postOrder(Node node) {
    if (node == null) {
      return "";
    }

    return postOrder(node.left) + postOrder(node.right) + node.value + " ";
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      int qtde = sc.nextInt();

      Tree tree = new Tree();

      for (int j = 0; j < qtde; j++) {
        int value = sc.nextInt();
        tree.insert(value);
      }

      System.out.println("Case " + i + ":");
      System.out.println("Pre.: " + tree.preOrder(tree.root).strip());
      System.out.println("In..: " + tree.inOrder(tree.root).strip());
      System.out.println("Post: " + tree.postOrder(tree.root).strip());
      System.out.println();
    }

    sc.close();
  }
}
