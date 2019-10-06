package dp;

public class MaximumSubsequenceWithout3consiqutiveNumber {

	public static void main(String[] args) {

		int[] arr = {};
		int[] ret = find(arr, 0);
	}

	/*
	 * 1. l2 
	 * 2. M 
	 * 3. r2
	 */

	private static int[] find(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return new int[] { 0, 0, 0 };
		}

		int[] rv = find(arr, vidx + 1);
		int[] mv = { 0, 0, 0 };
		mv[0]=rv[1]+arr[vidx];
		mv[1]=Math.max(arr[vidx], arr[vidx]+rv[1]);
		return mv;
	}

}
