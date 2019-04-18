package hh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WQ2 {
	private static class node {
		int data;
		HashSet<node> children;
		HashSet<Integer> child;

		node(int data) {
			this.data = data;
			this.children = new HashSet<>();
			this.child = new HashSet<>();
		}
	}

	private static node construct(int[] arr) {
		HashMap<Integer, node> map = new HashMap<>();
		node root = null;
		for (int i = 0; i < arr.length; ++i) {

			node nn;
			if (!map.containsKey(i + 1)) {
				nn = new node(i + 1);
				map.put(i + 1, nn);
			} else {
				nn = map.get(i + 1);
			}

			if (arr[i] == -1) {
				root = nn;
			} else if (map.containsKey(arr[i])) {
				map.get(arr[i]).children.add(nn);
				map.get(arr[i]).child.add(i + 1);

			} else {
				node pv = new node(arr[i]);
				pv.children.add(nn);
				pv.child.add(i + 1);
				map.put(arr[i], pv);
			}
		}

		return root;
	}

	private static void display(node root) {
		System.out.print(root.data + "->");

		for (node child : root.children) {
			System.out.print(child.data + ",");
		}
		System.out.println(".");

		for (node child : root.children) {
			display(child);
		}

	}

	private static boolean delete(node root, int data) {
		if (root.data == data) {
			root.children = new HashSet<>();
			return true;
		}
		boolean rv = false;
		for (node child : root.children) {
			rv |= delete(child, data);
			if (rv)
				return rv;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}

		node root = construct(arr);
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