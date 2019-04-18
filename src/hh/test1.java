package hh;

import java.util.*;

public class test1 {

	public static HashMap<Integer, HashMap<Integer, Integer>> vces = new HashMap<>();

	public static void addVertex(int vname) {
		if (containsVertex(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public static boolean containsVertex(int vname) {
		return vces.containsKey(vname);
	}

	public static void addEdge(int v1name, int v2name, int wt) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public static int count, len;

	public static void TraverseAllPath(int src, int dest) {
		count = 0;
		len = 0;
		HashSet<Integer> visited = new HashSet<>();
		TraverseAllPathHelper(src, dest, visited, 0, "" + src);
		System.out.println(count);

	}
	
	private static void TraverseAllPathHelper(int src, int dest, HashSet<Integer> visited, int wt, String psf) {
		if (wt > len && count != 0)
			return;
		if (src == dest) {
//			System.out.println(psf);
			if (len == 0) {
				len = wt;
				++count;
			} else if (len > wt) {
				len = wt;
				count = 1;
			} else {
				++count;
			}
			return;
		}

		visited.add(src);

		for (int nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				TraverseAllPathHelper(nbr, dest, visited, wt + 1, psf + " " + nbr);
			}
		}
		visited.remove(src);

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		for (int i = 1; i <= n; ++i) {
			addVertex(i);
		}

		for (int i = 1; i <= m; ++i) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			addEdge(v1, v2, 1);
		}

		int q = scan.nextInt();

		for (int i = 1; i <= q; ++i) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			TraverseAllPath(v1, v2);

		}

		scan.close();
	}

}









//5 6
//1 2
//1 3
//1 4
//2 5
//3 5
//4 5
//2
//1 5
//3 4