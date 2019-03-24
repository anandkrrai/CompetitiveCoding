package pep;

public class IntersectionPoint {

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
		System.out.println(prev.data);

		prev.next = null;
	}

	private static void findIntersection(Node n0, Node n1) {
		Node node = n1;
		while (node.next != null) {
			node = node.next;
		}
		node.next = n1;
		removeCycle(n1);

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

		Node n11 = new Node();
		Node n12 = new Node();
		Node n13 = new Node();

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
		n10.next = null;
		n11.next = n12;
		n12.next = n13;
		n13.next = n5;

		findIntersection(n0, n11);
	}

}
