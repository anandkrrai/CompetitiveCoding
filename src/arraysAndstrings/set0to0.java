package arraysAndstrings;

public class set0to0 {
	public static void setZeroes(int[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < matrix.length; ++k) {
						if (matrix[k][j] == 0) {
							continue;
						} else {
							matrix[k][j] = -1;
						}
					}

					for (int k = 0; k < matrix[0].length; ++k) {
						if (matrix[i][k] == 0) {
							continue;
						} else {
							matrix[i][k] = -1;
						}
					}
				}
			}
		}
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == -1)
					matrix[i][j] = 0;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }};
		setZeroes(arr);
	}
}
