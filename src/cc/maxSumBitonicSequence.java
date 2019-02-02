package cc;

import java.util.Scanner;

public class maxSumBitonicSequence {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = scan.nextInt();
			}
			int[] decDp = maxSumDecSubSequence(arr);
			int[] incDp = maxSumIncSubSequence(arr);

			int max = 0;
			for (int i = 0; i < arr.length; ++i) {
				max = Math.max(max, decDp[i] + incDp[i] - arr[i]);
			}
			System.out.println(max);
		}
		scan.close();

	}

	public static int[] maxSumDecSubSequence(int[] arr) {
		int[] decdp = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; --i) {
			decdp[i] = arr[i];
			for (int j = arr.length - 1; j > i; --j) {
				if (arr[i] > arr[j]) {
					decdp[i] = Math.max(decdp[j] + arr[i], decdp[i]);
				}
			}
		}

		return decdp;
	}

	public static int[] maxSumIncSubSequence(int[] arr) {
		int[] incdp = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			incdp[i] = arr[i];
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j]) {
					incdp[i] = Math.max(incdp[j] + arr[i], incdp[i]);
				}
			}
		}
		return incdp;
	}
}
