package dp;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(find(nums, 0, nums.length - 2), find(nums, 1, nums.length - 1));
	}

	public int find(int[] arr, int lo, int hi) {
		int inc = 0, exc = 0;
		for (int i = lo; i <= hi; ++i) {
			int ninc = exc + arr[i];
			exc = Math.max(inc, exc);
			inc = ninc;
		}

		return Math.max(inc, exc);
	}
}
