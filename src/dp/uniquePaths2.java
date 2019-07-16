package dp;

public class uniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] strg = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = strg.length - 1; i >= 0; --i) {
			for (int j = strg[0].length-1; j >= 0; --j) {
				if (obstacleGrid[i][j] == 1)
					continue;

				if (i == strg.length - 1 && j == strg[0].length - 1) {
					strg[i][j] = 1;
				} else if (i == strg.length - 1) {
					strg[i][j] = strg[i][j + 1];
				} else if (j == strg[0].length - 1) {
					strg[i][j] = strg[i + 1][j];
				} else {
					strg[i][j] = strg[i][j + 1] + strg[i + 1][j];
				}
			}
		}
		return strg[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
