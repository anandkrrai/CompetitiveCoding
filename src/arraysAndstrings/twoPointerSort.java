package arraysAndstrings;

import java.util.Arrays;

public class twoPointerSort {

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void sortColors(int[] nums) {
		int i = 0, j = 0, k = nums.length - 1;

		while (j <= k) {
			if (nums[j] == 0) {
				swap(nums, i, j);
				++i;
				++j;
			} else if (nums[j] == 2) {
				swap(nums, j, k);
				--k;
			} else {
				++j;
			}

		}
	}

	public static void print(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0 };
		print(arr);
//		sortColors(arr);
		sort012(arr, arr.length);
		print(arr);
	}

}
