package cc;

import java.util.*;

public class findpattern {

	public static void main(String[] args) {
		String[] words = { "abcdefghijklmnopqrstuvwxyz", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "bcdefghijklmnopqrstuvwxyza";

		ArrayList<String> list = findAndReplacePattern(words, pattern);
		for (String st : list) {
			System.out.println(st);
		}
	}

	public static ArrayList<String> findAndReplacePattern(String[] words, String pattern) {

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashSet<Character> set = new HashSet<Character>();
		ArrayList<String> rv = new ArrayList<String>();
		boolean flag;

		for (String word : words) {
			if (word.length() != pattern.length()) {
				continue;
			} else {
				map = new HashMap<Character, Character>();
				set = new HashSet<Character>();
				flag = true;

				for (int i = 0; i < pattern.length(); ++i) {
					if (!map.containsKey(word.charAt(i))) {
						if (set.contains(pattern.charAt(i))) {
							flag = false;
							break;
						}
						set.add(pattern.charAt(i));
						map.put(word.charAt(i), pattern.charAt(i));
					} else {
						if (pattern.charAt(i) != map.get(word.charAt(i))) {
							flag = false;
							break;
						}
					}
				}

				if (flag)
					rv.add(word);
			}
		}

		return rv;
	}

}
