package java_ada;

public class LPSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "acbbcc";
		int length = countLPSubstring(str);
		System.out.println(length);
	}

	private static int countLPSubstring(String str) {
		// TODO Auto-generated method stub
		boolean[][] dp = new boolean[str.length()][str.length()];
		int count = 0;
		int length = 0;

		for (int gap = 0; gap < str.length(); ++gap) {
			for (int i = 0, j = i + gap; j < dp.length; ++i, ++j) {
				if (gap == 0) {
					dp[i][j] = true;
					
				} else if (gap == 1) {

					dp[i][j] = str.charAt(i) == str.charAt(j);
				} else {

					dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
				}
				if (dp[i][j] == true) {
					count++;
					length = gap + 1;
				}
			}
		}
		System.out.println("length" + length);
		return count;

	}

}
