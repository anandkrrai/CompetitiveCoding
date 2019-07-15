package hh;

import java.util.*;

public class infyroun2que2 {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
			children = new ArrayList<>();
		}
	}

	public static HashMap<Integer, Node> map = new HashMap<>();
	public static HashMap<String, Integer> times;

	public static boolean travel(int src, int dest, HashSet<Integer> visited) {
		if (src == dest) {
			return true;
		}

		if (visited.contains(src))
			return false;

		visited.add(src);

		Node node = map.get(src);
		boolean rv = false;

		for (Node child : node.children) {
			rv = travel(child.data, dest, visited);
			if (rv) {
				int from, to;
				if (src > child.data) {
					to = src;
					from = child.data;
				} else {
					to = child.data;
					from = src;
				}
				String s = from + " " + to;
				times.put(s, times.getOrDefault(s, 0) + 1);
				return rv;
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		times = new HashMap<>();

		for (int i = 1; i <= n; ++i) {
			Node node = new Node(i);
			map.put(i, node);
		}

		for (int i = 1; i < n; ++i) {
			int src = scan.nextInt();
			int dest = scan.nextInt();
			map.get(src).children.add(map.get(dest));
			map.get(dest).children.add(map.get(src));
		}

		int[] cost = new int[n - 1];
		for (int i = 0; i < n - 1; ++i) {
			cost[i] = scan.nextInt();
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = i + 1; j <= n; ++j) {
				travel(i, j, new HashSet<Integer>());
			}
		}
		ArrayList<Integer> numVisits = new ArrayList<Integer>();

		for (String x : times.keySet()) {
			numVisits.add(times.get(x));
		}

		Arrays.sort(cost);
		Collections.sort(numVisits);
		long ans = 0L;
		for (int i = 0; i < n - 1; ++i) {
			ans += cost[i] * numVisits.get(i);
		}
		System.out.println(ans);
		scan.close();
	}
}
