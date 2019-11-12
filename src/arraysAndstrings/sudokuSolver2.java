package arraysAndstrings;

import java.util.*;

public class sudokuSolver2 {
	public static void solveSudoku(char[][] board) {
		rNonOptions = new HashSet[9];
		cNonOptions = new HashSet[9];
		smNonOptions = new HashSet[3][3];

		for (int i = 0; i < 9; ++i) {
			rNonOptions[i] = new HashSet<>();
			cNonOptions[i] = new HashSet<>();
			smNonOptions[i / 3][i % 3] = new HashSet<>();
		}

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] != '.') {
					rNonOptions[i].add(board[i][j]);
					cNonOptions[j].add(board[i][j]);
					smNonOptions[i / 3][j / 3].add(board[i][j]);
				}
			}
		}
		solve(board, 0);
	}

	static HashSet<Character>[] rNonOptions;
	static HashSet<Character>[] cNonOptions;
	static HashSet<Character>[][] smNonOptions;
	static char[] Char = { '.', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static boolean isValid(int row, int col, char ch) {
		if (rNonOptions[row].contains(ch)) {
			return false;
		} else if (cNonOptions[col].contains(ch)) {
			return false;
		} else if (smNonOptions[row / 3][col / 3].contains(ch)) {
			return false;
		} else {
			return true;
		}
	}

	public static void set(char[][] board, int row, int col, char ch) {
		board[row][col] = ch;
		rNonOptions[row].add(ch);
		cNonOptions[col].add(ch);
		smNonOptions[row / 3][col / 3].add(ch);
	}

	public static void reset(char[][] board, int row, int col, char ch) {
		board[row][col] = '.';
		rNonOptions[row].remove(ch);
		cNonOptions[col].remove(ch);
		smNonOptions[row / 3][col / 3].remove(ch);
	}

	public static boolean solve(char[][] board, int vidx) {
		if (vidx == 81)
			return true;

		int row = vidx / 9;
		int col = vidx % 9;

		if (board[row][col] == '.') {
			for (int i = 1; i <= 9; ++i) {
				if (isValid(row, col, Char[i])) {
					set(board, row, col, Char[i]);
					boolean bool = solve(board, vidx + 1);
					if (bool)
						return true;
					reset(board, row, col, Char[i]);
				}
			}
		} else {
			return solve(board, vidx + 1);
		}
		return false;
	}
}
