package graphs;

import java.util.LinkedList;

public class ShortestPathAfterRemovingAtmostKobstracles {
	public class Pair {
		int row, col, k, steps;

		public Pair(int row, int col, int k, int steps) {
			this.row = row;
			this.col = col;
			this.k = k;
			this.steps = steps;
		}
	}

	public int shortestPath(int[][] grid, int k) {
		LinkedList<Pair> list = new LinkedList<>();
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		list.addLast(new Pair(0, 0, k, 0));

		while (list.size() != 0) {
			Pair rem = list.removeFirst();

			if (rem.row == grid.length - 1 && rem.col == grid[0].length - 1) {
				return rem.steps;
			}

			if (grid[rem.row][rem.col] == 1 && rem.k <= 0) {
				continue;
			} else if (grid[rem.row][rem.col] == 1) {
				rem.k--;
			}

			for (int[] dir : dirs) {
				int nr = rem.row + dir[0], nc = rem.col + dir[1];
				if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
					continue;
				} else {
					list.addLast(new Pair(nr, nr, rem.k, rem.steps + 1));
				}
			}
		}

		return -1;
	}
}
