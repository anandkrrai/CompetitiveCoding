package dp;

public class lps {

	public static int lps1(String str) {
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); ++gap) {
			for (int i = 0, j = i + gap; j < dp.length; ++i, ++j) {
				if (i == j) {
					dp[i][i] = 1;
				} else if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i+1][j]);
				}
			}
		}

		return dp[0][dp.length - 1];
	}

	public static void main(String[] args) {
		String str = "abccccdd";
		System.out.println(lps1(str));
	}

}
