package arraysAndstrings;

import java.util.Scanner;

public class wordDistance {
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		int w1 = -1, w2 = -1, ans = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; ++i) {
			if (words[i].equals(word1)) {
				w1 = i;
			} else if (words[i].equals(word2)) {
				w2 = i;
			}
			if (w1 != -1 && w2 != -1) {
				ans = Math.min(ans, Math.abs(w1 - w2));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		String word1 = sc.next(), word2 = sc.next();
		System.out.println(shortestWordDistance(words, word1, word2));
	}
}
