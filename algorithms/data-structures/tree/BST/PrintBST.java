import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

  public void print() {

  }

}

public class PrintBST {
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

    /*
     *          10
     *      5       15
     *    3   7   12
     *  2   4
     */

    // expected output: 10 15 5 3 7 12 4 2
    tree.print();
  }
}
