package dp;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		int r = scn.nextInt();
//		int c = scn.nextInt();
//		int[][] grid = new int[r][c];
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				grid[i][j] = scn.nextInt();
//			}
//		}
		int[][] grid = { 
				{ 1, -1, 1, 1, 1, 1, 1, 1, -1, 1 },
				{ 1, 1, 1, 1, -1, -1, 1, 1, 1, 1 },
				{ -1, 1, 1, -1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, -1, 1, -1, 1, 1, 1, 1, 1 },
				{ -1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ -1, -1, 1, 1, 1, -1, 1, 1, -1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, -1, 1, 1 },
				{ 1, 1, 1, 1, -1, 1, -1, -1, 1, 1 },
				{ 1, -1, 1, -1, -1, 1, 1, -1, 1, -1 },
				{ -1, 1, -1, 1, -1, 1, 1, 1, 1, 1 } };
		System.out.print(cherryPickup(grid));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2D array
	// It should return the required output

	public static int cherryPickup(int[][] grid) {

		int[][][] dp = new int[grid.length][grid[0].length][grid.length];

		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[0].length; ++j) {
				Arrays.fill(dp[i][j], -1);
			}

		int rv = cherryPickupHelp(grid, 0, 0, 0, dp);

		return Math.max(0, rv);
	}

//	private static boolean isValid(int[][] grid, int r1, int c1, int r2) {
//		int c2 = r1 + c1 - r2;
//		if (r1 < grid.length && r2 < grid.length && c1 < grid[0].length && c2 < grid[0].length )
//			return true;
//		return false;
//	}
	
	private static boolean isValid(int[][] grid, int r1, int c1, int r2) {
		int c2 = r1 + c1 - r2;
		if (r1 < grid.length && r2 < grid.length && 
			c1 < grid[0].length && c2 < grid[0].length
			&& grid[r1][c1] != -1
			&& grid[r2][c2] != -1)
			return true;
		return false;
	}


	private static int cherryPickupHelp(int[][] grid, int r1, int c1, int r2, int[][][] dp) {

		if (dp[r1][c1][r2] !=-1) {
			return dp[r1][c1][r2];
		}
		
		int c2 = r1 + c1 - r2;
		
		if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
			System.out.println(r1+" "+c1+" "+r2+" "+c2);
			return grid[r1][c1];
		}

		int f1 = -10, f2 = 0, f3 = 0, f4 = 0;
		if (isValid(grid, r1 + 1, c1, r2 + 1))
			f1 = cherryPickupHelp(grid, r1 + 1, c1, r2 + 1, dp); // DD
		if (isValid(grid, r1, c1 + 1, r2))
			f2 = cherryPickupHelp(grid, r1, c1 + 1, r2, dp); // RR
		if (isValid(grid, r1 + 1, c1, r2))
			f3 = cherryPickupHelp(grid, r1 + 1, c1, r2, dp); // DR
		if (isValid(grid, r1, c1 + 1, r2 + 1))
			f4 = cherryPickupHelp(grid, r1, c1 + 1, r2 + 1, dp); // RD

		int rv = 0;
		rv = Math.max(f1, f2);
		rv = Math.max(rv, f3);
		rv = Math.max(rv, f4);

		if (r1 != r2 || c1 != c2) {
			rv += (grid[r1][c1] + grid[r2][c2]);
		} else {
			rv += grid[r1][c1];
		}

		dp[r1][c1][r2] = rv;
		return rv;
	}
}