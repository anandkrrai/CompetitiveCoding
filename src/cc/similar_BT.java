package cc;

import java.util.*;

public class similar_BT {

	public static Node root = null;
	public static int count = 0;

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

	public static void addNode(Node node, int parent, int child_name) {
		if (root == null) {
			root = new Node(parent);
			Node temp = new Node(child_name);
			root.children.add(temp);
		} else if (node.data == parent) {
			Node temp = new Node(child_name);
			node.children.add(temp);
		} else {
			for (Node child : node.children) {
				addNode(child, parent, child_name);
			}
		}

	}

	static int similarPair(int n, int k, int[][] edges) {
		for (int i = 0; i < edges.length; ++i) {
			addNode(root, edges[i][0], edges[i][1]);
		}
		ArrayList<Node> list = new ArrayList<>();
		count = 0;
		findNum(root, list, k);
		return count;
	}

	public static void findNum(Node root, ArrayList<Node> list, int k) {
		for (int i = 0; i < list.size(); ++i) {
			if (Math.abs(list.get(i).data - root.data) <= k) {
				++count;
			}
		}
		list.add(root);
		for (Node child : root.children) {
			findNum(child, list, k);
		}
		list.remove(list.size() - 1);

	}
}
