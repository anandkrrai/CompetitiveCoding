package tree;

import java.util.*;

public class CheapestFlight {
	public static class Edge {
		int nbr, wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair {
		int src, dist, k;

		public Pair(int src, int dist, int k) {
			this.src = src;
			this.dist = dist;
			this.k = k;
		}
	}

	public static ArrayList<ArrayList<Edge>> BuildGraph(int[][] flights, int n) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Edge>());
		}

		for (int[] flight : flights) {
			graph.get(flight[0]).add(new Edge(flight[1], flight[2]));
		}

		return graph;

	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		ArrayList<ArrayList<Edge>> graph = BuildGraph(flights, n);
		Comparator<Pair> cmp = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.dist - p2.dist;
			}
		};
		PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
		pq.add(new Pair(src, 0, K));
		HashSet<Integer> visited = new HashSet<>();

		while (pq.size() != 0) {
			Pair rem = pq.remove();
			if (rem.src == dst) {
				return rem.dist;
			}

			if (rem.k == 0 || visited.contains(rem.src))
				continue;

			visited.add(rem.src);

			for (Edge edge : graph.get(rem.src)) {
				if (!visited.contains(edge.nbr))
					pq.add(new Pair(edge.nbr, rem.dist + edge.wt, rem.k - 1));
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] flights= {{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(findCheapestPrice(3, flights, 0, 2, 1));
	}

}
