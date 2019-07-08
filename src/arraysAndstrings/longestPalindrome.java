package arraysAndstrings;

import java.util.HashMap;

public class longestPalindrome {
	public int longestPalindrome(String str) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); ++i) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		boolean oddtaken = false;
		int ans = 0;
		for (char c : map.keySet()) {
			int val = map.get(c);
			if (val % 2 == 0) {
				ans += val;
			} else {
				if (!oddtaken) {
					oddtaken = true;
					ans += val;
				} else {
					ans += val - 1;
				}
			}
		}
		return ans;
	}
}
