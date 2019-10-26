package arraysAndstrings;

public class MaxSubarrayProduct {
	public static int maxProduct(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int flag = 0, rv = 1, min = 1, zero = 0, max = 1, temp;
		for (int val : nums) {
			if (val > 0) {
				max = max * val;
				min = Math.min(1, val * min);
				flag = 1;
			} else if (val == 0) {
				min = 1;
				max = 1;
				zero = 1;
			} else {
				temp = max;
				max = Math.max(1, min * val);
				min = temp * val;
			}

			rv = Math.max(rv, max);
		}

		return rv;
	}

	static int min(int x, int y) {
		return x < y ? x : y;
	}

	// Utility functions to get maximum of two integers
	static int max(int x, int y) {
		return x > y ? x : y;
	}

	static int maxSubarrayProduct(int arr[]) {
		int n = arr.length;
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = 1;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				max_ending_here = max_ending_here * arr[i];
				min_ending_here = min(min_ending_here * arr[i], 1);
				flag = 1;
			} else if (arr[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else {
				int temp = max_ending_here;
				max_ending_here = max(min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}

			// update max_so_far, if needed
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}

		if (flag == 0 && max_so_far == 1)
			return 0;
		return max_so_far;
	}
	int i;
	public void k(int i) {
		i=i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1};
		System.out.println(maxProduct(arr));
		System.out.println(maxSubarrayProduct(arr));
	}

}
