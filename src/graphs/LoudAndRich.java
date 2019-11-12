package graphs;

import java.util.*;

public class LoudAndRich {

	public static class Node {
		int n;
		HashSet<Node> set;

		public Node(int val) {
			this.n = val;
			set = new HashSet<>();
		}
	}

	public static class Pair {
		int node, q;

		public Pair(int node, int quiet) {
			this.node = node;
			this.q = quiet;
		}
	}

	public static class PairItr {
		int node, status;

		public PairItr(int node, int status) {
			this.node = node;
			this.status = status;
		}
	}

	public static Pair dfs(Node node, int[] rv, int[] quiet) {
		if (rv[node.n] != -1) {
			return new Pair(rv[node.n], quiet[rv[node.n]]);
		}
		Pair ans = new Pair(node.n, quiet[node.n]);

		for (Node child : node.set) {
			Pair p = dfs(child, rv, quiet);
			if (ans.q >= p.q) {
				ans = p;
			}
		}

		rv[node.n] = ans.node;
		return ans;
	}

	public static int[] loudAndRich(int[][] richer, int[] quiet) {

		HashMap<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < quiet.length; ++i) {
			map.put(i, new Node(i));
		}
		int[] rv = new int[quiet.length];
		Arrays.fill(rv, -1);

		for (int[] arr : richer) {
			map.get(arr[1]).set.add(map.get(arr[0]));
		}

		for (int i = 0; i < rv.length; ++i) {
			if (rv[i] == -1) {
				dfs(map.get(i), rv, quiet);
			}
		}

		return rv;
	}

	public static int[] loudAndRichItetrative(int[][] richer, int[] quiet) {

		HashMap<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < quiet.length; ++i) {
			map.put(i, new Node(i));
		}
		int[] rv = new int[quiet.length];
		Arrays.fill(rv, -1);

		for (int[] arr : richer) {
			map.get(arr[1]).set.add(map.get(arr[0]));
		}

		Stack<PairItr> stack = new Stack<>();

		for (int i = 0; i < rv.length; ++i) {
			if (rv[i] == -1) {
				stack.push(new PairItr(i, 0));

				while (stack.size() != 0) {
					PairItr rem = stack.pop();

				}
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		int[][] rich = { { 0, 1 }, { 1, 2 } };
		int[] quiet = { 0, 2, 1 };
		int[] rv = loudAndRich(rich, quiet);
		for (int val : rv) {
			System.out.print(val + " ");
		}
	}
}
