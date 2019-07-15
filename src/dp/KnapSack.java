package dp;

public class KnapSack {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 3, 4 };
		int[] p = { 15, 14, 10, 45, 30 };
		int cap = 7;
		int steal = dpKnapsack(arr, p, cap);
		System.out.println(steal);
	}

	private static int dpKnapsack(int[] arr, int[] p, int cap) {
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length + 1][cap + 1];

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < dp[0].length; ++j) {
				if (i == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = 0;
				} else if (j < arr[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]] + p[i - 1]);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
