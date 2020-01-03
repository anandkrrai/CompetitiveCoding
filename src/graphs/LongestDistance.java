package graphs;

import java.util.*;

public class LongestDistance {
	public class Pair {
		int row, col, dist;

		public Pair(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

	}

	public int maxDistance(int[][] grid) {
		LinkedList<Pair> q = new LinkedList<>();
		int[][] dp = new int[grid.length][grid[0].length];

		for (int i = 0; i < dp.length; ++i) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1) {
					q.addLast(new Pair(i, j, 0));
					dp[i][j] = 0;
				}
			}
		}

		int ans = -1;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (q.size() != 0) {
			Pair rem = q.removeFirst();

			if (dp[rem.row][rem.col] > 0) {
				continue;
			}
			ans = Math.max(ans, rem.dist);
			dp[rem.row][rem.col]=rem.dist;

			for (int[] dir : dirs) {
				if (isValid(rem.row + dir[0], rem.col + dir[1], dp)) {
					q.addLast(new Pair(rem.row + dir[0], rem.col + dir[1], rem.dist + 1));
				}
			}

		}
		return ans == 0 ? -1 : ans;
	}

	public boolean isValid(int i, int j, int[][] arr) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
