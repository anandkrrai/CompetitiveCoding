package cc;

public class llR {

	private static class HeapMover {
		Node node;
	}

	public static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	public static Node head;

	public static boolean IsPalin() {
		HeapMover left = new HeapMover();
		left.node = head;
		return IsPalin(left, head);
	}

	private static boolean IsPalin(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalin(left, right.next);
		if (res == true && left.node.data == right.data) {
			left.node = left.node.next;
			return true;
		} else {
			return false;
		}
	}


	public static void display(Node node) {
		if (node == null) {
			System.out.println();
			return;
		}

		System.out.print(node.data + "=>");
		display(node.next);
	}

	public static void main(String[] args) {
		head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(3);
		Node n5 = new Node(2);
		Node n6 = new Node(1);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;

//		display(head);
		System.out.println(IsPalin());

	}

}
