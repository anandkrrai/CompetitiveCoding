package cc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class minHeap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		while (t-- > 0) {
			int q = scan.nextInt();

			if (q == 1) {
				int v = scan.nextInt();
				System.out.println(v);
				queue.add(v);
			} else if (q == 2) {
				int v = scan.nextInt();
				queue.remove(v);
			} else {
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

}
