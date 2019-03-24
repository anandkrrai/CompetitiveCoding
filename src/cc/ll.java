package cc;

public class ll {

	public static class Node {
		int data;
		Node next;
	}

	public static Node head;
	public static Node tail;
	public static int size = 0;

	public static void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " => ");
			node = node.next;
		}

		System.out.println();
	}

	public static void addLast(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (head == null) {
			head = tail = node;
			head.next = tail;
		} else {
			tail.next = node;
			tail = node;
		}

		++size;
	}

	public static Node getAt(int index) {
		Node node = head;

		if (index >= size) {
			System.out.println("error");
		} else {
			for (int i = 0; i < index; ++i) {
				node = node.next;
			}
		}

		return node;
	}

	public static void reverseItetrative() {
		Node prev = head, curr = prev.next, next = curr.next;

		while (curr != null) {
			next = curr.next;

			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		temp.next = null;

	}
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i += 10) {
			addLast(i);
		}
		display();
//		System.out.println(getAt(2).data);
		reverseItetrative();
		display();
		
	}

}
