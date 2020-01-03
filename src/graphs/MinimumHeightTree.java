package graphs;

import java.util.*;

public class MinimumHeightTree {

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		int[] degree = new int[n];
		for (int i = 0; i < n; ++i)
			map.put(i, new ArrayList<>());

		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
			degree[edge[0]]++;
			degree[edge[1]]++;
		}

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			if (degree[i] == 1)
				q.addLast(i);
		}

		while (q.size() > 2) {
			int node = q.removeFirst();

			for (int nbr : map.get(node)) {
				degree[nbr]--;
				if (degree[nbr] == 1)
					q.addLast(nbr);
			}
		}

		List<Integer> rv = new ArrayList<Integer>();
		while (q.size() != 0)
			rv.add(q.removeFirst());
		return rv;

	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		int n = 4;
		findMinHeightTrees(n, edges);
	}

}
