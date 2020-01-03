package dp;

import java.util.LinkedList;

public class SnakeAndLadder {

	public static int index(int num, int[][] arr) {
		int n = arr.length, row = num / n, col = num % n;
		if (num == n * n)
			return num;
//		if (row % 2 == 0) {
//			col = (n - col) % n;
//		}
		System.out.println(num + " " + row + " " + col);

		if (arr[row][col] == -1)
			return num;
		else
			return arr[row][col];
	}

	public static class Pair {
		int n, steps;

		public Pair(int n, int steps) {
			this.n = n;
			this.steps = steps;
		}
	}

	public static int snakesAndLadders(int[][] board) {
		for (int j = 0; j < board.length; ++j) {
			int i = 0, k = board.length - 1;
			while (i < k) {
				int temp = board[i][j];
				board[i][j] = board[k][j];
				board[k][j] = temp;
				++j;
				--k;
			}
		}
		for (int i = board.length % 2 == 0 ? 0 : 1; i < board.length; i += 2) {
			int j = 0, k = board.length - 1;
			while (j < k) {
				int temp = board[i][j];
				board[i][j] = board[i][k];
				board[i][k] = temp;
				++j;
				--k;
			}
		}
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(1, 0));
		int n = board.length;
		boolean[] visited = new boolean[n * n + 1];

		while (q.size() != 0) {
			Pair rem = q.removeFirst();
			if (rem.n == n * n) {
				return rem.steps;
			}
			if (visited[rem.n])
				continue;
			visited[rem.n] = true;
			for (int i = 1; i <= 6 && rem.n + i <= n * n; ++i) {
				q.addLast(new Pair(index(rem.n + i, board), rem.steps + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) {

//		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
//				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		
		int[][] 
		System.out.println(snakesAndLadders(board));
	}

}
