class Node {
	public int value;
	public Node next;

	public Node() {
		this(0);
	}

	public Node(int value) {
    this.value = value;
    this.next = null;
	}
}

public class Stack {
	private Node top;

	public Stack() {
		top = null;
	}

	public void insert(int x) {
		Node tmp = new Node(x);
		tmp.next = top;
		top = tmp;
		tmp = null;
	}

	public int remove() {
		if (top == null) {
			System.out.println("Remove error!");
			return -1;
		}
		int el = top.value;
		Node tmp = top;
		top = top.next;
		tmp.next = null;
		tmp = null;
		return el;
	}

	public int getMax() {
		int max = top.value;
		for (Node i = top.next; i != null; i = i.next) {
			if (i.value > max)
				max = i.value;
		}
		return max;
	}

	public void show() {
		System.out.print("[");
		show(top);
		System.out.println(" ]");
	}

	private void show(Node i) {
		if (i != null) {
			show(i.next);
			System.out.print(" " + i.value);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.insert(1);
		stack.insert(4);
		stack.insert(5);
		stack.insert(7);
		stack.insert(10);

		System.out.println("R: " + stack.remove());

		stack.insert(17);

		stack.show();
	}
}
