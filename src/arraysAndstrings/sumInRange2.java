package arraysAndstrings;

public class sumInRange2 {
	public static int sumLessThanK(int[] nums, int k) {
		int sum = 0, start = 0, end = 0, rv = 0;

		for (end = 0; end < nums.length; ++end) {
			rv += end - start;
			sum += nums[end];
			while (sum > k && start <= end) {
				sum -= nums[start];
				++start;
			}
		}
		rv += end - start;
		return rv;
	}

	public static int countRangeSum(int[] arr, int L, int R) {
		int Rcnt = sumLessThanK(arr, R);
		int Lcnt = sumLessThanK(arr, L - 1);
		return Rcnt - Lcnt;
	}

	public static void main(String[] args) {
		int arr[] = { -2, 5, -1 };
		int L = -2;
		int R = 2;

		System.out.println(countRangeSum(arr, L, R));
	}

}
