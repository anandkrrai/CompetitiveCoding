package cc;

import java.util.Arrays;
import java.util.Scanner;

public class hackerearth_equalSusbet {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		long[] arr1 = new long[n];
		long[] arr2 = new long[n];

		for (int i = 0; i < n; ++i) {
			arr1[i] = s.nextLong();
		}

		for (int i = 0; i < n; ++i) {
			arr2[i] = s.nextLong();
		}

		long ans = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < n; ++i) {
			ans += Math.abs(arr1[i] - arr2[i]);

			ans %= 1000000007;
		}

		System.out.println(ans);
	}
}