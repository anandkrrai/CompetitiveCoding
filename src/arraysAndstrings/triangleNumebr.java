package arraysAndstrings;

import java.util.*;

public class triangleNumebr {

	public static int binarySearch(int[] arr, int left, int right, int limit) {

		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] > limit) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public int triangleNumber(int[] nums) {
		int rv = 0;
		Arrays.sort(nums);

		int right;
		for (int i = 0; i < nums.length - 2; ++i) {
			right = i + 2;
			for (int j = i + 1; j < nums.length - 1; ++j) {
				right = binarySearch(nums, right, nums.length - 1, nums[i] + nums[j]);
				rv += right - j - 1;
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
