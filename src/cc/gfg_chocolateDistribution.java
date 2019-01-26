package cc;

import java.util.Arrays;

public class gfg_chocolateDistribution {
//	https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
	public static void main(String[] args) {

		int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
		int m = 7; // Number of students

		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= arr.length - m; ++i) {
			if (min > arr[i + m - 1] - arr[i]) {
				min = arr[i + m - 1] - arr[i];
			}
		}

		System.out.println(min);
	}

}
