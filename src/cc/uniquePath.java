package cc;

public class uniquePath {

	public static boolean isValid(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
			return false;
		} else if (grid[row][col] == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static int uniquePathsIII(int[][] grid, int row, int col) {

		if (grid[row][col] == 2) {
			return 1;
		}

		int rv = 0;
		grid[row][col] = -1;

		if (isValid(grid, row + 1, col))
			rv += uniquePathsIII(grid, row + 1, col);

		if (isValid(grid, row - 1, col))
			rv += uniquePathsIII(grid, row - 1, col);

		if (isValid(grid, row, col + 1))
			rv += uniquePathsIII(grid, row, col + 1);

		if (isValid(grid, row, col - 1))
			rv += uniquePathsIII(grid, row, col - 1);

		grid[row][col] = -1;
		return rv;
	}

	public static int uniquePathsIII(int[][] grid) {
		int row = 0, col = 0;

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1) {
					row = i;
					col = j;
					break;
				}
			}
		}

		return uniquePathsIII(grid, row, col);

	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(uniquePathsIII(grid));
	}

}
