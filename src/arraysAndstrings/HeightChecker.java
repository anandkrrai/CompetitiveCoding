package arraysAndstrings;

import java.util.Arrays;

public class HeightChecker {

	public static int minNum(int[] arr) {
		int[] dp = new int[arr.length];
		
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] <= arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			++dp[i];

		}
		return dp.length - dp[dp.length - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 4, 2, 1, 3 };
		System.out.println(minNum(arr));
	}

}
