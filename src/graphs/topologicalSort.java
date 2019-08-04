package graphs;

import java.util.*;

public class topologicalSort {

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}

		public Edge(int nbr) {
			this.nbr = nbr;
			this.wt = 1;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

		// size of graph
		int n = scan.nextInt();
		for (int i = 0; i < n; ++i) {
			ArrayList<Edge> list = new ArrayList<>();
			graph.add(list);
		}

		int t = scan.nextInt();
		while (t-- > 0) {
			int parent = scan.nextInt();
			int child = scan.nextInt();
			addEdge(graph, parent - 1, child - 1);
		}

		Stack<Integer> st = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();

		Comparator<Edge> cmp = new Comparator<topologicalSort.Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.nbr - o2.nbr;
			}
		};

		for (int i = 0; i < graph.size(); ++i) {
			Collections.sort(graph.get(i), cmp);
		}

		for (int src = graph.size() - 1; src >= 0; --src) {
			if (!visited.contains(src)) {
				printTopologicalSort(graph, src, st, visited);
			}
		}
		while (st.size() != 0) {
			System.out.print(st.pop() + 1 + " ");
		}
		scan.close();

	}

	private static void printTopologicalSort(ArrayList<ArrayList<Edge>> graph, int src, Stack<Integer> st,
			HashSet<Integer> visited) {
		if (visited.contains(src)) {
			return;
		} else {
//			System.out.print(src + 1 + " ");
			visited.add(src);
		}
//		for (Edge edge : graph.get(src)) {
//			printTopologicalSort(graph, edge.nbr, st, visited);
//		}

		ArrayList<Edge> list = graph.get(src);
		for (int i = list.size() - 1; i >= 0; --i) {
			printTopologicalSort(graph, list.get(i).nbr, st, visited);
		}
		st.push(src);
	}

	private static void addEdge(ArrayList<ArrayList<Edge>> graph, int parent, int child) {
		graph.get(parent).add(new Edge(child));
	}

}
