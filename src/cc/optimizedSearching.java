package cc;

import java.util.Arrays;
import java.util.Scanner;

public class optimizedSearching {

	public static int cost(int f[], int n) {
		Arrays.sort(f);
		int ans = calc(f, 0, n - 1, 1);
		return ans;
	}

	public static int calc(int[] arr, int start, int end, int mul) {
		if (end < start)
			return 0;

		if (start == end) {
			return mul * arr[start];
		}
		
		int rv = 0;
		int mid = (start + end) / 2;

		rv = arr[end] * mul;
		rv += calc(arr, mid , end-1, mul + 1);
		rv += calc(arr, start, mid, mul + 1);
		return rv;
	}

	// This is a functional problem. You do not have to change the main function.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int q = 0; q < t; q++) {
			int n = s.nextInt();
			int k[] = new int[n];
			int f[] = new int[n];
			for (int i = 0; i < n; i++)
				k[i] = s.nextInt();
			for (int i = 0; i < n; i++)
				f[i] = s.nextInt();
			System.out.println(cost(f, n));
		}
	}

}
