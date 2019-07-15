package java_ada;

public class LCS {

	public static void main(String[] args) {
		String str = "abckcybc";
		String str1 = "cbyckcba";

		int len = LCS(str, str1);
		System.out.println(len);

	}

	private static int LCS(String X, String Y) {
		int[][] dp = new int[X.length() + 1][Y.length() + 1];

		for (int i = 1; i < dp.length; ++i) {
			for (int j = 1; j < dp[0].length; ++j) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

}
