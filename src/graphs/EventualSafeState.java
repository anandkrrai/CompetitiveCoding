package graphs;

import java.util.*;

public class EventualSafeState {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < graph.length; ++i) {
			boolean ans = dfs(graph, i, new int[graph.length]);
			if (ans)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}

	public boolean dfs(int[][] graph, int child, int[] visited) {
		if (visited[child] == 1) {
			return false;
		}
		visited[child] = 1;

		for (int i = 0; i < graph[child].length; ++i) {
			if (graph[child][i] == 0)
				continue;
			if (dfs(graph, i, visited) == false) {
				visited[child] = 0;
				return false;
			}
		}
		visited[child] = 0;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
