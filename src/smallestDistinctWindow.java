import java.util.*;

public class smallestDistinctWindow {
	public static int minLength(String s) {

		HashSet<Character> set = new HashSet<>();

		for (int i = 0; i < s.length(); ++i) {
			set.add(s.charAt(i));
		}

		HashMap<Character, Integer> map = new HashMap<>();
		int ans = s.length(), si = 0, ei = 0;

		for (ei = 0; ei < s.length(); ++ei) {
			if (map.size() == set.size()) {
				break;
			}

			map.put(s.charAt(ei), map.getOrDefault(s.charAt(ei), 0) + 1);
		}

		while (ei < s.length()) {

			while (map.get(s.charAt(si)) > 1) {
				map.put(s.charAt(si), map.get(s.charAt(si)) - 1);
				++si;
			}

			ans = Math.min(ei - si, ans);

			map.put(s.charAt(ei), map.getOrDefault(s.charAt(ei), 0) + 1);
			++ei;
		}

		while (map.get(s.charAt(si)) > 1) {
			map.put(s.charAt(si), map.get(s.charAt(si)) - 1);
			++si;
		}
		ans = Math.min(ei - si, ans);

		return ans;

	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(minLength(sc.next()));
	}

}
