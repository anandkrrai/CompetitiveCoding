package graphs;

import java.util.*;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordsList) {
		HashSet<String> words = new HashSet<>();
		HashMap<String, HashSet<String>> map = new HashMap<>();

		for (String word : wordsList) {
			words.add(word);
			map.put(word, new HashSet<>());
		}

		for (String word : words) {
			populate(map, words, word);
		}

		populate(map, words, beginWord);
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(beginWord, 1));
		HashSet<String> visited = new HashSet<String>();

		while (q.size() != 0) {

			Pair rem = q.removeFirst();
			if (rem.word.equals(endWord)) {
				return rem.len;
			}
			if (visited.contains(rem.word))
				continue;

			visited.add(rem.word);

			for (String nbr : map.get(rem.word)) {
				q.addLast(new Pair(nbr, rem.len + 1));
			}
		}

		return 0;
	}

	public static class Pair {
		String word;
		int len;

		public Pair(String word, int len) {
			this.word = word;
			this.len = len;
		}
	}

	public static void populate(HashMap<String, HashSet<String>> map, HashSet<String> words, String word) {
		map.put(word, new HashSet<String>());
		for (int i = 0; i < word.length(); ++i) {
			for (char ch = 'a'; ch <= 'z'; ++ch) {
				String newWord = word.substring(0, i) + ch + word.substring(i + 1);
				if (words.contains(newWord))
					map.get(word).add(newWord);
			}
		}
		map.get(word).remove(word);
	}

}
