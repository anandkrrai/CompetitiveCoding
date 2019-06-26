package map_set;

import java.util.*;

public class maxLenUniqueChar {
	public static void print(char[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int sum = 0, ans = 0;
		for (int i = 0; i < A.length; ++i) {
			char ch = A[i];
			if (ch == '1') {
				sum++;
			} else {
				sum--;
			}

			if (map.containsKey(sum)) {
				ans = Math.max(ans, map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		System.out.println(ans);
	}

	public static int lengthOfLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<>();
		int start = 0, end = 0, len = 0;

		while (end < s.length()) {
			if (!set.contains(s.charAt(end))) {
				set.add(s.charAt(end));
				++end;
				len = Math.max(len, end - start);
			} else {
				set.remove(s.charAt(start));
				++start;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
