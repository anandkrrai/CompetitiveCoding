package cc;

public class gfg_sum_in_sortedRotatedArray {

	public static void main(String[] args) {
		int arr[] = { 11, 15, 26, 38, 9, 10 };
		int sum = 47;

		int pivot = arr.length - 1;
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i + 1]) {
				pivot = i + 1;
				break;
			}
		}

		System.out.println(findsum(arr, pivot, sum));
	}

	private static boolean findsum(int[] arr, int pivot, int sum) {
		int lo = (0 + pivot) % arr.length, hi = (arr.length + pivot - 1) % arr.length;
		while (lo != hi) {
			if (arr[lo] + arr[hi] == sum) {
				return true;
			} else if (arr[lo] + arr[hi] > sum) {
				hi = (hi - 1 + arr.length) % arr.length;
			} else {
				lo = (lo + 1) % arr.length;
			}
		}

		return false;
	}

}
