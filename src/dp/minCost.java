package dp;

public class minCost {
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) {
			return 0;
		}
		int[] dp = new int[cost.length + 1];
		for (int i = 0; i < dp.length; ++i) {
			if (i < 2) {
				dp[i] = cost[i];
			} else if (i == cost.length) {
				dp[i] = Math.min(dp[i - 1], dp[i - 2]);
			} else {
				dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
			}
		}
		return dp[dp.length - 1];
	}
}
