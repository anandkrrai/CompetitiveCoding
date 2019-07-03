package arraysAndstrings;

public class searchInSortedArray {
	public static int binarySearch(int[] arr, int target) {
		int lo = 0, hi = arr.length - 1, mid;

		while (lo <= hi) {
			mid = (lo + hi) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] rv = new int[2];
		rv[0] = rv[1] = -1;

		rv[0] = binarySearch(nums, target);
		if (rv[0] == -1)
			return rv;

		rv[1] = rv[0];

		while (rv[0] - 1 >= 0) {
			if (nums[rv[0] - 1] == target) {
				rv[0]--;
			} else {
				break;
			}
		}

		while (rv[1] + 1 < nums.length) {
			if (nums[rv[1] + 1] == target) {
				rv[1]++;
			} else {
				break;
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 10 };

//		System.out.println(binarySearch(arr, 10));

		int[] r = searchRange(arr, 10);

		System.out.println(r[0] + " " + r[1]);
	}

}
