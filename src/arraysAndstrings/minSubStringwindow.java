package arraysAndstrings;

import java.util.*;

public class minSubStringwindow {
	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> target = new HashMap<>();
		HashMap<Character, Integer> curr = new HashMap<>();

		for (int i = 0; i < t.length(); ++i) {
			target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
		}

		String ans = s;

		int i = 0, j = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			curr.put(ch, curr.getOrDefault(ch, 0) + 1);

			while (check(target, curr) && j <= i) {
				if (ans.length() > i - j + 1) {
					ans = s.substring(j, i + 1);
				}
				int val = curr.get(s.charAt(j));
				curr.remove(s.charAt(j));
				if (val > 1)
					curr.put(s.charAt(j), val - 1);
				j++;
			}
			i++;
		}
		if (ans.equals(s))
			return "";
		return ans;
	}

	public static boolean check(HashMap<Character, Integer> target, HashMap<Character, Integer> curr) {
		for (char ch : target.keySet()) {
			if (curr.getOrDefault(ch, 0) < target.get(ch))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(minWindow(s, t));
	}

}
