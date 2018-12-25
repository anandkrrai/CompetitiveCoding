package cc;

import java.util.LinkedList;
import java.util.Scanner;

public class counterClockLinkedListByKNodes {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		for (int i = 0; i < n; ++i) {
			list.addLast(scan.nextInt());
		}

		int k = scan.nextInt();

		for (int i = 0; i < k; ++i) {
			list.addLast(list.removeFirst());
		}

		while (list.size() != 0) {
			System.out.print(list.removeFirst() + "=>");
		}

		scan.close();

	}

}
