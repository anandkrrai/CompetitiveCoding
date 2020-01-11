package dp;

import java.util.*;

public class MakingALargeIsland {

	public class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public boolean isValid(int r, int c, int[][] grid) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
			return false;
		return true;
	}

	public int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int bfs(int[][] grid, int[][] dp, int r, int c, int mark) {
		LinkedList<Pair> q = new LinkedList<>();
		q.addLast(new Pair(r, c));
		int size = 0;

		while (q.size() > 0) {
			Pair rem = q.removeFirst();

			if (dp[rem.r][rem.c] == mark) {
				continue;
			} else {
				dp[rem.r][rem.c] = mark;
			}
			++size;

			for (int[] dir : dirs) {
				int nr = rem.r + dir[0];
				int nc = rem.c + dir[1];
				if (isValid(nr, nc, grid) && grid[nr][nc] == grid[r][c]) {
					q.addLast(new Pair(nr, nc));
				}
			}
		}

		return size;
	}

	public int largestIsland(int[][] grid) {
		int mark = 1;
		int max = 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[][] dp = new int[grid.length][grid[0].length];
		
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1 && dp[i][j] == 0) {
					int size = bfs(grid, dp, i, j, mark);
					map.put(mark, size);
					++mark;
					max = Math.max(max, size);
				}
			}
		}
		
		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < dp[0].length; ++j) {
				int temp = 1;
				HashSet<Integer> set = new HashSet<>();
				for (int[] dir : dirs) {
					int nr = i + dir[0];
					int nc = j + dir[1];

					if (isValid(nr, nc, dp) && !set.contains(dp[nr][nc])) {
						temp += map.get(dp[nr][nc]);
						set.add(dp[nr][nc]);
					}

				}
				max = Math.max(max, temp);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
