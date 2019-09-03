package arraysAndstrings;

public class LongestIncreasingPath {
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] arr = new int[matrix.length][matrix[0].length];

		int max = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				max = Math.max(max, Helper(matrix, arr, i, j));
			}
		}
		return max;
	}

	public int[] x = { 0, 0, -1, 1 };
	public int[] y = { -1, 1, 0, 0 };

	private int Helper(int[][] matrix, int[][] arr, int i, int j) {
		if (arr[i][j] != 0) {
			return arr[i][j];
		}
		int max = 0;
		for (int k = 0; k < 4; ++k) {
			if (isValid(arr, i + x[k], j + y[k])&& matrix[i + x[k]][j + y[k]] > matrix[i][j]) {
				max = Math.max(max, Helper(matrix, arr, i + x[k], j + y[k]));
			}
		}
		arr[i][j] = max + 1;
		return max + 1;
	}

	public boolean isValid(int[][] arr, int i, int j) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return false;
		} else {
			return true;
		}
	}
}
