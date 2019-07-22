package hh;

import java.util.*;

import graphs.graph.Edge;

public class codeNation1 {

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair {
		int odd;
		int even;

		public Pair(int odd, int even) {
			this.odd = odd;
			this.even = even;
		}
	}

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		graph.get(src).add(new Edge(dest, 1));
	}

	private static int FindAllPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited, int weight) {
		if (src == dest) {
			if (weight % 2 == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		visited[src] = true;
		ArrayList<Edge> list = graph.get(src);
		int rv = 0;
		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			if (!visited[edge.nbr])
				rv += FindAllPath(graph, edge.nbr, dest, visited, weight + 1);
		}
		visited[src] = false;
		return rv;
	}

	private static int FindAllPathdp(HashMap<String, Integer> map, ArrayList<ArrayList<Edge>> graph, int src, int dest,
			boolean[] visited, int weight) {
		if (src == dest) {
			if (weight % 2 == 0) {
				return 1;
			} else {
				return 0;
			}
		}
//		String str = src + "->" + dest;
		String str = dest + "";
		if (map.containsKey(str))
			return map.get(str);

		visited[src] = true;
		ArrayList<Edge> list = graph.get(src);
		int rv = 0;
		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			if (!visited[edge.nbr])
				rv += FindAllPath(graph, edge.nbr, dest, visited, weight + 1);
		}
		visited[src] = false;
		map.put(str, rv);
		return rv;
	}

	public static void dfs(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src, int weight, int[] dp) {
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		if (weight % 2 == 0) {
			dp[src]++;
		}
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				dfs(graph, visited, e.nbr, weight + 1, dp);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {

			int n = scn.nextInt();
			int m = scn.nextInt();
			int x = scn.nextInt();

			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
			for (int i = 1; i <= n; ++i) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < m; ++i) {
				int src = scn.nextInt();
				int dest = scn.nextInt();
				addEdge(graph, src - 1, dest - 1);
			}
			HashMap<String, Integer> map = new HashMap<>();
			int[] arr = new int[graph.size()];
			for (int i = 0; i < n; ++i) {
//				int val = FindAllPathdp(map, graph, x - 1, i, new boolean[graph.size()], 1);
				dfs(graph, new boolean[graph.size()], x - 1, 1, arr);
			}
			for (int val : arr)
				System.out.print(val + " ");

			System.out.println();

		}
		scn.close();

	}

}

//private static Pair FindAllPathdp(HashMap<String, Pair> map, ArrayList<ArrayList<Edge>> graph, int src, int dest,
//boolean[] visited, int weight) {
//if (src == dest) {
//Pair p = new Pair(0, 0);
//if (weight % 2 == 0) {
//	p.even = 1;
//} else {
//	p.odd = 1;
//}
//return p;
//}
//String str = src + "->" + dest;
//if (map.containsKey(str)) {
//return map.get(str);
//}
//
//visited[src] = true;
//ArrayList<Edge> list = graph.get(src);
//Pair x = new Pair(0, 0), rv = new Pair(0, 0);
//for (int i = 0; i < list.size(); ++i) {
//Edge edge = list.get(i);
//if (!visited[edge.nbr])
//	x = FindAllPathdp(map, graph, edge.nbr, dest, visited, weight + 1);
//rv.odd += x.odd;
//rv.even += x.even;
//}
//map.put(str, rv);
//visited[src] = false;
//return rv;
//}