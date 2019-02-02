package cc;

import java.util.Arrays;
import java.util.Scanner;

public class gfg_longestBitonicSubSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			int max = -1;
			int[] inc = LongestIncSub(arr);
			int[] dec = LongestDecSub(arr);
			for (int i = 0; i < n; ++i) {
				max = Math.max(max, inc[i] + dec[i] - 1);
			}
			System.out.println(max);

		}
		scan.close();
	}

	public static int maxSumBitonicSequence(int[] arr) {
		int max = 0;
		int[] incdp = new int[arr.length];
		for (int i = 1; i < arr.length; ++i) {
			incdp[i] = arr[i];
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j]) {
					incdp[i] = Math.max(incdp[j] + arr[i], incdp[i]);
				}
			}
		}
		for (int i = 0; i < arr.length; ++i) {
			max = Math.max(max, incdp[i]);
		}
		System.out.println(max);

		return max;
	}

	public static int[] LongestIncSub(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < arr.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		return dp;
	}

	public static int[] LongestDecSub(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		for (int i = arr.length - 2; i >= 0; --i) {
			for (int j = arr.length - 1; j > i; --j) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		return dp;
	}

}
