package cc;

import java.util.*;

public class sortByFrequency {

	public static class Helper implements Comparable<Helper> {
		char ch;
		int count;

		public Helper(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}

		public int compareTo(Helper o) {
			return o.count-this.count;
		}
	}

	public static String frequencySort(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); ++i) {
			map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));
		}

		ArrayList<Helper> list = new ArrayList<>();

		for (char ch : map.keySet()) {
			Helper help = new Helper(ch, map.get(ch));
			list.add(help);
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder("");

		for (Helper help : list) {
			for (int i = 0; i < help.count; ++i) {
				// System.out.print(help.ch);
				sb.append(help.ch);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("dnana"));
	}

}
