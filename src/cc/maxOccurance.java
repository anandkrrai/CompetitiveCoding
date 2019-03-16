package cc;

import java.util.ArrayList;
import java.util.HashMap;

public class maxOccurance {

	public static String isValid(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			arr[s.charAt(i) - 97]++;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int x : arr) {
			if (x != 0) {
				if (map.containsKey(x)) {
					map.put(x, map.get(x) + 1);
				} else {
					map.put(x, 1);
				}
			}
		}

		if (map.size() > 2) {
			return "NO";
		}

		if (map.size() == 1) {
			return "YES";
		}

		if (map.containsKey(1) && map.get(1) == 1) {
			return "YES";
		}

		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
		if (Math.abs(list.get(0) - list.get(1)) == 1) {
			if (map.get(list.get(0)) == 1 || map.get(list.get(1)) == 1) {
				return "YES";
			}
		}

		return "NO";
	}

	public static void main(String[] args) {
		System.out.println(isValid("abcdefggg"));
	}

}
