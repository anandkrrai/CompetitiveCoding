package cc;

import java.util.Scanner;

public class subAraySum {

	private static void solve(int[] arr) {
		int[] strg = new int[arr.length];

		strg[0] = arr[0];

		int omax = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
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

	private static void solve(int sum, int[] arr) {
		int left = 0;
		int right = 1;
		int currSum = arr[left] + arr[right];
		while (right < arr.length - 1) {
			if (left == right) {
				right++;
				currSum = arr[left] + arr[right];
			}
			if (arr[left] == sum) {

				System.out.print(left + " " + left);
				return;
			} else if (arr[right] == sum) {
				System.out.print(right + " " + right);
				return;
			} else if (currSum == sum) {
				System.out.print((left + 1) + " " + (right + 1));
				return;
			} else if (currSum < sum) {
				right++;
				if (right < arr.length) {
					currSum += arr[right];
				}
			} else {
				currSum -= arr[left];
				left++;
			}
		}

		System.out.print("-1");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int sum = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
//			System.out.println(arr[12433]);

			solve(sum, arr);
//			mysolve(arr, sum);
			System.out.println();
		}
		int[] arr2 = { 1, 101, 2,101,101, 3, 100, 4, 5 };

		solve(arr2);
		System.out.println(maxSumIS(arr2, arr2.length));
	}
}