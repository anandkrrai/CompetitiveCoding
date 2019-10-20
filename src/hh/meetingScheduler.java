package hh;

import java.util.*;

public class meetingScheduler {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		List<Integer> list = new ArrayList<>();
		Comparator<int[]> cmp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		};

		Arrays.sort(slots1, cmp);
		Arrays.sort(slots2, cmp);

		int i = 0, j = 0;
		while (i < slots1.length && j < slots2.length) {
			int start = Math.max(slots1[i][0], slots2[j][0]);
			int end = Math.min(slots1[i][1], slots2[j][1]);

			if (end - start >= duration) {
				list.add(start);
				list.add(start + duration);
				break;
			}

		}

		return list;
	}

	public List<Integer> minAvailableDuration1(int[][] slots1, int[][] slots2, int duration) {
		List<Integer> list = new ArrayList<>();
		Comparator<int[]> cmp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		};

		Arrays.sort(slots1, cmp);
		Arrays.sort(slots2, cmp);

		for (int i = 0; i < slots1.length; ++i) {
			for (int j = 0; j < slots2.length; ++j) {
				int start = Math.max(slots1[i][0], slots2[j][0]);
				int end = Math.min(slots1[i][1], slots2[j][1]);
				if (end - start >= duration) {
					if (list.size() == 0) {
						list.add(start);
						list.add(start + duration);
					} else if (list.get(0) > start) {
						list = new ArrayList<Integer>();
						list.add(start);
						list.add(start + duration);
					}
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
