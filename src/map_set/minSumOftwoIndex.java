package map_set;

import java.util.*;

public class minSumOftwoIndex {
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> lm = new HashMap<>();

		for (int i = 0; i < list1.length; ++i) {
			if (!lm.containsKey(list1[i])) {
				lm.put(list1[i], i);
			}
		}

		int min = Integer.MAX_VALUE;
		ArrayList<String> rv = new ArrayList<>();

		for (int i = 0; i < list2.length; ++i) {
			if (!lm.containsKey(list2[i])) {
				continue;
			} else {
				int j = lm.get(list2[i]);
				if (j + i > min) {
					continue;
				} else {
					if (i + j == min) {
						rv.add(list2[i]);
					} else {
						min = i + j;
						rv = new ArrayList<>();
						rv.add(list2[i]);
					}
				}
			}
		}
		String[] res = new String[10];
		return rv.toArray(res);
	}
}
