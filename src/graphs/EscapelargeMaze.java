package graphs;

import java.util.*;

public class EscapelargeMaze {
	public static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		HashSet<String> set = new HashSet<>();
		HashSet<String> visited = new HashSet<>();

		for (int[] block : blocked)
			set.add(block[0] + "*" + block[1]);

		LinkedList<Pair> q = new LinkedList<>();
		q.addLast(new Pair(source[0], source[1]));

		while (q.size() != 0) {
			Pair rem = q.removeFirst();
			
			System.out.println(rem.r + "*" + rem.c);

			if (set.contains(rem.r + "*" + rem.c) || visited.contains(rem.r + "*" + rem.c))
				continue;

			if (rem.r == target[0] && rem.c == target[1])
				return true;

			visited.add(rem.r + "*" + rem.c);

			if (isValid(rem.r, rem.c + 1))
				q.addLast(new Pair(rem.r, rem.c + 1));

			if (isValid(rem.r, rem.c - 1))
				q.addLast(new Pair(rem.r, rem.c + 1));

			if (isValid(rem.r + 1, rem.c))
				q.addLast(new Pair(rem.r + 1, rem.c));

			if (isValid(rem.r - 1, rem.c))
				q.addLast(new Pair(rem.r - 1, rem.c));

		}

		return false;

	}

	public static boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= 1000000 || y >= 1000000) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		isEscapePossible(new int[][] {}, new int[] { 0, 0 }, new int[] { 999999, 999999 });
	}

}
