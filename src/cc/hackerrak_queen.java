package cc;

import java.util.Arrays;

public class hackerrak_queen {
	// Complete the queensAttack function below.
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		boolean[][] board = new boolean[n + 1][n + 1];

		Arrays.fill(board, true);

		for (int i = 0; i < obstacles.length; ++i) {
			board[obstacles[i][0]][obstacles[i][1]] = false;
		}

		int rv = 0;

		// down
		int i = r_q, j = c_q;
		++i;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			++i;
		}

		i = r_q;
		j = c_q;
		--i;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			--i;
		}

		i = r_q;
		j = c_q;
		++j;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			++j;
		}

		i = r_q;
		j = c_q;
		--j;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			--j;
		}

		i = r_q;
		j = c_q;
		++i;
		++j;

		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			++i;
			++j;

		}

		i = r_q;
		j = c_q;
		++i;
		--j;

		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			++i;
			--j;

		}

		i = r_q;
		j = c_q;
		--i;
		++j;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			--i;
			++j;

		}

		i = r_q;
		j = c_q;
		--i;
		--j;
		while (i > 0 && i <= n && j > 0 && j <= n && board[i][j]) {
			++rv;
			--i;
			--j;

		}

		return rv;

	}
	
	public static void main(String[] args) {
		
		int k=0;
		int[][] obstacles=new int[k][2];
		queensAttack(100000, k, 4187, 5068, obstacles);
	}
}
