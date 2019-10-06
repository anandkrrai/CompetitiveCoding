package arraysAndstrings;

public class LongestIncreasingSubSequence {
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int rv = 0, count = 1;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > nums[i - 1]) {
				++count;
			} else {
				rv = Math.max(rv, count);
				count = 1;
			}
		}
		return Math.max(rv, count);
	}
}
