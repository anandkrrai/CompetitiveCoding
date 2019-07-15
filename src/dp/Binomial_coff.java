package java_ada;

import java.util.Arrays;

public class Binomial_coff {
	public static int BinoCoff(int n, int k) {
		int[][] arr = new int[n + 1][k + 1];

		for (int i = 0; i < n + 1; ++i) {
			for (int j = 0; j <= Math.min(i,k); ++j) {
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}

		}
		return arr[n][k];

	}

	// private static int BinoCoff_r(int n, int k, int[][] arr) {
	//
	// if (arr[n][k] != 0) {
	// return arr[n][k];
	// }
	// if (n == k || k == 0) {
	// arr[n][k] = 1;
	// return 1;
	// }
	//
	// int coff = BinoCoff_r(n - 1, k - 1, arr) + BinoCoff_r(n - 1, k, arr);
	//
	// arr[n][k] = coff;
	// return coff;
	// }

	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		int coff = BinoCoff(n, k);
		System.out.println(coff);

	}

}
