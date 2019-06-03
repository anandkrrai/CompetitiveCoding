package cc;

public class queen {
	public static void printNQueens(boolean[][] board, int row, String qpsf) {
		if (row == board.length) {
			System.out.println(qpsf);
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isItSafeForQueen(board, row, col) == true) {
				board[row][col] = true;
				printNQueens(board, row + 1, qpsf + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}
	}

	private static boolean isItSafeForQueen(boolean[][] board, int row, int col) {
		// column
		int r = row, c = col;
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}

		// positive diagonal
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		// negative diagonal
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		return true;
	}

}
