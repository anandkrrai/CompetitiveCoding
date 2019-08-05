package graphs;

import java.util.*;

public class openLocks {

	public static class Pair {
		int moves;
		int num;

		public Pair(int num, int moves) {
			this.num = num;
			this.moves = moves;
		}
	}

	public int openLock(String[] deadends, String target) {
		HashSet<Integer> visited = new HashSet<>();

		for (String deadend : deadends) {
			visited.add(Integer.parseInt(deadend));
		}

		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(0, 0));
		int tar = Integer.parseInt(target);

		while (list.size() != 0) {
			Pair rem = list.removeFirst();
			if (rem.num == tar) {
				return rem.moves;
			}
			if (visited.contains(rem.num)) {
				continue;
			} else {
				visited.add(rem.num);
			}

			for (int val : arr) {
				int child = rem.num + val;
				if (child >= 0 && child <= 1000 && !visited.contains(child)) {
					list.addLast(new Pair(child, rem.moves + 1));
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	public static int[] arr1 = { 1, 10, 100, 1000, -1, -10, -100, -1000 };
	public static int[] arr = { 1, 10, 100, 1000, -1, -10, -100, -1000 };

	public int bfs(HashSet<Integer> visited, int curr, int target) {
		if (curr > 9999 || curr < 0) {
			return Integer.MAX_VALUE;
		}
		if (visited.contains(curr))
			return Integer.MAX_VALUE;

		if (curr == target)
			return 0;

		visited.add(curr);

		int rv = Integer.MAX_VALUE;
		for (int val : arr) {
			rv = Math.min(rv, bfs(visited, curr + val, target));
		}
		if (rv != Integer.MAX_VALUE)
			rv += 1;

		visited.remove(curr);
		return rv;
	}

	public static void main(String[] args) {

	}

}
