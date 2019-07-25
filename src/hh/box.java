package hh;

import java.util.*;

public class box {
	public static long pilesOfBoxes(List<Integer> boxesInPiles) {
		long ans = 0L, count = 1;
		Collections.sort(boxesInPiles);

		for (int i = boxesInPiles.size() - 2; i >= 0; --i) {
			if (boxesInPiles.get(i) == boxesInPiles.get(i + 1)) {
				++count;
			} else {
				ans += count;
				++count;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(pilesOfBoxes(list));
	}

}
