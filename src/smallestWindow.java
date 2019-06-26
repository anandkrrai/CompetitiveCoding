import java.util.HashMap;
import java.util.HashSet;

public class smallestWindow {
	public static String smallestWindow(String s, String t) {

		HashSet<Character> set = new HashSet<>();

		for (int i = 0; i < t.length(); ++i) {
			set.add(t.charAt(i));
		}

		String rv = "";

		HashMap<Character, Integer> map = new HashMap<>();
		int ans = s.length(), si = 0, ei = 0;

		for (ei = 0; ei < s.length(); ++ei) {

			if (!set.contains(s.charAt(ei))) {
				continue;
			}

			if (map.size() == set.size()) {
				break;
			}

			map.put(s.charAt(ei), map.getOrDefault(s.charAt(ei), 0) + 1);
		}

		rv = s.substring(si, ei);
		ans = ei - si;

		while (ei < s.length()) {

			while (set.contains(s.charAt(si)) && map.containsKey(s.charAt(si)) && map.get(s.charAt(si)) > 1) {
				map.put(s.charAt(si), map.get(s.charAt(si)) - 1);
				++si;
			}

			if (ans > ei - si) {
				ans = ei - si;
				rv = s.substring(si, ei);
			}

			if (set.contains(s.charAt(ei)))
				map.put(s.charAt(ei), map.getOrDefault(s.charAt(ei), 0) + 1);

			++ei;
		}
		
//		TODO fix the condition so that the loop travels till the end

		while (si < ei ) {
			map.put(s.charAt(si), map.get(s.charAt(si)) - 1);
			++si;
		}

		if (ans > ei - si) {
			ans = ei - si;
			rv = s.substring(si, ei);
		}

		return rv;

	}

	public static void main(String[] args) {
		String str1 = "timetopractice";
		String str2 = "toc";

		System.out.println(smallestWindow(str1, str2));

	}

}
