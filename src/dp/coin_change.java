package java_ada;

public class coin_change {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int count = stepPerms(35);
		System.out.println(count);
	}

	private static int stepPerms(int n) {
		long mod = 10000000007;
		int[] dp = new int[n + 1];

		for (int i = 0; i < dp.length; ++i) {
			if (i == 0) {
				dp[i] = 1;
			}
			for (int j = 1; j <= 3 && i >= j; ++j) {
				dp[i] = (dp[i] % mod + dp[i - j] % mod) % mod;
			}
		}
		// for (int i = 0; i < dp.length; ++i) {
		// System.out.print(dp[i]);
		// }
		return dp[dp.length - 1];
	}

	private static int change_perm(int[] coins, int target) {
		// TODO Auto-generated method stub
		int[] dp = new int[target + 1];

		for (int i = 0; i < dp.length; ++i) {
			if (i == 0) {
				dp[i] = 1;
			}
			for (int j = 0; j < coins.length && i >= coins[j]; ++j) {
				dp[i] += dp[i - coins[j]];
			}
		}
		// for (int i = 0; i < dp.length; ++i) {
		// System.out.print(dp[i]);
		// }
		return dp[dp.length - 1];
	}

	private static int change_com(int[] coins, int target) {
		// TODO Auto-generated method stub
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; ++i) {
			for (int j = 1; j < dp.length; ++j) {
				if (j >= coins[i])
					dp[j] += dp[j - coins[i]];
			}
		}
		return dp[dp.length - 1];
	}

}
