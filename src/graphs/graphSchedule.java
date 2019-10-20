package graphs;

import java.util.*;

public class graphSchedule {

	public boolean canFinish(int n, int[][] prerequisites) {
		HashSet<Integer> processed = new HashSet<>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; ++i) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		boolean rv = false;
		for (int i = 0; i < graph.size(); ++i) {
			if (!processed.contains(i))
				rv = rv || isCyclic(i, new HashSet<Integer>(), graph, processed);
			if (rv)
				return false;
		}

		return true;
	}


	public boolean isCyclic(int src, HashSet<Integer> visited, ArrayList<ArrayList<Integer>> graph,
			HashSet<Integer> processed) {
		if (visited.contains(src))
			return true;

		visited.add(src);
		processed.add(src);

		boolean rv = false;
		for (int i = 0; i < graph.get(src).size(); ++i) {
			rv = rv || isCyclic(graph.get(src).get(i), visited, graph, processed);
			if (rv)
				break;
		}

		visited.remove(src);
		return rv;
	}

	public int[] findOrder(int n, int[][] prerequisites) {
		HashSet<Integer> processed = new HashSet<>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int[] rv = new int[n];
		int k = n - 1;

		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; ++i) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		for (int i = 0; i < graph.size(); ++i) {
			if (!processed.contains(i)) {
				dfs(i, graph, new HashSet<Integer>(), processed, stack);
			}

		}
		while (stack.size() != 0) {
			rv[k--] = stack.pop();
		}
		return rv;
	}

	public void dfs(int src, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited, HashSet<Integer> processed,
			Stack<Integer> stack) {

		if (processed.contains(src))
			return;

		visited.add(src);
		processed.add(src);

		for (int i = 0; i < graph.get(src).size(); ++i) {
			dfs(graph.get(src).get(i), graph, visited, processed, stack);
		}

		visited.remove(src);
		stack.push(src);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
