package cc;

import java.util.HashMap;

public class firstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("rai"));

	}

	public int firstUniqChar1(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();
		// build hash map : character and how often it appears
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		// find the index
		for (int i = 0; i < n; i++) {
			if (count.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); ++i)
			map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));

		for (int i = 0; i < s.length(); ++i) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}

		return -1;
	}

}
