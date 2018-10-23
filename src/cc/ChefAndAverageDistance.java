package cc;

import java.util.Scanner;

public class ChefAndAverageDistance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
//		scan.nextLine();
		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			int[][] grid = new int[n][m];
			int[] arr = new int[m + n - 1];
			int x1, y1;
			for (int i = 0; i < n; ++i) {
				String str = scan.nextLine();
				for (int j = 0; j < str.length(); ++j) {
					grid[i][j] = Integer.parseInt(str.charAt(j) + "");
				}
			}

			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid[i].length; ++j) {
					if (grid[i][j] != 1) {
						continue;
					}
					for (int k = 1; k < m + n - 1; ++k) {
						for (int l = 1; l <= k; ++l) {
							x1 = i + l;
							y1 = j + k - l;

							if (x1 < grid.length && y1 < grid[i].length) {

								if (grid[x1][y1] == 1) {
									arr[k]++;
								}
							}
							// negative distance
							x1 = i - l;
							y1 = j + k - l;

							if (x1 < grid.length && y1 < grid[i].length && y1 >= 0 && x1 >= 0) {
								if (grid[x1][y1] == 1) {
									arr[k]++;
								}
							}

							x1 = i + l;
							y1 = j - k + l;
							if (x1 < grid.length && y1 < grid[i].length && y1 >= 0 && x1 >= 0) {
								if (grid[x1][y1] == 1) {
									arr[k]++;
								}
							}

							x1 = i - l;
							y1 = j - k + l;
							if (x1 < grid.length && y1 < grid[i].length && y1 >= 0 && x1 >= 0) {
								if (grid[x1][y1] == 1) {
									arr[k]++;
								}
							}

						}
					}

				}
			}

			for (int i = 1; i < arr.length; ++i) {
				arr[i] /= 2;
			}

			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid[i].length; ++j) {
					x1 = i + 1;
					y1 = j;
					if (x1 < grid.length && y1 < grid[i].length) {
						if (grid[x1][y1] == 1 && grid[i][j] == 1)
							arr[1]++;
					}
					x1 = i;
					y1 = j + 1;
					if (x1 < grid.length && y1 < grid[i].length) {
						if (grid[x1][y1] == 1 && grid[i][j] == 1)
							arr[1]++;
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

}
