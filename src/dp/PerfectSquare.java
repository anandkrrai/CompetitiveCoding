package dp;

import java.util.Arrays;

public class PerfectSquare {

	public static int numSquares(int n) {

		int[] arr = new int[n + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; ++i) {
			arr[i * i] = 1;
		}
		arr[0]=0;

		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < i; ++j) {
				arr[i] = Math.min(arr[i], arr[i - j] + arr[j]);
			}
		}
		return arr[n];
	}

	public static int numSquaresFast(int n) {

		int[] arr = new int[n + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; ++i) {
			arr[i * i] = 1;
		}
		arr[0]=0;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j*j <=i; ++j) {
				arr[i] = Math.min(arr[i], arr[i - j*j] +1);
			}
		}
		return arr[n];
	}

	public static void main(String[] args) {
		System.out.println(numSquaresFast(100));
	}

}
