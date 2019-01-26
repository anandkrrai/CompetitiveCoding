package cc;

import java.util.Scanner;

public class gfg_rotateMatrix {

	private static void rotate(int[][] mat) {

		int n = mat.length, m = mat[0].length;
		int row = 0, col = 0, curr, prev;
		while (row <= n && col <= m) {

			if (row + 1 == m || col + 1 == n)
				break;

			// Store the first element of next
			// row, this element will replace
			// first element of current row
			prev = mat[row + 1][col];

			// Move elements of first row
			// from the remaining rows
			for (int i = col; i < n; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}
			printArr(mat);
			row++;

			// Move elements of last column
			// from the remaining columns
			for (int i = row; i < m; i++) {
				curr = mat[i][n - 1];
				mat[i][n - 1] = prev;
				prev = curr;
			}
			n--;

			// Move elements of last row
			// from the remaining rows
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = mat[m - 1][i];
					mat[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;

			// Move elements of first column
			// from the remaining rows
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}

	}

	private static void printArr(int[][] arr) {

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void InputArr(int[][] arr) {

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printArr(a);
		rotate(a);
		printArr(a);
		Scanner scan = new Scanner(System.in);
//		int t = scan.nextInt();
//		while (t-- > 0) {
//			int n = scan.nextInt();
//			int m = scan.nextInt();
//			int[][] arr = new int[n][m];
//
//			InputArr(arr);
//			rotate(arr);
//			printArr(arr);
//
//		}
//
		scan.close();
	}

}
