package cc;

import java.util.Scanner;

public class maxSubsetSum {
	private static void solve(int[] arr) {
		int[] strg = new int[arr.length];

		strg[0] = arr[0];

		int omax = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int max = arr[i];
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(arr[i], strg[j] + arr[i]);
				}
			}
			strg[i] = max;
			omax = Math.max(omax, strg[i]);
			// compare mis[i] with omax

		}

		System.out.println(omax);

	}
	

	static int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		/*
		 * Initialize msis values for all indexes
		 */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/*
		 * Compute maximum sum values in bottom up manner
		 */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/*
		 * Pick maximum of all msis values
		 */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			solve(arr);
			System.out.println(maxSumIS(arr, n));
			
		}
	}
}