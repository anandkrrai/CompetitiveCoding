package graphs;

import java.util.*;

public class topologicalSortAdjacencyMatrix {

	public static void main(String[] args) {

		String str = "\\/";
		System.out.println(str.length());
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		boolean graph[][] = new boolean[n][n];
		boolean processed[] = new boolean[n];
		LinkedList<Integer> result = new LinkedList<>();

		for (int i = 0; i < m; ++i) {

			int r = scan.nextInt();
			int c = scan.nextInt();

			graph[r - 1][c - 1] = true;

		}

		for (int i = n - 1; i >= 0; --i) {
			if (processed[i]) {
				continue;
			}

			topological(i, processed, result, graph);

		}
		while (!result.isEmpty()) {
			System.out.print(result.removeFirst() + 1 + " ");
		}
		scan.close();
	}

	private static void topological(int vertex, boolean[] processed, LinkedList<Integer> result, boolean[][] graph) {

		if (processed[vertex]) {
			return;
		}

		processed[vertex] = true;
		for (int i = processed.length - 1; i >= 0; --i) {
			if (graph[vertex][i]) {
				topological(i, processed, result, graph);
				// result.addFirst(i);
			}
		}
		result.addFirst(vertex);
	}

}