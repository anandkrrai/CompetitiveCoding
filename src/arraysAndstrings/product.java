package arraysAndstrings;

import java.util.*;

public class product {
	public static int[] productExceptSelf(int[] nums) {
		int[] arr = new int[nums.length];

		Arrays.fill(arr, 1);
		for (int i = 1; i < nums.length; ++i) {
			arr[i] = arr[i - 1] * nums[i-1];
		}
		int prod = 1;
		for (int i = nums.length - 2; i >= 0; --i) {
			prod *= nums[i + 1];
			arr[i] = arr[i] * prod;
		}

		return arr;

	}

	// Don't make changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int Input[] = new int[n];
		for (int i = 0; i < n; i++) {
			Input[i] = scn.nextInt();
		}
		int ans[] = productExceptSelf(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}
