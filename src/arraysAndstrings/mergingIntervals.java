package arraysAndstrings;

import java.util.*;

public class mergingIntervals {
	public class Pair {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int[][] merge(int[][] intervals) {
		Comparator<int[]> cmp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		};

		Arrays.sort(intervals, cmp);
		Stack<Pair> st = new Stack<>();

		if (intervals.length <= 1)
			return intervals;

		Pair pair = new Pair(intervals[0][0], intervals[0][1]);
		st.push(pair);
		for (int i = 1; i < intervals.length; ++i) {
			Pair p = st.pop();
			if (intervals[i][0] >= p.start && intervals[i][0] <= p.end) {
				p.end = Math.max(intervals[i][1], p.end);
				st.push(p);
			} else {
				st.push(p);
				st.push(new Pair(intervals[i][0], intervals[i][1]));
			}
		}

		int[][] rv = new int[st.size()][2];
		for (int i = rv.length - 1; i >= 0; --i) {
			Pair p = st.pop();
			rv[i][0] = p.start;
			rv[i][1] = p.end;
		}

		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
