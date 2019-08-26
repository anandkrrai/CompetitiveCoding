package graphs;

import java.util.*;

public class ShortestPathWithAlternateColors {

	public class Edge {
		int vertex;
		int color;
		// 0->red , 1-> blue;

		public Edge(int vertex, int color) {
			this.vertex = vertex;
			this.color = color;
		}
	}

	public void buildGraph(HashMap<Integer, ArrayList<Edge>> graph, int[][] red_edges, int[][] blue_edges) {

		for (int i = 0; i < red_edges.length; ++i) {
			int from = red_edges[i][0];
			int to = red_edges[i][1];
			graph.get(from).add(new Edge(to, 0));
		}

		for (int i = 0; i < blue_edges.length; ++i) {
			int from = blue_edges[i][0];
			int to = blue_edges[i][1];
			graph.get(from).add(new Edge(to, 1));
		}
	}

	public class Pair {
		int distance;
		int vertex;
		int color;

		public Pair(int distance, int vertex, int color) {
			this.distance = distance;
			this.vertex = vertex;
			this.color = color;
		}
	}

	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			graph.put(i, new ArrayList<Edge>());
		}

		buildGraph(graph, red_edges, blue_edges);
		int[] rv = new int[n];
		Arrays.fill(rv, -1);

		HashSet<String> visited = new HashSet<>();
		LinkedList<Pair> q = new LinkedList<>();

		Pair p = new Pair(0, 0, -1);

		q.addLast(p);

		// bfs
		while (q.size() != 0) {
			Pair rem = q.removeFirst();

			if (visited.contains(rem.vertex + "*" + rem.color)) {
				continue;
			} else {
				visited.add(rem.vertex + "*" + rem.color);
			}

			if (rv[rem.vertex] == -1) {
				rv[rem.vertex] = rem.distance;
			}

			if (rem.color == -1) {
				for (Edge edge : graph.get(rem.vertex)) {
					q.addLast(new Pair(rem.distance + 1, edge.vertex, edge.color));
				}
			} else if (rem.color == 0) {
				for (Edge edge : graph.get(rem.vertex)) {
					if (edge.color == 1)
						q.addLast(new Pair(rem.distance + 1, edge.vertex, edge.color));
				}
			} else if (rem.color == 1) {
				for (Edge edge : graph.get(rem.vertex)) {
					if (edge.color == 0)
						q.addLast(new Pair(rem.distance + 1, edge.vertex, edge.color));
				}
			}
		}

		return rv;
	}
}
