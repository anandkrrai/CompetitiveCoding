package dp;

import java.util.*;

public class SubMatricesWithTargetSum {

	public static void makeMatrix(int[][] dp, int[][] matrix) {
		for (int j = 0; j < dp[0].length; ++j) {
			for (int i = 0; i < dp.length; ++i) {
				if (i == 0) {
					dp[i][j] = matrix[i][j];
				} else {
					dp[i][j] = dp[i - 1][j] + matrix[i][j];
				}
			}
		}

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 1; j < dp[0].length; ++j) {
				dp[i][j] += dp[i][j - 1];
			}
		}
	}

	public static int numSubmatrixSumTarget(int[][] matrix, int target) {
		int[][] arr = new int[matrix.length][matrix[0].length];
		makeMatrix(arr, matrix);
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				count += map.getOrDefault(arr[i][j] - target, 0);
				map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 0, 1, 0 }, 
				{ 1, 1, 1 }, 
				{ 0, 1, 0 } };

		System.out.println(numSubmatrixSumTarget(matrix, 0));
	}

}
