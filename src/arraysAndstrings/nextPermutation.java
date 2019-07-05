package arraysAndstrings;

import java.util.*;

public class nextPermutation {

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;

		while (i > 0 && nums[i] >= nums[i + 1])
			--i;

//		if (i == 0) {
////			Arrays.sort(nums);
//			return;
//		}

		int x = i + 1, j = i + 2;
		while (j < nums.length) {
			if (nums[j] > nums[i] && nums[j] < nums[x])
				x = j;
			++j;
		}

		int temp = nums[x];
		nums[x] = nums[i];
		nums[i] = temp;

		Arrays.sort(nums, i + 1, nums.length);
	}

	public static void main(String[] args) {
		int[] arr = { 5,4,3,2,1 };
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
		nextPermutation(arr);
		for (int val : arr)
			System.out.print(val + " ");
	}

}
