package dp;

public class TargetSum {

	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int val : nums)
			sum += val;

		if (sum % 2 != 0)
			return false;

		int S = sum / 2;
		boolean[][] dp = new boolean[nums.length + 1][S + 1];

		for (int i = 0; i < dp.length; ++i)
			dp[i][0] = true;

		for (int i = 1; i < dp.length; ++i) {
			for (int j = 1; j <= S; ++j) {
				dp[i][j] = dp[i - 1][j];
				if (j >= nums[i - 1])
					dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
			}
		}

		return dp[dp.length - 1][S];
	}

	static int findMinSumPartition(int nums[]) {

		int sum = 0;
		for (int val : nums)
			sum += val;

		boolean[] arr = new boolean[sum + 1 / 2];
		arr[0] = true;

		for (int i = 0; i < arr.length; ++i) {
			for (int num : nums) {
				if (i - num >= 0 && arr[i - num]) {
					arr[i] = true;
				}
			}
		}
		int rv = sum;

		for (int i = 0; i < arr.length; ++i) {
			if (arr[i])
				rv = Math.min(rv, Math.abs(sum - 2 * i));
		}
		return rv;
	}

	public static void main(String[] args) {
		int[] nums = { 30, 37, 11, 15, 22, 11, 5, 29 };
		System.out.println(findMinSumPartition(nums));
	}

}
