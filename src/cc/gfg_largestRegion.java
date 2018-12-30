package cc;

import java.util.*;

class gfg_largestRegion {
	public static int max = 0;

	public static int helper(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
			return 0;
		}

		if (arr[i][j] != 1) {
			return 0;
		}

		int rv = 1;
		arr[i][j] = 0;

		rv += helper(arr, i, j);
		rv += helper(arr, i, j + 1);
		rv += helper(arr, i, j - 1);
		rv += helper(arr, i + 1, j);
		rv += helper(arr, i + 1, j + 1);
		rv += helper(arr, i + 1, j - 1);
		rv += helper(arr, i - 1, j - 1);
		rv += helper(arr, i - 1, j);
		rv += helper(arr, i - 1, j + 1);

		if (max < rv) {
			max = rv;
		}
		return rv;

	}

	public static int count(int[][] arr) {
		max = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				helper(arr, i, j);
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] arr = new int[n][m];

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					arr[i][j] = scan.nextInt();
				}
			}

			System.out.println(count(arr));
		}
		scan.close();
	}
}