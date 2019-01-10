package cc;

import java.util.Scanner;

public class hackerearth_monk {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					arr[i][j] = scan.nextInt();
				}
			}

			int count = 0;

			for (int i = 0; i < arr.length; ++i) {
				for (int j = 0; j < arr.length; ++j) {
					for (int k = 0; k <= i; ++k) {
						for (int l = 0; l <= j; ++l) {
							if (arr[k][l] > arr[i][j]) {
								++count;
							}
						}
					}
				}
			}

			System.out.println(count);

		}
		scan.close();
	}

}

//
//
//board[0][0] = arr[0][0];
//int count = 0;
//
//for (int i = 1; i < n; ++i) {
//	board[0][i] = Math.max(board[0][i - 1], arr[0][i]);
//	board[i][0] = Math.max(board[i - 1][0], arr[i][0]);
//	if (board[i][0] > arr[i][0]) {
//		++count;
//	}
//	if (board[0][i] > arr[0][i]) {
//		++count;
//	}
//}
//
//for (int i = 1; i < n; ++i) {
//	for (int j = 1; j < n; ++j) {
//		board[i][j] = Math.max(Math.max(board[i][j], board[i - 1][j]), board[j][j - 1]);
//		if (board[i][j] > arr[i][j]) {
//			++count;
//		}
//	}
//}
//
//System.out.println(count);