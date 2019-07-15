package dp;
public class LPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abckcybc";
		int length = LPS(str);
		System.out.println(length);
	}

	private static int LPS(String str) {
		// TODO Auto-generated method stub
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); ++gap) {
			for (int i = 0, j = i + gap; j < dp.length; ++i, ++j) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 1;
					}
				} else {

					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}

				}
			}
		}
		return dp[0][dp.length - 1];

	}
}
