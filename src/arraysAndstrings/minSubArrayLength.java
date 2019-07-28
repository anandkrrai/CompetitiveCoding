package arraysAndstrings;

public class minSubArrayLength {
	public int minSubArrayLen(int s, int[] nums) {
		int i = 0, j = 0, rv = Integer.MAX_VALUE, sum = 0;

		for (j = 0; j < nums.length; ++j) {
			sum += nums[j];

			while (i <= j && sum >= s) {
				rv = Math.min(j - i + 1, rv);
				sum -= nums[i];
				i++;

			}

		}
		if (rv == Integer.MAX_VALUE)
			return 0;
		return rv;
	}
}
