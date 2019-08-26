package hh;

import java.util.ArrayList;
import java.util.Scanner;

public class CherriesMesh {
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

	public static ArrayList<String> connectedComponents(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<String> rv = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];

		for (int i = 0; i < visited.length; ++i) {
			if (visited[i]) {
				continue;
			} else {
				visited[i] = true;
				String str = dfs(graph, visited, i);
				rv.add(str);
			}
		}
		return rv;
	}

	public static String dfs(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src) {
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		String rv = src + "";
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				rv += " " + dfs(graph, visited, e.nbr);
			}
		}
		return rv;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int x = 1;
		while (x <= t) {
			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

			int vertex = scan.nextInt();
			int e = scan.nextInt();

			for (int i = 0; i < vertex; ++i) {
				graph.add(new ArrayList<>());
			}

			while (e-- > 0) {
				int src = scan.nextInt();
				int dest = scan.nextInt();
				addEdge(graph, src - 1, dest - 1, 1);
			}

			ArrayList<String> list = connectedComponents(graph);
//			System.out.println(list);
			int ans = 2 * list.size();

			for (String str : list) {
				for (int k = 0; k < str.length(); ++k) {
					if (str.charAt(k) == ' ') {
						++ans;
					}
				}
			}
			ans -= 2;
			System.out.println("Case #" + x + ": " + ans);

			++x;
		}
		scan.close();
	}

}
