package graphs;

public class surroundingRegions {
	public void solve(char[][] board) {

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
					bfs(board, '$', i, j);
				}
			}
		}

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] != 'O') {
					continue;
				}
				bfs(board, 'X', i, j);
			}
		}

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == '$')
					board[i][j] = 'O';
			}
		}
	}

	public void bfs(char[][] board, char rep, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		} else if (board[i][j] == 'X' || board[i][j] == '$') {
			return;
		} else {
			board[i][j] = rep;
			bfs(board, rep, i - 1, j);
			bfs(board, rep, i + 1, j);
			bfs(board, rep, i, j - 1);
			bfs(board, rep, i, j + 1);
		}
	}
}
