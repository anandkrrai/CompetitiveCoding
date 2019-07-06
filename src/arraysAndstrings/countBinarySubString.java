package arraysAndstrings;

public class countBinarySubString {
	public static int countBinarySubstrings(String s) {
		int c1 = 0, c2 = 0, ans = 0, i = 0;

		while (i < s.length()) {
			ans += Math.min(c1, c2);
			c1 = c2;
			c2 = 0;
			int j = i;
			while (j < s.length() && s.charAt(i) == s.charAt(j)) {
				++j;
				++c2;
			}
			i = j;
		}
		ans += Math.max(c1, c2);
		return ans;
	}

	public static void main(String[] args) {
		String s = "0011010";
		System.out.println(countBinarySubstrings(s));
	}

}
