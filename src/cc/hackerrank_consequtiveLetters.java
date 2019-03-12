package cc;

import java.io.IOException;

public class hackerrank_consequtiveLetters {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int count = 0, j = 0;

		for (int i = 1; i < s.length() - 1; ++i) {
			if (s.charAt(i) == s.charAt(j)) {
				++count;
			} else {
				j = i;
			}
		}
		if (s.charAt(s.length() - 1) == s.charAt(j))
			++count;
		return count;

	}

	public static void main(String[] args) throws IOException {
		System.out.println(alternatingCharacters("AAABBB"));
	}
}
