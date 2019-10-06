package dp;

public class NumberOfLIS {
	public static int findNumberOfLIS(int[] nums) {
		int[] len = new int[nums.length];
		int[] count = new int[nums.length];
		int max = 0, rv = 0;

		for (int i = 0; i < nums.length; ++i) {
			len[i] = 1;
			count[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j]) {
					if (len[i] <= len[j]) {
						len[i] = 1 + len[j];
						count[i] = count[j];
					} else if (len[i] == len[j] + 1) {
						count[i] += count[j];
					}
				}
			}
			max = Math.max(max, len[i]);
		}
		for (int i = 0; i < nums.length; ++i) {
			if (max == len[i])
				++rv;
		}
		return rv;
	}
	public static void main(String[] args) {
		int[] arr  = {1,3,5,4,7};
		findNumberOfLIS(arr);
	}
}
