import java.util.*;

public class AddInterval {
	public static class Pair {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			int[][] rv = new int[1][2];
			rv[0][0] = newInterval[0];
			rv[0][1] = newInterval[1];
			return rv;
		} else if (newInterval.length == 0) {
			return intervals;
		}
		Stack<Pair> st = new Stack<>();
		boolean processed = false;

		for (int i = 0; i < intervals.length; ++i) {
			if (st.size() == 0) {
				if (intervals[0][0] < newInterval[0]) {
					st.push(new Pair(intervals[0][0], intervals[0][1]));
				} else {
					st.push(new Pair(newInterval[0], newInterval[1]));
					processed = true;
					--i;
				}
			} else {
				if (!processed && st.peek().end >= newInterval[0]) {
					Pair p = st.pop();
					p.end = Math.max(newInterval[1], p.end);
					st.push(p);
					--i;
					processed = true;
				} else if (!processed && newInterval[0] <= intervals[i][0]) {
					st.push(new Pair(newInterval[0], newInterval[1]));
					--i;
					processed = true;
				} else if (st.peek().end >= intervals[i][0]) {
					Pair p = st.pop();
					p.end = Math.max(intervals[i][1], p.end);
					st.push(p);
				} else {
					st.push(new Pair(intervals[i][0], intervals[i][1]));
				}
			}
		}

		if (!processed) {
			if (st.size() == 0) {
				st.push(new Pair(newInterval[0], newInterval[1]));
			} else {
				if (st.peek().end >= newInterval[0])
					st.peek().end = newInterval[1];
				else {
					st.push(new Pair(newInterval[0], newInterval[1]));
				}
			}
		}

		int[][] rv = new int[st.size()][2];
		while (st.size() != 0) {
			Pair p = st.pop();
			rv[st.size()][0] = p.start;
			rv[st.size()][1] = p.end;
		}

		return rv;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 0, 8 };
		insert(intervals, newInterval);
	}

}
