package map_set;

import java.util.TreeSet;

public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {
		int radius = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int val : heaters)
			set.add(val);

		for (int house : houses) {
			int ceil = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house)-house;
			int floor = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house);
			
			radius=Math.max(radius, Math.min(floor, ceil));
		}
		return radius;
	}
}
