package cc;

import java.util.Scanner;

public class hackerEarth_OrthogonalPair {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.nextLine();
		int[] x = new int[n];
		int[] y = new int[n];

		for (int i = 0; i < n; ++i) {
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
		}
		scan.close();

		float[] arr = new float[((n) * (n - 1)) / 2];
		int count = 0, num0 = 0, den0 = 0;
		float num, den;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				num = (y[i] - y[j]);
				den = (x[i] - x[j]);

				if (num == 0) {
					arr[count] = 0;
					++num0;
				} else if (den == 0) {
					++den0;
					arr[count] = 0;
				} else {
					arr[count] = num / den;
				}
				++count;
			}
		}
		System.out.println();
		int ans = 0;

		for (int i = 0; i < arr.length; ++i) {
			for (int j = i; j < arr.length; ++j) {
				if (arr[i] * arr[j] == -1) {
					++ans;
					System.out.println(ans);
				}
			}
		}

		System.out.println(ans + den0 * num0);

	}
}
