package arraysAndstrings;

public class longestPalindromicSubString {
	public static String Longest_Palindromic_substring(String str) {
		String rv = "";
		for (int i = 0; i <= str.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				String s = str.substring(j, i);
				String temp = reverse(s);
				if (s.equals(temp) && temp.length() > rv.length()) {
					rv = temp;
				}
			}
		}
		return rv;
	}

	private static String reverse(String s) {
		StringBuilder sc = new StringBuilder(s);
		sc = sc.reverse();
		return sc.toString();
	}

	public static void main(String[] args) {

	}
}
