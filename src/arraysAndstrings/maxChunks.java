package arraysAndstrings;

import java.util.*;

public class maxChunks {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		System.out.println(maxChunksToSorted(a));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written
	// This function takes as input an array
	// It should return required output

	public static int maxChunksToSorted(int[] arr) {
		// Write your code here
		int rv = 0;
		int[] min = new int[arr.length];
		int[] max = new int[arr.length];

		max[0] = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; ++i) {
			max[i] = Math.max(max[i - 1], arr[i]);
		}

		min[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; --i) {
			min[i] = Math.min(arr[i], min[i + 1]);
		}

		for (int i = 0; i < arr.length; ++i) {
			if (max[i] <= min[i]) {
				++rv;
			}
		}
		return rv;
	}

}