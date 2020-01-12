package arraysAndstrings;

public class matrixKSum {

	public int[][] matrixBlockSum(int[][] mat, int K) {
		int[][] arr = new int[mat.length][mat[0].length];

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				for (int i1 = Math.max(0, i - K); i1 <= Math.min(i + K, mat.length); ++i1) {
					for (int j1 = Math.max(0, j - K); j1 <= Math.min(j + K, mat.length); ++j1) {
						arr[i][j] += mat[i][j];
					}
				}
			}
		}
		return arr;
	}
}
