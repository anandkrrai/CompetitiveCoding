package graphs;

import java.util.*;

public class biPartrite {

	public class Pair {
		int src, level;

		public Pair(int src, int level) {
			this.src = src;
			this.level = level;
		}
	}

	public boolean possibleBipartition(int N, int[][] dislikes) {
		int[] arr = new int[N + 1];
		Arrays.fill(arr, -1);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		for (int[] edge : dislikes) {
			graph.get(edge[0]).add(edge[1]);
		}

		LinkedList<Pair> q = new LinkedList<>();

		for (int i = 1; i <= N; ++i) {
			if (arr[i] != -1)
				continue;

			q.add(new Pair(i, 0));

			while (q.size() != 0) {
				Pair rem = q.removeFirst();
				if (arr[rem.src] == -1) {
					arr[rem.src] = rem.level % 2;
				} else if (arr[rem.src] != rem.level % 2) {
					return false;
				} else if (arr[rem.src] == rem.level % 2) {
					continue;
				}
				arr[rem.src] = rem.level % 2;
				for (int nbr : graph.get(rem.src))
					q.addLast(new Pair(nbr, rem.level + 1));

			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
