package arraysAndstrings;

//https://leetcode.com/problems/jump-game-ii/submissions/
import java.util.Arrays;

public class jumpGame2 {
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < dp.length; ++i) {
			for (int j = 1; j <= nums[i] && i + j < dp.length; ++j) {
				dp[i + j] = Math.min(dp[i + j], 1 + dp[i]);
			}
		}
		return dp[dp.length - 1];
	}
}
