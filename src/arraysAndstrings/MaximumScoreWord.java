package arraysAndstrings;

import java.util.*;

public class MaximumScoreWord {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {

		// sorting with decreasing order of score of word
		Comparator<String> cmp = new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				return calc_score(obj2, score) - calc_score(obj1, score);
			}
		};

		Arrays.sort(words, cmp);
		int[] char_count = new int[26];

		for (char ch : letters)
			char_count[ch - 'a']++;

		return maxScore(words, char_count, score, 0);
	}

	private int maxScore(String[] words, int[] letters, int[] score, int vidx) {
		if (vidx == words.length || !chars_left(letters))
			return 0;
		int rv = 0;
		if (isPossible(words[vidx], letters)) {
			apply(words[vidx], letters);
			rv = calc_score(words[vidx], score) + maxScore(words, letters, score, vidx + 1);
			remove(words[vidx], letters);
		}
		rv = Math.max(rv, maxScore(words, letters, score, vidx + 1));

		return rv;
	}

	// utility function to check weather it is possible to form the word or not.
	public boolean isPossible(String word, int[] chars) {
		apply(word, chars);
		boolean isPossible = true;
		for (int val : chars) {
			if (val < 0)
				isPossible = false;
		}
		remove(word, chars);

		return isPossible;
	}

	// function to calculate the score of a given word
	public int calc_score(String word, int[] score) {
		int sc = 0;

		for (int i = 0; i < word.length(); ++i) {
			sc += score[word.charAt(i) - 'a'];
		}

		return sc;
	}

	// utility function to check if there are any more characters
	public boolean chars_left(int[] letters) {
		for (int val : letters)
			if (val > 0)
				return true;
		return false;
	}

	// using the character to form words
	private void remove(String word, int[] chars) {
		for (int i = 0; i < word.length(); ++i) {
			chars[word.charAt(i) - 'a']++;
		}

	}

	// removing the effect of usd word
	private void apply(String word, int[] chars) {
		for (int i = 0; i < word.length(); ++i) {
			chars[word.charAt(i) - 'a']--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
