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

	public static void main(String[] args) {

		System.out.println(palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));
	}

}
