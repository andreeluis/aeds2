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

class BST {
  Node root;

  public BST() {
    this.root = null;
  }

  public void insert(int value) {
    Node newNode = new Node(value);

    if (this.root == null) {
      this.root = newNode;
    } else {
      Node current = this.root;

      while (true) {
        if (value < current.value) {
          if (current.left == null) {
            current.left = newNode;
            break;
          } else {
            current = current.left;
          }
        }
        else {
          if (current.right == null) {
            current.right = newNode;
            break;
          } else {
            current = current.right;
          }
        }
      }
    }
  }

  public void print(Node node, String indent) {
    if (node != null) {
      print(node.right, indent + "   ");
      System.out.println(indent + node.value);
      print(node.left, indent + "   ");
    }
  }

  public void print() {
    print(this.root, "");
  }

  public int getHeight() {
    return getHeight(this.root);
  }

  private int getHeight(Node node) {
    if (node == null)
      return -1;

    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);

    if (leftHeight > rightHeight)
      return leftHeight + 1;
    else
      return rightHeight + 1;
  }
}

public class HeightBST {
  public static void main(String[] args) {
    BST tree = new BST();

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(12);
    tree.insert(4);
    tree.insert(2);

    System.out.println("Tree Height: " + tree.getHeight() + "\n");
    tree.print();
  }
}
