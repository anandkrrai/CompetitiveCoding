package arraysAndstrings;

import java.util.*;

public class maxDiff {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		ArrayList<Character> list = new ArrayList<>(map.keySet());
		int max = 0, min = 1000000;

		for (char val : list) {
			int x = map.get(val);
			max = Math.max(max, x);
			min = Math.min(min, x);
		}

		System.out.println(max - min);
	}

}
