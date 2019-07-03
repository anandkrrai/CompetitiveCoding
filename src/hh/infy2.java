package hh;

import java.util.*;
import java.util.Queue;

public class infy2 {

	public static class help {
		int x;
		int level;

		help(int x, int level) {
			this.x = x;
			this.level = level;
		}
	}

	public static int minimumGroups(List<Integer> predators) {
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < predators.size(); ++i) {
			if (!map.containsKey(predators.get(i))) {
				ArrayList<Integer> children = new ArrayList<>();
				children.add(i);
				map.put(predators.get(i), children);
			} else {
				ArrayList<Integer> children = map.get(predators.get(i));
				children.add(i);
				map.put(predators.get(i), children);
			}

		}

		Queue<help> curr = new LinkedList<>();
		// curr.add(-1);

		for (int i : map.get(-1)) {
			help n = new help(i, 0);
			curr.add(n);
		}
		int count = 1;
		// while(prev.size()!=0){
		int level = 0;
		while (curr.size() != 0) {
			help rm = curr.remove();
			if (rm.level != level) {
				level++;
				count++;
			}

			if (map.containsKey(rm.x)) {
				for (int j : map.get(rm.x)) {
					curr.add(new help(j, rm.level + 1));
				}
			}

		}

		return count;
	}


	public static void main(String[] args) {

	}

}
