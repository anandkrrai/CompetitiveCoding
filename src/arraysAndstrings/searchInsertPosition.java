package arraysAndstrings;
//https://leetcode.com/problems/search-insert-position/
public class searchInsertPosition {
	public static int searchInsert(int[] arr, int target) {
		int rv = binarySearch(arr, target);
		if (arr[rv] == target) {

		} else if (arr[rv] < target) {
			++rv;
		} else {
			// arr[rv]<target
		}

		return rv;
	}

	public static int binarySearch(int[] arr, int target) {
		int lo = 0, hi = arr.length - 1, mid = (lo + hi) / 2;

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
		return mid;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 10 };
		System.out.println(searchInsert(arr, 0));
	}

}
