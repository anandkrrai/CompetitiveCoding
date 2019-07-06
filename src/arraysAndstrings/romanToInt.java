package arraysAndstrings;

import java.util.HashMap;

public class romanToInt {
	public static int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int ans = 0;

		for (int i = 0; i < s.length(); ++i) {
			int val = map.get(s.charAt(i));
			if (i + 1 < s.length()) {
				int val2 = map.get(s.charAt(i + 1));
				if (val2 > val) {
					ans += val2 - val;
					++i;
				} else {
					ans += val;
				}
			} else {
				ans += val;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(romanToInt(s));
	}

}
