package dp;

import java.util.*;

public class minMOvwWithRotations {

	public static class Pair {
		int row, col, steps, pos;

		// 0->horizontal
		// 1-vertical
		public Pair(int row, int col, int steps, int pos) {
			this.row = row;
			this.col = col;
			this.steps = steps;
			this.pos = pos;
		}
	}

	public static boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return false;
		} else if (grid[i][j] == 1)
			return false;
		else
			return true;
	}

	public static int minimumMoves(int[][] grid) {
		LinkedList<Pair> q = new LinkedList<>();

		Pair p = new Pair(0, 1, 0, 0);
		q.add(p);
		HashSet<String> visited = new HashSet<>();

		while (q.size() != 0) {
			Pair rem = q.removeFirst();

			String key = rem.row + "*" + rem.col + "*" + rem.pos;
			System.out.println(key);

			if (rem.row == grid.length - 1 && rem.col == grid[0].length - 1)
				return rem.steps;
			else if (visited.contains(key))
				continue;
			visited.add(key);
			if (rem.pos == 0) {

				if (isValid(grid, rem.row, rem.col + 1))
					q.addLast(new Pair(rem.row, rem.col + 1, rem.steps + 1, 0));

				if (isValid(grid, rem.row + 1, rem.col) && isValid(grid, rem.row + 1, rem.col - 1))
					q.addLast(new Pair(rem.row + 1, rem.col - 1, rem.steps + 1, 1));
			}
			if (rem.pos == 1) {

				if (isValid(grid, rem.row + 1, rem.col))
					q.addLast(new Pair(rem.row + 1, rem.col, rem.steps + 1, 1));

				if (isValid(grid, rem.row, rem.col + 1) && isValid(grid, rem.row - 1, rem.col + 1))
					q.addLast(new Pair(rem.row - 1, rem.col + 1, rem.steps + 1, 0));
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[][] grid = { { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0, 0 } };
		for(int[] arr : grid) {
			for(int val : arr)
				System.out.print(val+" ");
			System.out.println();
		}
		System.out.println(minimumMoves(grid));
	}

}
