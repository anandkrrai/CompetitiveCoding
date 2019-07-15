package dp;

public class MinPalinCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abccbc";
		int cut = mpc(str);
		System.out.println(cut);
	}

	private static int mpc(String str) {
		// TODO Auto-generated method stub
		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); ++gap) {
			for (int i = 0, j = i + gap; j < dp.length; ++i, ++j) {
				if (gap == 0) {
					dp[i][j] = 0;
				} else if (gap == 1) {

					dp[i][j] = str.charAt(i) == str.charAt(j) ? 0 : 1;
				} else {

					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = Integer.MAX_VALUE;
						for (int cut = 1; cut <= gap; ++cut) {
							int rp = dp[i][i + cut - 1];
							int lp = dp[i + cut][j];
							dp[i][j] = Math.min(dp[i][j], rp + lp + 1);
						}
					}

				}
			}
		}
		// for(int i=0;i<dp.length;++i) {
		// for(int j=0;j<dp[0].length;++j) {
		// System.out.print(dp[i][j]+"\t");
		// }
		// System.out.println();
		// }
		//
		return dp[0][dp.length - 1];

	}

}
