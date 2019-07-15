package dp;

public class Target_subset {

	public static void main(String[] args) {
		int[] arr = { 10, 10, 1, 2, 3 };

		boolean[][] strg = target(arr, 6);
		// System.out.println(strg);

		print_path(strg, "", arr, strg.length - 1, strg[0].length - 1);

	}

	private static void print_path(boolean[][] strg, String psf, int[] arr, int i, int j) {
		if (i == 0 && j == 0) {
			System.out.println(psf);
			return;
		}

		if (strg[i - 1][j] == true) {
			print_path(strg, psf, arr, i - 1, j);
		}
		if (j - arr[i - 1] >= 0 && strg[i - 1][j - arr[i - 1]] == true) {
			print_path(strg, psf + " " + arr[i - 1], arr, i - 1, j - arr[i - 1]);
		}

	}

	private static boolean[][] target(int[] arr, int target) {
		boolean[][] dp = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < dp[0].length; ++j) {

				if (i == 0) {
					if (j == 0) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else if (dp[i - 1][j] == true) {
					dp[i][j] = true;
				} else if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]] == true) {
					dp[i][j] = true;
				}

			}
		}

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < dp[0].length; ++j) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		return dp;
	}

}
