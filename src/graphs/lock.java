package graphs;

import java.util.*;

public class lock {
	public static int openLock(String[] deadends, String target) {
		HashSet<Integer> visited = new HashSet<>();

		for (String deadend : deadends) {
			visited.add(Integer.parseInt(deadend));
		}

		int rv = bfs(visited, 0, Integer.parseInt(target));

		if (rv != Integer.MAX_VALUE)
			return rv;
		else
			return -1;

	}

	public static int[] arr = { 1, 10, 100, 1000, -1, -10, -100, -1000 };

	public static int bfs(HashSet<Integer> visited, int curr, int target) {
		if (curr > 9999 || curr < 0) {
			return Integer.MAX_VALUE;
		}

		if (curr == target)
			return 0;

		visited.add(curr);

		int rv = Integer.MAX_VALUE;

		for (int val : arr) {
			if (!visited.contains(curr + val))
				rv = Math.min(rv, bfs(visited, curr + val, target));
		}

//		if (!visited.contains(curr + 1))
//			rv = Math.min(rv, bfs(visited, curr + 1, target));
//		if (!visited.contains(curr + 10))
//			rv = Math.min(rv, bfs(visited, curr + 10, target));
//		if (!visited.contains(curr + 100))
//			rv = Math.min(rv, bfs(visited, curr + 100, target));
//		if (!visited.contains(curr + 1000))
//			rv = Math.min(rv, bfs(visited, curr + 1000, target));
//		if (!visited.contains(curr + -1))
//			rv = Math.min(rv, bfs(visited, curr + -1, target));
//		if (!visited.contains(curr + -10))
//			rv = Math.min(rv, bfs(visited, curr + -10, target));
//		if (!visited.contains(curr + -100))
//			rv = Math.min(rv, bfs(visited, curr + -100, target));
//		if (!visited.contains(curr + -1000))
//			rv = Math.min(rv, bfs(visited, curr + -1000, target));

		if (rv != Integer.MAX_VALUE)
			rv += 1;

//		visited.remove(curr);
		return rv;
	}

	public static void main(String[] args) {
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0001";

		System.out.println(openLock(deadends, target));
	}
}
