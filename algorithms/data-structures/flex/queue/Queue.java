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

public class Queue {
	private Node first;
	private Node last;

	public Queue() {
		first = new Node();
		last = first;
	}

	public void insert(int x) {
		last.next = new Node(x);
		last = last.next;
	}

	public void insertOrdered(int x) {
		for (Node i = first; i.next != null; i = i.next) {
			if (i.next.value > x) {
				Node tmp = i.next;
				i.next = new Node(x);
				i.next.next = tmp;
				return;
			}
		}
	}

	public int remove() {
		if (first == last) {
			System.out.println("Remove error!");
			return -1;
		}

		Node tmp = first;
		first = first.next;
		int resp = first.value;
		tmp.next = null;
		tmp = null;
		return resp;
	}

	public void show() {
		System.out.print("[ ");

		for(Node i = first.next; i != null; i = i.next) {
			System.out.print(i.value + " ");
		}

		System.out.println("]");
	}

	public static void main(String[] args) {
		Queue queue = new Queue();

		queue.insert(1);
		queue.insert(4);
		queue.insert(5);
		queue.insert(7);
		queue.insert(10);

		queue.insertOrdered(6);
		queue.insertOrdered(2);

		queue.show();

		System.out.println("R: " + queue.remove());
		System.out.println("R: " + queue.remove());

		queue.show();
	}
}
