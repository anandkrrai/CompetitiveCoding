package dp;

import java.util.*;

public class EscapeALargeMaze {
	public class Pair {
		int row, col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public boolean isEscapePossible(int[][] blockage, int[] src, int[] target) {
		int limit = blockage.length * blockage.length / 2 + 1;
		HashSet<String> blocked = new HashSet<>();
		for (int[] block : blockage)
			blocked.add(block[0] + "*" + block[1]);

		return !isBlocked(blocked, src, target, limit) || !isBlocked(blocked, target, src, limit);
	}

	public int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public int n = 1000000;

	public boolean isBlocked(HashSet<String> blocked, int[] src, int[] target, int limit) {
		LinkedList<Pair> q = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		q.addLast(new Pair(src[0], src[1]));

		while (q.size() != 0 && limit > 0) {
			Pair rem = q.removeFirst();
			String key = rem.row + "*" + rem.col;
			if (blocked.contains(key) || visited.contains(key))
				continue;
			if (target[0] == rem.row && target[1] == rem.col)
				return false;

			--limit;
			visited.add(key);

			for (int[] dir : dirs) {
				if (dir[0] + rem.row <= n && dir[1] + rem.col <= n && dir[0] + rem.row >= 0 && dir[1] + rem.col >= 0) {
					q.addLast(new Pair(dir[0] + rem.row, dir[1] + rem.col));
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
