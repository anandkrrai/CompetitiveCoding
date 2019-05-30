package cc;

import java.util.Arrays;

public class kNight {
	

	public static boolean isKvalid(int[][] arr, int row, int col) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return false;
		} else if (arr[row][col] != -1) {
			return false;
		} else {
			return true;
		}
	}


	static int count = 0;

	public static void KnightsTour(int[][] chess, int row, int col, int move) {

		if (move == chess.length * chess.length - 1) {
			count++;
			chess[row][col] = move;
			System.out.println("----------------------" + count + "----------------------");
			for (int i = 0; i < chess.length; ++i) {
				for (int j = 0; j < chess.length; ++j) {
					System.out.print(chess[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("----------------------" + count + "----------------------");
			chess[row][col] = -1;

			return;
		}

		chess[row][col] = move;
		if (isKvalid(chess, row - 2, col + 1)) {
			KnightsTour(chess, row - 2, col + 1, move + 1);
		}
		if (isKvalid(chess, row - 2, col - 1)) {
			KnightsTour(chess, row - 2, col - 1, move + 1);
		}
		if (isKvalid(chess, row + 2, col + 1)) {
			KnightsTour(chess, row + 2, col + 1, move + 1);
		}
		if (isKvalid(chess, row + 2, col - 1)) {
			KnightsTour(chess, row + 2, col - 1, move + 1);
		}
		if (isKvalid(chess, row + 1, col - 2)) {
			KnightsTour(chess, row + 1, col - 2, move + 1);
		}
		if (isKvalid(chess, row + 1, col + 2)) {
			KnightsTour(chess, row + 1, col + 2, move + 1);
		}
		if (isKvalid(chess, row - 1, col - 2)) {
			KnightsTour(chess, row - 1, col - 2, move + 1);
		}
		if (isKvalid(chess, row - 1, col + 2)) {
			KnightsTour(chess, row - 1, col + 2, move + 1);
		}
		chess[row][col] = -1;
	}

	public static void main(String[] args) {

		int[][] arr = new int[5][5];

		for (int i = 0; i < arr.length; ++i)
			Arrays.fill(arr[i], -1);

		KnightsTour(arr, 1, 1, 0);

	}
}
