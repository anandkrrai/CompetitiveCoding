package map_set;

import java.util.*;

public class unCommonWords {
	public String[] uncommonFromSentences(String A, String B) {
		HashSet<String> set = new HashSet<>();

		for (String str : A.trim().split("\\s+")) {
			set.add(str);
		}

		List<String> list = new ArrayList<>();

		for (String str : B.trim().split("\\s+")) {
			if (set.contains(str))
				set.remove(str);
			else
				list.add(str);
		}

		for (String str : set)
			list.add(str);

		String rv[] = new String[list.size()];

		int i = 0;
		for (String str : list) {
			rv[i++] = str;
		}

		return rv;

	}
}
