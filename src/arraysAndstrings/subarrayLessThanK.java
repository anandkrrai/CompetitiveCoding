package arraysAndstrings;

public class subarrayLessThanK {

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int i = 0, j = 0, prod = 1, count = 0;

		while (j < nums.length) {
			prod *= nums[j++];
			while (i <= j && prod >= k) {
				count += j - i - 1;
				prod /= nums[i++];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 };
//		int[] arr = { 1, 1, 1 };
		int k = 19;
		System.out.println(numSubarrayProductLessThanK(arr, k));
	}

}
