import java.util.*;

public class AllAnagramsInString {
	
	public static ArrayList<Integer> findAnagrams(String s, String p) {

		ArrayList<Integer> rv = new ArrayList<>();

		int[] par = new int[26];

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < p.length(); ++i) {
			char ch = p.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int si = 0, ei = 0, match = 0;

		for (ei = 0; ei < p.length() - 1; ++ei) {
			char ch = s.charAt(ei);
			if (par[ch - 'a'] < map.getOrDefault(ch, 0)) {
				++match;
			}
			par[ch - 'a']++;
		}

		while (ei < s.length()) {
			char ch = s.charAt(ei);
			if (!map.containsKey(ch)) {

				ch = s.charAt(si);
				if (map.containsKey(ch) && par[ch - 'a'] <= map.get(ch)) {
					--match;
				}
				par[ch - 'a']--;
			} else {
				if (par[ch - 'a'] < map.get(ch)) {
					++match;
				}
				par[ch - 'a']++;

				if (match == p.length())
					rv.add(si);

				ch = s.charAt(si);
				if (map.containsKey(ch) && par[ch - 'a'] <= map.get(ch)) {
					--match;
				}

				par[ch - 'a']--;

			}

			++si;
			++ei;
		}

		return rv;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		System.out.println(findAnagrams(s, p));
	}
}