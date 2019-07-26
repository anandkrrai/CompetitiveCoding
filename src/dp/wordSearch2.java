package dp;

import java.util.*;

public class wordSearch2 {
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> rv = new ArrayList<>();

		for (String word : words) {
			for (int i = 0; i < board.length; ++i) {
				for (int j = 0; j < board[0].length; ++j) {
					if (find(board, word, i, j))
						rv.add(word);
				}
			}
		}
		return rv;
	}

	private static boolean find(char[][] board, String word, int i, int j) {
		if (word.length() == 0)
			return true;

		if (board[i][j] != word.charAt(0))
			return false;
		if (word.length() == 1)
			return true;
		char ch = board[i][j];
		board[i][j] = '$';

		boolean rv = false;

		if (isValid(board, i, j + 1)) {
			rv = rv || find(board, word.substring(1), i, j + 1);
			if (rv)
				return rv;
		}
		if (!rv && isValid(board, i + 1, j)) {
			rv = rv || find(board, word.substring(1), i + 1, j);
			if (rv)
				return rv;
		}
		if (isValid(board, i - 1, j)) {
			rv = rv || find(board, word.substring(1), i - 1, j);
			if (rv)
				return rv;
		}
		if (isValid(board, i, j - 1)) {
			rv = rv || find(board, word.substring(1), i, j - 1);
			if (rv)
				return rv;
		}
		board[i][j] = ch;
		return rv;
	}

	private static boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if (board[i][j] == '$')
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
