package graphs;

import java.util.*;

public class Kosaraju {

	public static class Edge {
		int nbr, weight;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.weight = wt;
		}
	}

	public static ArrayList<ArrayList<Integer>> invert(ArrayList<ArrayList<Integer>> graph) {
		ArrayList<ArrayList<Integer>> myGraph = new ArrayList<>();
		for (int i = 0; i < graph.size(); ++i) {
			myGraph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < graph.size(); ++i) {
			for (int nbr : graph.get(i)) {
				myGraph.get(nbr).add(i);
			}
		}
		return myGraph;

	}

	public static void display(ArrayList<ArrayList<Integer>> graph) {
		for (int i = 0; i < graph.size(); ++i) {
			String str = i + "->";
			for (int nbr : graph.get(i)) {
				str += nbr + ",";
			}
			System.out.println(str);
		}
		System.out.println("==============================");
	}

	public static String dfs(ArrayList<ArrayList<Integer>> graph, int src, HashSet<Integer> set) {
		if (set.contains(src))
			return "";

		set.add(src);
		String rv = src + " ";
		for (int nbr : graph.get(src))
			rv += "" + dfs(graph, nbr, set);
		return rv;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, HashSet<Integer> set, Stack<Integer> stack) {
		if (set.contains(src))
			return;

		set.add(src);

		for (int nbr : graph.get(src))
			dfs(graph, nbr, set, stack);
		stack.push(src);
	}

	public static int numStronglyConnectedComponents(ArrayList<ArrayList<Integer>> graph) {
		HashSet<Integer> set = new HashSet<>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < graph.size(); ++i) {
			if (!set.contains(i)) {
				dfs(graph, i, set, stack);
			}
		}
		graph = invert(graph);
		set = new HashSet<Integer>();
		int count = 0;

		while (stack.size() != 0) {
			int src = stack.pop();
			if (!set.contains(src)) {
				System.out.println(dfs(graph, src, set));
				++count;
			}
		}

		graph = invert(graph);
		return count;

	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 11; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		graph.get(0).add(1);
		graph.get(1).add(2);
		graph.get(2).add(0);
		graph.get(2).add(3);
		graph.get(3).add(4);
		graph.get(4).add(5);
		graph.get(5).add(6);
		graph.get(6).add(3);
		graph.get(6).add(7);
		graph.get(7).add(8);
		graph.get(8).add(9);
		graph.get(9).add(7);
		graph.get(9).add(10);

//		display(graph);
//		graph = invert(graph);
//		display(graph);
//		graph = invert(graph);
//		display(graph);

		System.out.println("num of Strongly connected components = " +numStronglyConnectedComponents(graph));
	}
}
