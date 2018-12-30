package cc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class leaf2leamMaxSum {

	public static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	static int max = Integer.MIN_VALUE;

	public static int helper(Node root) {
		if (root == null)
			return 0;

		int lv = helper(root.left);
		int rv = helper(root.right);
		max = max > lv + rv + root.data ? max : lv + rv + root.data;

		return Math.max(rv, lv) + root.data;

	}

	public static int maxPathSum(Node root) {
		helper(root);
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
				
			}
			
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);

					switch (lr) {
					case 'L':
						root.left = new Node(a1);

						break;
					case 'R':
						root.right = new Node(a1);

						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}
			System.out.println(maxPathSum(root));
		}
	}

}
