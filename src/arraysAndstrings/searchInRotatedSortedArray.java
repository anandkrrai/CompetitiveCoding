package arraysAndstrings;

//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class searchInRotatedSortedArray {
	public static int findPivoit(int[] arr) {
		int rv = 0;
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i + 1])
				return i;
		}

		return rv;
	}

	public static int binary_search(int[] arr, int l, int r, int target) {
		if (l > r)
			return -1;
		int mid = (l + r) / 2;
		if (target > arr[mid]) {
			return binary_search(arr, mid + 1, r, target);
		} else if (target < arr[mid]) {
			return binary_search(arr, l, mid - 1, target);
		} else {
			return mid;
		}
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;

		int pivoit = findPivoit(nums);
		int rv = binary_search(nums, 0, pivoit, target);
		if (rv != -1)
			return rv;

		return binary_search(nums, pivoit + 1, nums.length - 1, target);

	}
}
