import java.util.*;

public class LongestWord {
	public String dfs(String str, HashSet<String> set, HashMap<String, String> visited) {
		if (visited.containsKey(str))
			return visited.get(str);

		String rv = "";

		for (char ch = 'a'; ch <= 'z'; ++ch) {
			if (!set.contains(str + ch))
				continue;
			String s = dfs(str + ch, set, visited);
			if (rv.length() < s.length()) {
				rv = s;
			} else if (rv.length() == s.length()) {
				if (rv.compareTo(s) > 0) {
					rv = s;
				}
			}
		}
		visited.put(str, rv);
		return rv;
	}

	public String longestWord(String[] words) {
		HashSet<String> set = new HashSet<>();
		HashMap<String, String> visited = new HashMap<>();
		for (String word : words)
			set.add(word);
		String rv = "";
		for (String s : set) {
			if (s.length() == 1) {
				String str = dfs(s, set, visited);
				if (rv.length() < str.length()) {
					rv = str;
				} else if (rv.length() == str.length()) {
					if (rv.compareTo(str) > 0) {
						rv = str;
					}
				}
			}
		}

		return rv;

	}
}
