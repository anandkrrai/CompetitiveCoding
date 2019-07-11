package arraysAndstrings;

import java.util.*;

public class sudoku {

	public boolean checkBolck(char[][] board, int row, int col) {
		HashSet<Character> set = new HashSet<>();
		for (int i = row; i < row + 3; ++i) {
			for (int j = col; j < col + 3; ++j) {
				char ch = board[i][j];
				if (ch == '.')
					continue;
				else if (set.contains(ch))
					return false;
				else
					set.add(ch);
			}
		}
		return true;
	}

	public boolean checkRow(char[][] board) {
		for (int i = 0; i < board.length; ++i) {
			HashSet<Character> set = new HashSet<>();
			for (int j = 0; j < board[0].length; ++j) {
				char ch = board[i][j];
				if (ch == '.')
					continue;
				else if (set.contains(ch))
					return false;
				else
					set.add(ch);
			}
		}
		return true;
	}

	public boolean checkCol(char[][] board) {
		for (int i = 0; i < board.length; ++i) {
			HashSet<Character> set = new HashSet<>();
			for (int j = 0; j < board.length; ++j) {
				char ch = board[j][i];
				if (ch == '.')
					continue;
				else if (set.contains(ch))
					return false;
				else
					set.add(ch);
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		boolean rv = checkCol(board);
		if (!rv)
			return false;

		rv = checkRow(board);
		if (!rv)
			return false;

		int[] x = { 0, 3, 6 };
		int[] y = { 0, 3, 6 };

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				rv = checkBolck(board, x[i], y[j]);
				if (!rv)
					return false;
			}
		}

		return true;
	}
}
