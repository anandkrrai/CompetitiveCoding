package arraysAndstrings;

import java.util.*;

public class sortTransform {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}
		Arrays.sort(nums);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		int[] res = sortTransformedArray(nums, a, b, c);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and 3 integers
	// It should return an integeral array

	public static int[] sortTransformedArray(int[] num, int a, int b, int c) {
		// Write your code here

		int hi = num.length - 1, lo = 0, k = num.length - 1, temp;
		int[] arr = new int[num.length];
		if (a > 0) {
			while (lo <= hi) {
				int temp1 = a * num[lo] * num[lo] + b * num[lo] + c;
				int temp2 = a * num[hi] * num[hi] + b * num[hi] + c;
				if (temp1 > temp2) {
					arr[k] = temp1;
					++lo;
				} else {
					arr[k] = temp2;
					--hi;
				}

				--k;
			}
		} else {
			k = 0;
			while (lo <= hi) {
				int temp1 = a * num[lo] * num[lo] + b * num[lo] + c;
				int temp2 = a * num[hi] * num[hi] + b * num[hi] + c;

				if (temp1 <= temp2) {
					arr[k] = temp1;
					++lo;
				} else {
					arr[k] = temp2;
					--hi;
				}
				++k;
			}
		}

		return arr;
	}

}