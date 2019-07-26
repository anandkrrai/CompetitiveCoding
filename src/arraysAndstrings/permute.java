package arraysAndstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {

	public static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public static void permutation(int[] arr, int left, int right) {
		if (left == right) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = left; i <= right; ++i) {
			swap(arr, i, left);
			permutation(arr, left + 1, right);
			swap(arr, i, left);

		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		permutation(arr, 0, arr.length - 1);
	}

	public static void permutation(int[] arr, int left, int right, List<List<Integer>> list) {
		if (left == right) {
			List<Integer> lis = new ArrayList<Integer>();
			for (int val : arr)
				lis.add(val);
			list.add(lis);
			return;
		}

		for (int i = left; i <= right; ++i) {
			swap(arr, i, left);
			permutation(arr, left + 1, right, list);
			swap(arr, i, left);

		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permutation(nums, 0, nums.length - 1, list);
		return list;
	}
}
