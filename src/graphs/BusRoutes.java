package graphs;

import java.util.*;

public class BusRoutes {

	public static class Pair {
		int curr, num;

		public Pair(int curr, int num) {
			this.curr = curr;
			this.num = num;
		}
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {

		if (S == T)
			return 0;

		HashMap<Integer, ArrayList<Integer>> stopSet = new HashMap<>();

		for (int i = 0; i < routes.length; ++i) {
			for (int j = 0; j < routes[i].length; ++j) {
				ArrayList<Integer> nbrs = stopSet.getOrDefault(routes[i][j], new ArrayList<>());
				nbrs.add(i);
				stopSet.put(routes[i][j], nbrs);
			}
		}

		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> targetSet = new HashSet<>();
		LinkedList<Pair> q = new LinkedList<>();

		for (int start : stopSet.get(S)) {
			q.addLast(new Pair(start, 1));
		}

		for (int n : stopSet.get(T)) {
			targetSet.add(n);
		}

		while (q.size() != 0) {
			Pair rem = q.removeFirst();

			if (targetSet.contains(rem.curr))
				return rem.num;
			if (visited.contains(rem.curr))
				continue;
			visited.add(rem.curr);

			for (int nbr : routes[rem.curr]) {
				for (int x : stopSet.get(nbr)) {
					q.add(new Pair(x, rem.num + 1));
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int[][] routes = { { 1, 2, 3 }, { 3, 6, 7 }, { 7, 8 } };
		int S = 1, T = 8;
		System.out.println(numBusesToDestination(routes, S, T));
	}

}
