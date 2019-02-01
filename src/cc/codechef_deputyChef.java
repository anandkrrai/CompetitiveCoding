package cc;

import java.util.Scanner;

public class codechef_deputyChef {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[] a = new int[n + 2];
			int[] d = new int[n + 2];

			for (int i = 1; i <= n; ++i) {
				a[i] = scan.nextInt();
			}
			a[0] = a[n];
			a[n + 1] = a[1];
			for (int i = 1; i <= n; ++i) {
				d[i] = scan.nextInt();
			}
			d[0] = d[n];
			d[n + 1] = d[1];

			int max = -1;

			for (int i = 1; i <= n; ++i) {
				if (max < d[i]) {
					if (d[i] > a[i - 1] + a[i + 1]) {
						max = d[i];
					}
				}
			}

			System.out.println(max);

		}

		scan.close();
	}

}
