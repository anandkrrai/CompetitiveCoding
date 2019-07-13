
package hh;

import java.util.*;

public class DivineDivisors {

	public static void printDivisors(long n) {
		LinkedList<Long> list = new LinkedList<Long>();
		long square_root = (long) Math.sqrt(n);

		for (long i = 1; i <= square_root; i++) {
			if (n % i == 0) {
				if (n / i == i)
					System.out.print(i + " ");
				else {
					System.out.print(i + " ");
					list.addFirst(n / i);
				}
			}
		}
		while (list.size() != 0)
			System.out.print(list.remove() + " ");
		System.out.println();
	}

	public static void printDivisors1(long n) {
		ArrayList<Long> list = new ArrayList<Long>();
		int square_root = (int) Math.sqrt(n) + 1;
		StringBuilder sb = new StringBuilder("");

		for (long i = 1; i <= square_root; i++) {
			if (n % i == 0) {
				if (n / i == i)
					System.out.print(i + " ");
				else {
					System.out.print(i + " ");
					list.add(n / i);
				}
			}
		}
		System.out.print(sb);
		for (int i = list.size() - 1; i >= 0; --i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long n = scan.nextLong();
			printDivisors(n);
		}
	}

}
