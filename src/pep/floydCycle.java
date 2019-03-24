package pep;

public class floydCycle {

	public static int counter = 0;

	public static class Node {
		int data;
		Node next;

		public Node() {
			this.data = counter;
			++counter;
		}
	}

	public static void detectCycle(Node node) {
		Node slow = node, fast = node;

		do {
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);

		System.out.println("first match at" + slow.data);

	}

	public static void removeCycle(Node node) {
		Node slow = node, fast = node;

		do {
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);

		Node prev = fast;
		slow = node;
		while (slow != fast) {
			slow = slow.next;
			prev = fast;
			fast = fast.next;
		}

		prev.next = null;
	}

	public static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + "=>");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Node n0 = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		Node n9 = new Node();
		Node n10 = new Node();

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n4;

		detectCycle(n0);
		removeCycle(n0);
		print(n0);
	}

}
