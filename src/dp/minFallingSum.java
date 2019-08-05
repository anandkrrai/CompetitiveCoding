package dp;

public class minFallingSum {

	public boolean isValid(int[][] A, int i, int j) {
		if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
			return false;
		} else {
			return true;
		}
	}

	public int minFallingPathSum(int[][] A) {
		if (A == null || A.length == 0)
			return 0;
		int rv = 0;

		for (int i = A.length - 2; i >= 0; --i) {
			for (int j = 0; j < A[0].length; ++j) {
				int temp = A[i][j];
				A[i][j] = Integer.MAX_VALUE;

				if (isValid(A, i + 1, j)) {
					A[i][j] = Math.min(A[i + 1][j], A[i][j]);
				}
				if (isValid(A, i + 1, j + 1)) {
					A[i][j] = Math.min(A[i + 1][j + 1], A[i][j]);
				}
				if (isValid(A, i + 1, j - 1)) {
					A[i][j] = Math.min(A[i + 1][j - 1], A[i][j]);
				}
				A[i][j] += temp;
			}
		}
		rv = A[0][0];
		for (int i = 0; i < A[0].length; ++i) {
			rv = Math.min(rv, A[0][i]);
		}

		return rv;
	}
}
