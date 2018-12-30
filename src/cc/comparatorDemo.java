package cc;

import java.util.ArrayList;
import java.util.Collections;

public class comparatorDemo {

	public static class Node implements Comparable<Node> {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public int compareTo(Node obj) {
			int rv;
			if (this.data > obj.data) {
				rv = 1;
			} else if (this.data == obj.data) {
				rv = 0;
			} else {
				rv = -1;
			}
			return rv;
		}
	}

	public static Node populate() {
		Node head = null;
		head = new Node(99);
		Node rv= head;
		Node temp;
		for (int i = 0; i < 9; ++i) {
			temp = new Node((int)( Math.random() * 100));
			head.next = temp;
			head = temp;
		}

		return rv;
	}

	public static void display(Node head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.data + "=>");
		display(head.next);
	}

	public static ArrayList<Node> returnList(Node head) {
		ArrayList<Node> list = new ArrayList();
		while (head != null) {
			list.add(head);
			head = head.next;
		}

		return list;
	}

	public static void main(String[] args) {
		Node head = populate();
		display(head);
		ArrayList<Node> list = returnList(head);
		Collections.sort(list);

		for (Node node : list) {
			System.out.print(node.data + "->" );
		}
	}

}
