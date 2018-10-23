package cc;

import java.util.Scanner;

public class ChefAndAverageDistance3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();

			int[][] grid = new int[n][m];
			for (int i = 0; i < n; ++i) {
				String str = scan.nextLine();
				for (int j = 0; j < str.length(); ++j) {
					grid[i][j] = Integer.parseInt(str.charAt(j) + "");
				}
			}

			int[] arr = new int[m + n - 1];
			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid[i].length; ++j) {
					if (grid[i][j] == 1) {
						boolean[][] grid_t = new boolean[n][m];

						arr = findPath(grid, grid_t, i, j, 0, arr);
					}
				}
			}

			for (int i = 1; i < arr.length; ++i) {
				System.out.print(arr[i] / 2 + " ");
			}
			System.out.println();
		}

		scan.close();
	}

	private static int[] findPath(int[][] grid, boolean[][] grid_t, int i, int j, int length, int[] arr) {
		if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || length > arr.length) {
			return arr;
		}

		// -1 represents processed
		if (grid_t[i][j] == true)
			return arr;

		if (grid[i][j] == 1) {
			arr[length]++;

		}

		grid_t[i][j] = true;
		arr = findPath(grid, grid_t, i, j + 1, length + 1, arr);
		arr = findPath(grid, grid_t, i + 1, j, length + 1, arr);
		arr = findPath(grid, grid_t, i, j - 1, length + 1, arr);
		arr = findPath(grid, grid_t, i - 1, j, length + 1, arr);

		return arr;
	}

}