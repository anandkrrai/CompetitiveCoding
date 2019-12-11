package dp;

public class MatrixSubArraySumo1 {

	public static int[][] makeMatrix(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < dp[0].length; ++j) {
				if(i==0 && j==0) {
					dp[i][j]=arr[i][j];
				}else if(i == 0) {
					dp[i][j] = arr[i][j];
				} else {
					dp[i][j] = arr[i][j] + dp[i - 1][j];
				}
			}
		}
		for (int i = 0; i < dp.length; ++i) {
			for (int j = 1; j < dp[0].length; ++j) {
				dp[i][j] += dp[i][j - 1];
			}
		}

		for (int[] ar : dp) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		return dp;
	}

	public static int subMatrixSum(int[][] arr, int lti, int ltj, int rbi, int rbj) {
		int[][] dp = makeMatrix(arr);
		return dp[rbi][rbj] - dp[lti][rbj] - dp[rbi][ltj] + dp[lti][rbj];
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 6 }, { 5, 3, 8, 1, 2 }, { 4, 6, 7, 5, 5 }, { 2, 4, 8, 9, 4 } };
		subMatrixSum(mat, 1, 2, 3, 3);
	}

}
