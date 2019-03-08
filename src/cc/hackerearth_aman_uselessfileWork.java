package cc;

import java.util.Arrays;
import java.util.Scanner;

public class hackerearth_aman_uselessfileWork {

	public static  class Node implements Comparable<Node> {
		int n;
		int data;

		@Override
		public int compareTo(Node o) {
			return this.data - o.data;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Node[] arr = new Node[n];
		for (int i = 0; i < n; ++i) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			sc.nextLine();
			arr[i]=new Node();
			arr[i].data = n1 + n2;
			arr[i].n = i;
		}
		Arrays.parallelSort(arr);
		for (Node node : arr) {
			System.out.print(node.n + " ");
		}

	}

}
