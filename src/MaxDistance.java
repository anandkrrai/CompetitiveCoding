import java.util.TreeSet;

public class MaxDistance {
	public int maxDistToClosest(int[] seats) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < seats.length; ++i) {
			if (seats[i] == 1)
				set.add(i);
		}
		int rv = 0;
		for (int i = 0; i < seats.length; ++i) {
			if (seats[i] == 0) {
				int floor = set.floor(i) == null ? 0 : set.floor(i);
				int ceil = set.ceiling(i) == null ? seats.length : set.ceiling(i);
				rv = Math.max(rv, Math.min(i - floor, ceil - i));
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
