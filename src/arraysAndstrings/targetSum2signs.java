package arraysAndstrings;

public class targetSum2signs {
	public int findTargetSumWays(int[] nums, int S) {
		return sumWays(nums, S, 0, 0);
	}

	public int sumWays(int[] nums, int S, int sum, int vidx) {
		if (vidx == nums.length) {
			if (sum == S) {
				return 1;
			} else
				return 0;
		}

		return sumWays(nums, S, sum + nums[vidx], vidx + 1) + sumWays(nums, S, sum - nums[vidx], vidx + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
