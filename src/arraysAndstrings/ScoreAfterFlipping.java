package arraysAndstrings;

public class ScoreAfterFlipping {
	public static void flipRow(int[][] A, int row) {
		for (int i = 0; i < A[0].length; ++i) {
			A[row][i] = A[row][i] == 0 ? 1 : 0;
		}
	}

	public static void flipCol(int[][] A, int col) {
		for (int i = 0; i < A.length; ++i) {
			A[i][col] = A[i][col] == 0 ? 1 : 0;
		}
	}

	public static int matrixScore(int[][] A) {
		int nos = 0;
		if (A.length == 0)
			return 0;

		for (int i = 0; i < A.length; ++i) {
			if (A[i][0] == 0) {
				flipRow(A, i);
			}
		}

		for (int j = 0; j < A[0].length; ++j) {
			nos = 0;
			for (int i = 0; i < A.length; ++i) {
				if (A[i][j] == 1)
					++nos;
			}
			if (2 * nos < A[0].length ) {
				flipCol(A, j);
			}
		}

		int rv = 0;
		for (int i = 0; i < A.length; ++i) {
			int num = 0;
			for (int j = 0; j < A[0].length; ++j) {
				num = num * 2 + A[i][j];
			}
			rv += num;
		}
		// display(A);
		return rv;
	}

	public static void display(int[][] A) {
		for (int[] vals : A) {
			for (int val : vals) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
		matrixScore(A);
	}

}
