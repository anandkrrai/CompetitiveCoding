import java.util.*;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();

		for (String str : banned)
			set.add(str);

		paragraph=paragraph.replace('.', ' ');
		paragraph=paragraph.replace(',', ' ');
		paragraph=paragraph.toLowerCase();
		String[] arr = paragraph.trim().split("\\s+");

		for (String str : arr) {
			if (!set.contains(str)) {
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
		}

		int max = 0;
		String rv = "";
		for (String str : map.keySet()) {
			if (max < map.get(str)) {
				rv = str;
				max = map.get(str);
			}
		}
		return rv;
	}
}
