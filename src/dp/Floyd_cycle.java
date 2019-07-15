package java_ada;

public class Floyd_cycle {

	private static class node {
		int data;
		node next;

		public node(int data) {
			this.data = data;
		}

	};

	public static node darloop(node n1) {
		node slow = n1.next;
		node fast = n1.next.next;
		while (slow != fast) {
			if (fast == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return fast;
	}

	public static void rloop(node n1) {
		node fast = darloop(n1);
		node slow = n1;
		node prev = fast;
		if (fast != null) {
			while (slow != fast) {
				slow = slow.next;
				prev = fast;
				fast = fast.next;
			}
			prev.next = null;
		}

	}

	public static void display(node n1) {

		while (n1 != null) {
			System.out.print(n1.data + "->");
			n1 = n1.next;
		}
		System.out.print(".");
	}

	public static void main(String[] args) {
		node n1 = new node(1);
		node n2 = new node(2);
		node n3 = new node(3);
		node n4 = new node(4);
		node n5 = new node(5);
		node n6 = new node(6);
		node n7 = new node(7);
		node n8 = new node(8);
		node n9 = new node(9);
		node n10 = new node(10);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n5;

		rloop(n1);
		display(n1);
	}

}
