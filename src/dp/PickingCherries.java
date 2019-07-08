package dp;

import java.util.HashMap;

public class PickingCherries {
	public boolean isValid(int r, int c, int[][] grid) {
		if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0) {
			return false;
		} else {
			return true;
		}
	}

	public int findPath(int[][] grid, int r1, int c1, int r2, HashMap<String, Integer> map) {
		String str = r1 + " " + c1 + " " + r2;

		if (map.containsKey(str))
			return map.get(str);

		int c2 = r1 + c1 - r2, rv = -1000, temp;

		if (r1 == grid.length - 1 && c1 == grid[0].length - 1)
			return grid[r1][c1];

		if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
			return -1000;

		if (isValid(r1, c1 + 1, grid) && isValid(r2, c2 + 1, grid)) {
			temp = findPath(grid, r1, c1 + 1, r2, map);
			rv = Math.max(rv, temp);
		}

		if (isValid(r1, c1 + 1, grid) && isValid(r2 + 1, c2, grid)) {
			temp = findPath(grid, r1, c1 + 1, r2 + 1, map);
			rv = Math.max(rv, temp);
		}

		if (isValid(r1 + 1, c1, grid) && isValid(r2 + 1, c2, grid)) {
			temp = findPath(grid, r1 + 1, c1, r2 + 1, map);
			rv = Math.max(rv, temp);
		}

		if (isValid(r1 + 1, c1, grid) && isValid(r2, c2 + 1, grid)) {
			temp = findPath(grid, r1 + 1, c1, r2, map);
			rv = Math.max(rv, temp);
		}

		if (r1 != r2 && c1 != c2) {
			rv += grid[r1][c1] + grid[r2][c2];
		} else {
			rv += grid[r1][c1];
		}

		map.put(str, rv);
		return rv;

	}

	public int cherryPickup(int[][] grid) {
		HashMap<String, Integer> map = new HashMap<>();
		return Math.max(0, findPath(grid, 0, 0, 0, map));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
