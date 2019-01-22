package cc;

import java.util.Scanner;

public class gfg_coinChange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n + 1];

			for (int i = 1; i < arr.length; ++i) {
				arr[i] = scan.nextInt();
			}

			int val = scan.nextInt();

			int[][] dp = new int[n + 1][val + 1];

			for (int i = 1; i < dp[0].length; ++i) {
				dp[0][i] = 0;
			}
			for (int i = 0; i < dp.length; ++i) {
				dp[i][0] = 1;
			}

			for (int i = 1; i < dp.length; ++i) {
				for (int j = 0; j < dp[0].length; ++j) {
					dp[i][j] = dp[i - 1][j];

					if (arr[i] <= j) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
					}
				}
			}
			System.out.println(dp[dp.length - 1][dp[0].length - 1]);

		}
		scan.close();
	}

}
