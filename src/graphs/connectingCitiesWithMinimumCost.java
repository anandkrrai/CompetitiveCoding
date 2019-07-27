package graphs;

import java.util.*;

public class connectingCitiesWithMinimumCost {
	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest, int wt) {
		graph.get(src).add(new Edge(dest, wt));
		graph.get(dest).add(new Edge(src, wt));
	}

	private static int find(int[] pa, int v1) {
		if (pa[v1] == v1) {
			return v1;
		}
		return find(pa, pa[v1]);
	}

	static class kedge implements Comparable<kedge> {
		int u;
		int v;
		int wt;

		kedge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(kedge other) {
			return this.wt - other.wt;
		}
	}

	private static void merge(int[] ptr, int[] rnk, int v1sl, int v2sl) {
		if (rnk[v1sl] > rnk[v2sl]) {
			ptr[v2sl] = v1sl;

		} else if (rnk[v1sl] < rnk[v2sl]) {
			ptr[v1sl] = v2sl;
		} else {
			ptr[v2sl] = v1sl;
			rnk[v1sl]++;
		}

		return;
	}

	private static int getLeader(int[] ptr, int v) {
		if (v == ptr[v]) {
			return v;
		}
		return getLeader(ptr, ptr[v]);
	}

	public static ArrayList<ArrayList<Edge>> krushkal(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Edge>> mst = new ArrayList<>();
		for (int i = 0; i < graph.size(); ++i) {
			mst.add(new ArrayList<>());
		}

		int[] ptr = new int[graph.size()];
		for (int i = 0; i < graph.size(); ++i) {
			ptr[i] = i;
		}
		int[] rnk = new int[graph.size()];
		Arrays.fill(rnk, 1);

		PriorityQueue<kedge> queue = new PriorityQueue<>();
		for (int v = 0; v < graph.size(); ++v) {

			for (int e = 0; e < graph.get(v).size(); ++e) {
				if (v < graph.get(v).get(e).nbr) {
					queue.add(new kedge(v, graph.get(v).get(e).nbr, graph.get(v).get(e).wt));
				}
			}
		}

		int count = 1;
		while (queue.size() > 0 && count < graph.size() - 1) {
			// get ,remove, findleader, *add edge and merge
			kedge rm = queue.remove();
			int v1sl = getLeader(ptr, rm.u);
			int v2sl = getLeader(ptr, rm.v);

			if (v1sl != v2sl) {
				addEdge(mst, rm.u, rm.v, rm.wt);
				merge(ptr, rnk, v1sl, v2sl);
				count++;
			}

		}
		return mst;
	}

	public static int connectedComponents(ArrayList<ArrayList<Edge>> graph) {
		boolean[] visited = new boolean[graph.size()];
		int rv = 0, count=0;

		for (int i = 0; i < visited.length; ++i) {
			if (!visited[i]) {	
				++count;
				visited[i] = true;
				rv = dfs(graph, visited, i);
			}
		}
		return rv;
	}

	public static int dfs(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src) {
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		int rv = 0;
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				rv += dfs(graph, visited, e.nbr) + e.wt;
			}
		}
		return rv;
	}

	public int minimumCost(int N, int[][] conections) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < conections.length; ++i) {
			int from = conections[i][0] - 1;
			int to = conections[i][1] - 1;
			int wt = conections[i][2];
			addEdge(graph, from, to, wt);
		}

		int ans = 0;
		ArrayList<ArrayList<Edge>> mygraph = krushkal(graph);

		ans = connectedComponents(mygraph);

		return ans;
	}

}
