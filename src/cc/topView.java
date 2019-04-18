package cc;

import java.util.*;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class topView {

	public static void topView(Node root) {
		printBoundaryLeft(root.left);
		System.out.print(root.data + " ");
		printBoundaryRight(root.right);
	}

	public static void printBoundaryRight(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			if (node.right != null) {
				printBoundaryRight(node.right);
			} else if (node.left != null) {
				printBoundaryRight(node.left);
			}
		}
	}

	public static void printBoundaryLeft(Node node) {
		if (node != null) {
//			System.out.print(node.data + " ");
			if (node.left != null) {
				printBoundaryLeft(node.left);
			} else if (node.right != null) {
				printBoundaryLeft(node.right);
			}

			System.out.print(node.data + " ");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

}