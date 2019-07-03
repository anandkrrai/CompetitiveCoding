package hh;

import java.util.*;

public class infy21 {
	public static class Pair {
		int val;
		int level;

		Pair(int val, int level) {
			this.val = val;
			this.level = level;
		}
	}

	public static int minimumGroups(List<Integer> predators) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < predators.size(); ++i) {
			if (map.containsKey(predators.get(i))) {
				ArrayList<Integer> child = map.get(predators.get(i));
				child.add(i);
				
			} else {
				ArrayList<Integer> lis = new ArrayList<Integer>();
				lis.add(i);
				map.put(predators.get(i), lis);
			}
		}

		LinkedList<Pair> list = new LinkedList<Pair>();
		int level = 0;

		ArrayList<Integer> children = map.get(-1);

		for (int child : children) {
			list.add(new Pair(child, level));
		}
		int rv = level+1;

		while (list.size() != 0) {
			Pair rem = list.removeFirst();
			
			if (level != rem.level) {
				++level;
				++rv;
			}

			ArrayList<Integer> childs = map.getOrDefault(rem.val, new ArrayList<Integer>());

			for (int child : childs) {
				list.addLast(new Pair(child, level + 1));
			}
		}

		return rv;
	}

}
