package cc;

import java.util.ArrayList;

public class judge {

	public static class Edge {
		int nbr;
		int wt;
		int count = 0;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest, int wt) {
		graph.get(src).add(new Edge(dest, wt));
	}

	public static void display(ArrayList<ArrayList<Edge>> graph) {

		System.out.println("=============================================");

		for (int i = 0; i < graph.size(); ++i) {
			System.out.print(i + "=>");
			for (int j = 0; j < graph.get(i).size(); ++j) {
				Edge edge = graph.get(i).get(j);
				System.out.print(" [ " + edge.nbr + "@" + edge.wt + "]");
			}
			System.out.println();
		}

		System.out.println("=============================================");
	}

	public static void makeGraph(int[][] trust, int N, ArrayList<ArrayList<Edge>> graph, int[] count) {

		for (int i = 0; i < N; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < trust.length; ++i) {
			addEdge(graph, trust[i][0] - 1, trust[i][1] - 1, 1);
			count[trust[i][1] - 1]++;
		}

	}

	public static int findJudge(int N, int[][] trust) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

		int[] count = new int[N];

		makeGraph(trust, N, graph, count);

		for (int i = 0; i < graph.size(); ++i) {
			if (count[i] == N - 1) {
				if (graph.get(i).size() == 0) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
//		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int N = 4;

		int[][] trust = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
		System.out.println(findJudge(3, trust));
	}

}
