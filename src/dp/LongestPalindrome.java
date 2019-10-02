package dp;

public class LongestPalindrome {
	
	//wrong
	public static String longestPalindrome(String str) {
		if (str == null || str.length() == 1 || str.length() == 0)
			return str;

		String[][] arr = new String[str.length()][str.length()];
		boolean[][] bool = new boolean[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); ++gap) {
			for (int i = 0, j = i + gap; j < str.length(); ++i, ++j) {
				if (gap == 0) {
					arr[i][j] = str.charAt(i) + "";
					bool[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						bool[i][j] = true;
						arr[i][j] = str.charAt(i) + "" + str.charAt(j);
					} else {
						arr[i][j] = str.charAt(i) + "";
					}
				} else {
					if (bool[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
						bool[i][j] = true;
						arr[i][j] = str.charAt(i) + arr[i + 1][j - 1] + str.charAt(j);
					} else {
						arr[i][j] = arr[i + 1][j - 1];
					}
				}
			}
		}
		return arr[0][str.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abb"));
	}

}
