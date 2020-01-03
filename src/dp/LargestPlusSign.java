package dp;

import java.util.Arrays;

public class LargestPlusSign {

	public static void print(int[][] arr) {
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] down = new int[N][N];
		int[][] up = new int[N][N];
		int[][] left = new int[N][N];
		int[][] right = new int[N][N];
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; ++i)
			Arrays.fill(arr[i], 1);
		for (int[] mine : mines)
			arr[mine[0]][mine[1]] = 0;

		for (int i = 0; i < N; ++i) {
			for (int j = 1; j < N; ++j) {
				left[i][j] = arr[i][j - 1] == 1 ? 1 + left[i][j - 1] : 0;
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = N - 2; j >= 0; --j) {
				right[i][j] = arr[i][j + 1] == 1 ? 1 + right[i][j + 1] : 0;
			}
		}

		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				up[i][j] = arr[i - 1][j] == 1 ? 1 + up[i - 1][j] : 0;
			}
		}

		for (int i = N - 2; i >= 0; --i) {
			for (int j = 0; j < N; ++j) {
				down[i][j] = arr[i + 1][j] == 1 ? 1 + down[i + 1][j] : 0;
			}
		}

		print(arr);
		print(right);
		print(left);
		print(up);
		print(down);

		int max = 0;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] == 1) {
					max = Math.max(max,
							1 + Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j])));
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {

		int[][] mines = { { 0, 2 }, { 0, 4 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 4, 2 }, { 4, 4 } };
		int N = 5;
		System.out.println(orderOfLargestPlusSign(N, mines));
	}

}
