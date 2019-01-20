package cc;

import java.util.Arrays;
import java.util.Scanner;

public class codechef_deliveryBoy {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int[] h = new int[n];
			int[] k = new int[n + 1];
			int max = 0;

			for (int i = 0; i < n; ++i) {
				h[i] = sc.nextInt() * 2;
				if (max < h[i]) {
					max = h[i];
				}
			}

			for (int i = 1; i <= n; ++i) {
				k[i] = sc.nextInt();
			}
			Arrays.sort(k);

			int[][] dp = new int[n + 1][max + 1];
			dp[0][0] = 0;

			for (int i = 1; i < dp[0].length; ++i) {
				dp[0][i] = 10000000;
			}

			for (int i = 1; i < dp.length; ++i) {
				for (int j = 0; j < dp[0].length; ++j) {
					dp[i][j] = dp[i - 1][j];

					if (k[i] <= j) {
						dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - k[i]]);
					}
				}
			}

			int res = 0;
			for (int i = 0; i < n; ++i) {
				res += dp[dp.length - 1][h[i]];
			}
			System.out.println(res);
		}

	}

}
