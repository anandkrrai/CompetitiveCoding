package hh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class wissenq2 {

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

	public static int depth(Node node) {

		int rv = 0;

		for (Node child : node.children) {
			rv = Math.max(rv, depth(child));
		}

		return rv + 1;

	}

	public static void getChildren(Node root, int depth, int level, ArrayList<Node> list) {
		if (depth == level) {
			list.add(root);
			return;
		}

		for (Node child : root.children) {
			getChildren(child, depth, level + 1, list);
		}

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
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num_remove; ++i) {
			set.add(sc.nextInt());
		}

		int depth = depth(root);
		int deletions = 0;
		ArrayList<Node> list;

		for (int i = depth - 1; i > 0; --i) {
			list = new ArrayList<Node>();
			getChildren(root, i, 1, list);

			for (int j = 0; j < list.size(); ++j) {
				int count = 0;

				Node child = list.get(j);

				for (Node ch : child.children) {
					if (set.contains(ch.data)) {
						++count;
					}
				}

				if(count==0) {
					//do nothing
				}else if (count == child.children.size()) {
					deletions += 1;
				} else {
					deletions += count;
				}

			}
		}
		System.out.println(deletions);
		sc.close();

	}
}
