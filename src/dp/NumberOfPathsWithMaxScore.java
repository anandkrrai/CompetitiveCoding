package dp;

import java.util.*;

public class NumberOfPathsWithMaxScore {
	public static class Pair {
		int score, path;

		public Pair(int score, int path) {
			this.score = score;
			this.path = path;
		}
	}

	public static int[] pathsWithMaxScore(List<String> board) {
		Pair[][] dp = new Pair[board.size()][board.get(0).length()];
		int mod = 1000000007;

		for (int i = board.size() - 1; i >= 0; --i) {
			for (int j = board.get(i).length() - 1; j >= 0; --j) {
				System.out.println(i + " " + j);
				if (board.get(i).charAt(j) == 'X') {
					dp[i][j] = new Pair(0, 0);
				} else if (i == board.size() - 1 && j == board.get(i).length() - 1) {
					dp[i][j] = new Pair(0, 1);
				} else if (i == board.size() - 1) {
					int val = Integer.parseInt(board.get(i).charAt(j) + "");
					dp[i][j] = new Pair(val + dp[i][j + 1].score, dp[i][j + 1].path);
				} else if (j == board.get(i).length() - 1) {
					int val = Integer.parseInt(board.get(i).charAt(j) + "");
					dp[i][j] = new Pair(val + dp[i + 1][j].score, dp[i + 1][j].path);
				} else {
					int val;
					if (i == 0 && j == 0) {
						val = 0;
					} else {
						val = Integer.parseInt(board.get(i).charAt(j) + "");
					}

					int max = Math.max(Math.max(dp[i][j + 1].score, dp[i + 1][j].score), dp[i + 1][j + 1].score);
					dp[i][j] = new Pair(max, 0);

					if (dp[i][j + 1].score == max) {
						dp[i][j].path = (dp[i][j].path + dp[i][j + 1].path) % mod;
					}
					if (dp[i + 1][j].score == max) {
						dp[i][j].path = (dp[i][j].path + dp[i + 1][j].path) % mod;
					}
					if (dp[i + 1][j + 1].score == max) {
						dp[i][j].path = (dp[i][j].path + dp[i + 1][j + 1].path) % mod;
					}
					dp[i][j].score = (dp[i][j].score + val) % mod;
				}
			}
		}
		if (dp[0][0].path == 0) {
			return new int[] { 0, 0 };
		} else {
			return new int[] { dp[0][0].score, dp[0][0].path };
		}
	}

	public static void main(String[] args) {
		ArrayList<String> board = new ArrayList<String>();
//		["","",""]
		board.add("E23");
		board.add("2X2");
		board.add("12S");

		int[] arr = pathsWithMaxScore(board);
		System.out.println(arr[0] + " " + arr[1]);
	}

}
