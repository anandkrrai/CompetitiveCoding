package dp;

public class Unbounded_knapsack {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 3, 4 };
		int[] p = { 15, 14, 10, 45, 30 };
		int cap = 7;

		int max_steal = unbknp(arr, p, cap);
		System.out.println(max_steal);
	}

	private static int unbknp(int[] arr, int[] p, int cap) {
		int[] dp = new int[cap + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < arr.length; ++j) {
				if (i >= arr[j]) {
					dp[i] = Math.max(dp[i], p[j] + dp[i - arr[j]]);
				}
			}
		}
		return dp[dp.length - 1];
	}

}
