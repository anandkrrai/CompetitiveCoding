package cc;

import java.util.Scanner;

public class longestZigZackSequence {

	public static class Node {
		Boolean inc;
		int length;

		Node() {
			inc = true;
			length = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			Node[] nodes = new Node[n];
			nodes[0] = new Node();
			nodes[0].inc = true;
			nodes[0].length = 1;

			for (int i = 1; i < arr.length; ++i) {
				nodes[i] = new Node();
				for (int j = 0; j < i; ++j) {
					if (nodes[j].inc) {
						if (arr[i] > arr[j] ) {
							if( nodes[j].length >= nodes[i].length) {
								nodes[i].length = nodes[j].length + 1;
								nodes[i].inc = false;
							}else {
								
							}
							
						}
					} else {
						if (arr[i] < arr[j] && nodes[j].length <=nodes[i].length) {
							nodes[i].length = nodes[j].length + 1;
							nodes[i].inc = true;
						}
					}
				}

			}
			int max = 0;
			for (Node node : nodes) {
				max = Math.max(max, node.length);
			}
			System.out.println(max);
		}
	}

}
