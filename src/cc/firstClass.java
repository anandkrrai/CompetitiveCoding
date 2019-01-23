package dp;

public class firstClass {

	public static int ClimbStair(int n, int[] dp) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n < 2) {
			return n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int ans;
		ans = ClimbStair(n - 1, dp) + ClimbStair(n - 2, dp) + ClimbStair(n - 3, dp);

		dp[n] = ans;

		return ans;

	}

	public static int countPath(int r, int c) {
		int[][] arr = new int[r + 1][c + 1];
		for (int i = r; i >= 0; --i) {
			for (int j = c; j >= 0; --j) {
				if (i == r && j == c) {
					arr[i][j] = 1;
				} else if (i == r) {
					arr[i][j] = 1;
				} else if (j == c) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
				}

			}
		}

		return arr[0][0];
	}

	public static int MincostPath(int[][] board) {
		int r = board.length - 1, c = board[0].length - 1;
		for (int i = r; i >= 0; --i) {
			for (int j = c; j >= 0; --j) {
				if (i == r && j == c) {
//					board[i][j] = 1;
				} else if (i == r) {
					board[i][j] += board[i][j + 1];
				} else if (j == c) {
					board[i][j] += board[i + 1][j];
				} else {
					board[i][j] = Math.min(board[i + 1][j], board[i][j + 1]) + board[i][j];
				}

			}
		}

		MincostPathPrint(board, 0, 0, "");
		return board[0][0];
	}

	public static void MincostPathPrint(int[][] board, int r, int c, String psf) {
		if (r == board.length - 1 && c == board[0].length - 1) {
			System.out.println(psf);
		} else if (r == board.length - 1) {
			MincostPathPrint(board, r, c + 1, psf + "H");
		} else if (c == board[0].length - 1) {
			MincostPathPrint(board, r + 1, c, psf + "V");

		} else {
			if (board[r][c + 1] > board[r + 1][c]) {
				MincostPathPrint(board, r + 1, c, psf + "V");

			} else if (board[r][c + 1] < board[r + 1][c]) {
				MincostPathPrint(board, r, c + 1, psf + "H");

			} else {
				MincostPathPrint(board, r, c + 1, psf + "H");
				MincostPathPrint(board, r + 1, c, psf + "V");

			}
		}

	}

	public static void main(String[] args) {

//		int n = 7;
//		System.out.println(countPath(3, 3));
//		System.out.println(ClimbStair(n, new int[n + 1]));

		int[][] board = { { 2, 3, 6, 8, 1 }, { 7, 9, 4, 0, 4 }, { 4, 5, 9, 3, 7 }, { 5, 1, 0, 8, 4 }, { 1, 3, 8, 7, 6 },
				{ 8, 7, 0, 5, 1 }, { 0, 9, 6, 3, 2 } };

		System.out.println(MincostPath(board));

	}

}
