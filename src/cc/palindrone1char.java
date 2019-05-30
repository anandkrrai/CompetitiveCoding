package cc;

public class palindrone1char {
	static int palindromeIndex(String s) {
		int left = 0, right = s.length() - 1;

		while (left < right) {
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (s.charAt(left) == s.charAt(right)) {
				++left;
				--right;
			} else {
				if (s.charAt(left + 1) == s.charAt(right)) {
					return left;
				} else {
					return right;
				}
			}
		}
		return -1;
	}

	public static boolean isPalin(String str) {
		for (int i = 0; i < str.length() / 2; ++i) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(isPalin("793397"));
		System.out.println(palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));
	}

}
