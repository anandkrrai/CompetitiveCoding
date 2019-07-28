package arraysAndstrings;

public class maxInBoundsSubArray {
	public static int find(int n) {
		return (n * (n + 1)) / 2;
	}

	public static int numSubarrayBoundedMax(int[] arr, int lo, int hi) {
		int inc = 0, rv = 0, exc = 0;

		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] > hi) {
				rv += find(inc) - find(exc);
				inc = 0;
				exc = 0;
			} else if (arr[i] < lo) {
				++exc;
				++inc;
			} else {
				++inc;
				rv -= find(exc);
				exc = 0;
			}
		}
		rv += find(inc) - find(exc);
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 9, 2, 5, 6 };
		System.out.println(numSubarrayBoundedMax(arr, 2, 8));
	}

}
