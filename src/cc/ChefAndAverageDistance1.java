package cc;

import java.util.Scanner;

public class ChefAndAverageDistance1 {

	public static int[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			int[][] grid = new int[n][m];
			arr = new int[m + n - 1];
			for (int i = 0; i < n; ++i) {
				String str = scan.nextLine();
				for (int j = 0; j < str.length(); ++j) {
					grid[i][j] = Integer.parseInt(str.charAt(j) + "");
				}
			}
			boolean[][] flag;
			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid[i].length; ++j) {
					if (grid[i][j] == 1) {
						flag = new boolean[n][m];
						findPath(grid, i, j, 0, flag);
					}
				}
			}

			for (int i = 1; i < arr.length; ++i) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		scan.close();
	}

	private static void findPath(int[][] grid, int i, int j, int length, boolean[][] flag) {
		if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || length >= arr.length) {
			return;
		}
//-1 represents processed
		if (flag[i][j] == true)
			return;

		if (grid[i][j] == 1) {
			arr[length]+=1;

		}

		flag[i][j] = true;

		findPath(grid, i, j + 1, length + 1, flag);
		findPath(grid, i + 1, j, length + 1, flag);
		findPath(grid, i, j - 1, length + 1, flag);
		findPath(grid, i - 1, j, length + 1, flag);

	}

}
