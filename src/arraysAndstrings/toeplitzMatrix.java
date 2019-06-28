package arraysAndstrings;

import java.util.Scanner;

public class toeplitzMatrix {
	public static boolean isToeplitzMatrix(int[][] mat) {

		for (int i = 0; i < mat.length - 2; ++i) {
			for (int j = 0; j < mat[0].length - 2; ++j) {
				if (mat[i][j] != mat[i + 1][j + 1])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(isToeplitzMatrix(arr));
	}
}
