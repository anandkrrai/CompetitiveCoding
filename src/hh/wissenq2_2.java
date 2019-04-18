package hh;

import java.util.*;

public class wissenq2_2 {

	public static class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			children = new ArrayList<Node>();
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		} else {
			String output = node.data + "=>";

			for (Node child : node.children) {
				output += child.data + ",";
			}
			output += ".";
			System.out.println(output);
			for (Node child : node.children) {
				display(child);
			}
		}

	}

	public static void addNode(Node root, int parent, int child_name) {
		if (root.data == parent) {
			Node temp = new Node(child_name);
			root.children.add(temp);
		} else {
			for (Node child : root.children) {
				addNode(child, parent, child_name);
			}
		}

	}

	private static boolean delete(Node root, int data) {
		if (root.data == data) {
			root.children = new ArrayList<Node>();
			return true;
		}
		boolean rv = false;
		for (Node child : root.children) {
			rv |= delete(child, data);
			if(rv)
				return rv;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// populate
		Node root = null;
		for (int i = 1; i <= n; ++i) {
			int data = sc.nextInt();
			if (data == -1) {
				root = new Node(1);
			} else {
				addNode(root, data, i);
			}
		}

//		display(root);

		int num_remove = sc.nextInt();
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < num_remove; ++i) {
			ls.add(sc.nextInt());
		}

		Collections.sort(ls);
		int deletions = 0;

		for (int i = 0; i < ls.size(); ++i) {
			if (delete(root, ls.get(i))) {
				++deletions;
			}
		}

		System.out.println(deletions);

		sc.close();

	}
}
