package cc;

import java.util.Arrays;
import java.util.Scanner;

public class LargestProductInGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] grid = new int[26][26];
		for (int i = 0; i < 26; ++i) {
			Arrays.fill(grid[i], 1);
		}

		for (int grid_i = 3; grid_i < 23; grid_i++) {
			for (int grid_j = 3; grid_j < 23; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}

		int max = -1;

		for (int grid_i = 3; grid_i < 23; grid_i++) {
			for (int grid_j = 3; grid_j < 23; grid_j++) {
				int temp = grid[grid_i][grid_j] * grid[grid_i][grid_j + 1] * grid[grid_i][grid_j + 2]
						* grid[grid_i][grid_j + 3];
				max = Math.max(max, temp);

				temp = grid[grid_i][grid_j] * grid[grid_i + 1][grid_j] * grid[grid_i + 2][grid_j]
						* grid[grid_i + 3][grid_j];
				max = Math.max(max, temp);

				temp = grid[grid_i][grid_j] * grid[grid_i + 1][grid_j + 1] * grid[grid_i + 2][grid_j + 2]
						* grid[grid_i + 3][grid_j + 3];
				max = Math.max(max, temp);

				temp = grid[grid_i][grid_j] * grid[grid_i - 1][grid_j + 1] * grid[grid_i - 2][grid_j + 2]
						* grid[grid_i - 3][grid_j + 3];
				max = Math.max(max, temp);

			}
		}

		System.out.println(max);
		in.close();
	}

}
