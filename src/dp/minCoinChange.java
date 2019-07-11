package dp;

import java.util.*;

public class minCoinChange {
	
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE - 100);

		dp[0] = 0;

		Arrays.sort(coins);
		for (int val : coins) {
			for (int i = val; i <= amount; ++i) {
				dp[i] = Math.min(dp[i], dp[i - val] + 1);
			}
		}

		if (dp[amount] == 2147483547)
			return -1;
		return dp[amount];
	}

	public int coinChange1(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < dp.length; ++i)
			Arrays.fill(dp[i], Integer.MAX_VALUE - 100);

		for (int i = 0; i < dp.length; ++i)
			dp[i][0] = 0;

		for (int j = 1; j <= amount; ++j) {
			for (int i = 1; i <= coins.length; ++i) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

				if (j >= coins[i - 1]) {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}
		int rv = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; ++i) {
			rv = Math.min(rv, dp[i][amount]);
		}
		System.out.println(Integer.MAX_VALUE - 100);
		if (rv == 2147483547)
			return -1;
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
