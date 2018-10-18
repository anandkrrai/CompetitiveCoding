package cc;

import java.util.Scanner;

public class ChefAndOperations {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];

			for (int i = 0; i < n; ++i) {
				a[i] = scan.nextInt();
			}

			for (int i = 0; i < n; ++i) {
				b[i] = scan.nextInt();
			}

			System.out.println(check(a, b, 0));

		}
		scan.close();
	}

	private static String check(int[] a, int[] b, int vidx) {
		if (vidx == a.length) {
			return "TAK";
		}

		if (a[vidx] == b[vidx]) {
			return check(a, b, vidx + 1);
		}

		if (vidx + 2 >= a.length)
			return "NAI";

		if (a[vidx] < b[vidx]) {
			int diff = b[vidx] - a[vidx];
			a[vidx] +=  diff;
			a[vidx + 1] += 2 * diff;
			a[vidx + 2] += 3 * diff;
			return check(a, b, vidx + 1);

		} else {
			int diff = a[vidx] - b[vidx];
			b[vidx] +=  diff;
			b[vidx + 1] += 2 * diff;
			b[vidx + 2] += 3 * diff;
			return check(a, b, vidx + 1);
		}

	}

}
