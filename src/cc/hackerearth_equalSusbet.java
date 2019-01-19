package cc;

import java.util.Arrays;
import java.util.Scanner;

public class hackerearth_equalSusbet {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		for (int i = 0; i < n; ++i) {
			arr1[i] = s.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			arr2[i] = s.nextInt();
		}

		int ans = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < n; ++i) {
			ans += Math.abs(arr1[i] - arr2[i]);
		}

		System.out.println(ans);
		s.close();
	}
}
