package cc;

import java.util.Scanner;

public class ANDqueries {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		++n;
		int[] arr = new int[n];

		for (int i = 1; i < n; ++i) {
			arr[i] = scan.nextInt();

		}

		int t = scan.nextInt();
		int mod = 1000000007;
		int count;

		while (t > 0) {
			--t;
			int l = scan.nextInt();
			int r = scan.nextInt();
			int x = scan.nextInt();
			int y, y1;
			count = 0;

			for (int i = l; i <= r; ++i) {
				for (int j = l; j <= r; ++j) {
					y1 = arr[i] & arr[j];
					for (int k = l; k <= r; ++k) {
						y = y1 & arr[k];
						if (x == y) {
							++count;
						}
					}
				}
			}

			System.out.println(count % mod);

		}

		scan.close();
	}
}
