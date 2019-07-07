package dp;

public class combinationSum4 {
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];

		dp[0] = 1;

		// for(int val : nums){
		// for(int i=val;i<dp.length;++i){
		// dp[i]+=dp[i-val];
		// }
		// }

		for (int i = 1; i < dp.length; ++i) {
			for (int val : nums) {
				if (i - val >= 0) {
					dp[i] += dp[i - val];
				}
			}
		}
		return dp[target];
	}
}
