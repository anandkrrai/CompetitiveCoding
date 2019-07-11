package graphs;

import java.util.*;

public class graph {

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest, int wt) {
		graph.get(src).add(new Edge(dest, wt));
		graph.get(dest).add(new Edge(src, wt));
	}

	public static void addDirectedEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest, int wt) {
		graph.get(src).add(new Edge(dest, wt));
		graph.get(dest).add(new Edge(src, wt));
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

	public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited) {
		if (src == dest)
			return true;

		if (visited[src])
			return false;

		visited[src] = true;
		ArrayList<Edge> list = graph.get(src);

		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			boolean rv = hasPath(graph, edge.nbr, dest, visited);

			if (rv)
				return rv;
		}
		return false;
	}

	public static void printAllPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
			String path) {
		if (src == dest) {
			System.out.println(path);
			return;
		}
		if (visited[src])
			return;

		visited[src] = true;
		ArrayList<Edge> list = graph.get(src);

		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			printAllPath(graph, edge.nbr, dest, visited, path + "=>" + edge.nbr);

		}
		visited[src] = false;
	}

	public static class Node {
		int pathLength;
		String path;
	}

	public static void kLargest(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited, int pathLength,
			String path, ArrayList<Node> myList) {
		if (src == dest) {
			Node temp = new Node();
			temp.pathLength = pathLength;
			temp.path = path;
			myList.add(temp);
			return;
		}
		if (visited[src])
			return;

		visited[src] = true;
		ArrayList<Edge> list = graph.get(src);

		for (int i = 0; i < list.size(); ++i) {
			Edge edge = list.get(i);
			kLargest(graph, edge.nbr, dest, visited, pathLength + edge.wt, path + "=>" + edge.nbr, myList);
		}
		visited[src] = false;
	}

	public static void kLargest(int k, int floor, int ceil) {
		ArrayList<Node> list = new ArrayList<Node>();
		kLargest(graph, 0, 6, new boolean[graph.size()], 0, "0", list);

		Comparator<Node> cmp = new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.pathLength - n2.pathLength;
			}
		};

		Collections.sort(list, cmp);

		for (Node node : list) {
			System.out.println("length:" + node.pathLength + " path:" + node.path);
		}

		System.out.println("Kth-Largest: path: " + list.get(k - 1).path + " length=" + list.get(k - 1).pathLength);

		int myceil = 0, myFloor = 0;
		String myceilPath = "null", myfloorPath = "null";

		for (Node node : list) {
			if (node.pathLength > floor)
				break;

			myFloor = node.pathLength;
			myfloorPath = node.path;
		}
		System.out.println();
		System.out.println("FLOOR: path: " + myfloorPath + " length=" + myFloor);
		System.out.println();

		for (int i = list.size() - 1; i >= 0; --i) {
			Node node = list.get(i);
			if (node.pathLength < ceil)
				break;

			myceil = node.pathLength;
			myceilPath = node.path;
		}
		System.out.println("CEIL: path: " + myceilPath + " length=" + myceil);

	}

	public static class Triplet {
		int vertex;
		int pathLen;
		String psf;

		public Triplet(int vertex, int pathLen, String psf) {
			this.vertex = vertex;
			this.pathLen = pathLen;
			this.psf = psf;
		}
	}

	public static boolean BSF(ArrayList<ArrayList<Edge>> graph, int src, int dest) {

		LinkedList<Triplet> queue = new LinkedList<>();
		Triplet tp = new Triplet(src, 0, src + "");
		boolean[] visited = new boolean[graph.size()];

		queue.addLast(tp);

		while (queue.size() > 0) {

			Triplet rem = queue.removeFirst();

			System.out.println(rem.vertex + " via " + rem.psf + " @ " + rem.pathLen);

			if (visited[rem.vertex]) {
				continue;
			} else {
				visited[rem.vertex] = true;
			}

			if (rem.vertex == dest) {
				return true;
			}

			for (int i = 0; i < graph.get(rem.vertex).size(); ++i) {
				Edge edge = graph.get(rem.vertex).get(i);
				if (visited[edge.nbr] == false) {
					Triplet child = new Triplet(edge.nbr, rem.pathLen + edge.wt, rem.psf + "->" + edge.nbr);
					queue.addLast(child);
				}
			}
		}
		return false;
	}

	public static ArrayList<String> connectedComponents(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<String> rv = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];

		for (int i = 0; i < visited.length; ++i) {
			if (visited[i]) {
				continue;
			} else {
				visited[i] = true;
				String str = dfs(graph, visited, i);
				rv.add(str);
			}
		}
		return rv;
	}

	public static String dfs(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src) {
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		String rv = src + "";
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				rv += " " + dfs(graph, visited, e.nbr);
			}
		}
		return rv;
	}

	public static boolean isCyclic(ArrayList<ArrayList<Edge>> graph) {

		boolean rv = false;
		boolean[] visited = new boolean[graph.size()];

		for (int i = 0; i < visited.length; ++i) {
			if (visited[i]) {
				continue;
			} else {
				visited[i] = true;
				rv |= isCyclicHelper(graph, visited, i);
				if (rv)
					return rv;
			}
		}
		return rv;
	}

	public static boolean isCyclicHelper(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src) {
		if (visited[src] == true)
			return true;

		visited[src] = true;
		boolean rv = false;
		ArrayList<Edge> edges = graph.get(src);
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				rv |= isCyclicHelper(graph, visited, e.nbr);
			}
		}
		return rv;
	}

	public static ArrayList<Integer> connectedComponents_astronaut(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<Integer> rv = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];

		for (int i = 0; i < visited.length; ++i) {
			if (visited[i]) {
				continue;
			} else {
				visited[i] = true;
				int val = dfs_astronaut(graph, visited, i);
				rv.add(val);
			}
		}
		return rv;
	}

	public static int dfs_astronaut(ArrayList<ArrayList<Edge>> graph, boolean[] visited, int src) {
		visited[src] = true;
		ArrayList<Edge> edges = graph.get(src);
		int rv = 1;
		for (Edge e : edges) {
			if (!visited[e.nbr]) {
				rv += dfs_astronaut(graph, visited, e.nbr);
			}
		}
		return rv;
	}

	public static int astro(int n, int[] arr1, int[] arr2) {
		ArrayList<ArrayList<Edge>> graph1 = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			graph1.add(new ArrayList<>());
		}

		for (int i = 0; i < arr1.length; ++i) {
			addEdge(graph1, arr1[i], arr2[i], 1);
		}

		int ans = 0;

		display(graph1);
		ArrayList<Integer> list = connectedComponents_astronaut(graph1);

		for (int x : list)
			System.out.print(x + " ");

		System.out.println();
		for (int i = 0; i < list.size(); ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				ans += list.get(i) * list.get(j);
			}
		}

		return ans;
	}

	public static boolean BSF_Diameter(ArrayList<ArrayList<Edge>> graph, int src, int dest) {

		LinkedList<Triplet> queue = new LinkedList<>();
		Triplet tp = new Triplet(src, 0, src + "");
		boolean[] visited = new boolean[graph.size()];

		queue.addLast(tp);

		while (queue.size() > 0) {

			Triplet rem = queue.removeFirst();

			System.out.println(rem.vertex + " via " + rem.psf + " @ " + rem.pathLen);

			if (visited[rem.vertex]) {
				continue;
			} else {
				visited[rem.vertex] = true;
			}

			if (rem.vertex == dest) {
				return true;
			}

			for (int i = 0; i < graph.get(rem.vertex).size(); ++i) {
				Edge edge = graph.get(rem.vertex).get(i);
				if (visited[edge.nbr] == false) {
					Triplet child = new Triplet(edge.nbr, rem.pathLen + edge.wt, rem.psf + "->" + edge.nbr);
					queue.addLast(child);
				}
			}
		}
		return false;
	}

	public static class Bi_partrite_helper {
		int vertex;
		Integer colour;

		public Bi_partrite_helper(int vertex, int colour) {
			this.vertex = vertex;
			this.colour = colour * -1;
		}

		public Bi_partrite_helper(int vertex) {
			this.vertex = vertex;
			this.colour = null;
		}
	}

	// bipart

	public static class bihelp {
		int vertex;
		int level;

		bihelp(int level, int vertex) {
			this.level = level;
			this.vertex = vertex;
		}
	}

	public static boolean biPartite(ArrayList<ArrayList<Edge>> graph) {
		LinkedList<bihelp> queue = new LinkedList<>();
		int[] eo = new int[graph.size()];
		Arrays.fill(eo, -1);
		bihelp nn = new bihelp(0, 0);
		queue.addLast(nn);

		while (queue.size() > 0) {

			bihelp rm = queue.removeFirst();
			if (eo[rm.vertex] == -1) {
				eo[rm.vertex] = rm.level % 2;
			} else if (eo[rm.vertex] == rm.level % 2) {
				continue;
			} else {
				return false;
			}

			ArrayList<Edge> edges = graph.get(rm.vertex);

			for (Edge ed : edges) {
				if (eo[ed.nbr] == -1) {
					bihelp ne = new bihelp(rm.level + 1, ed.nbr);
					queue.addLast(ne);
				}
			}
		}

		return true;
	}

	// don't refer this
	public static boolean Bi_partrite(ArrayList<ArrayList<Edge>> graph, int src) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		// colour1=1, colour2=0;
		LinkedList<Integer> list = new LinkedList<>();
		map.put(src, true);// color 0
		list.addLast(src);
		while (list.size() != 0) {

			int rm = list.removeFirst();
			ArrayList<Edge> edges = graph.get(rm);

			for (Edge edge : edges) {

				if (!map.containsKey(edge.nbr)) {
					list.addLast(edge.nbr);
					map.put(edge.nbr, !map.get(rm));
				} else {
					if (map.get(edge.nbr) == map.get(rm))
						return false;
				}
			}
		}
		return true;
	}

	public static class DiaxtraHElper implements Comparable<DiaxtraHElper> {
		int vertex;
		int distSoFar;
		String path;

		public DiaxtraHElper(int vertex, int distSoFar, String path) {
			this.vertex = vertex;
			this.distSoFar = distSoFar;
			this.path = path;
		}

		@Override
		public int compareTo(DiaxtraHElper o) {
			return this.distSoFar - o.distSoFar;
		}

		@Override
		public String toString() {
			return this.vertex + " vis " + this.path + " @  " + this.distSoFar;
		}
	}

	public static void Diaxtra(ArrayList<ArrayList<Edge>> graph, int src) {
		PriorityQueue<DiaxtraHElper> que = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.size()];

		que.add(new DiaxtraHElper(src, 0, ""));

		while (que.size() != 0) {
			DiaxtraHElper rem = que.remove();

			if (visited[rem.vertex]) {
				continue;
			} else {
				visited[rem.vertex] = true;
			}
			System.out.println(rem);

			ArrayList<Edge> nbrs = graph.get(rem.vertex);

			for (Edge nbr : nbrs) {
				if (!visited[nbr.nbr]) {
					que.add(new DiaxtraHElper(nbr.nbr, rem.distSoFar + nbr.wt, rem.path + nbr.nbr + ""));
				}
			}

		}
	}

	public static class primsHelper implements Comparable<primsHelper> {
		int vertex;
		int dist;
		int parent;

		public primsHelper(int vertex, int dist, int parent) {
			this.vertex = vertex;
			this.dist = dist;
			this.parent = parent;
		}

		@Override
		public int compareTo(primsHelper o) {
			return this.dist - o.dist;
		}
	}

	public static ArrayList<ArrayList<Edge>> prims(ArrayList<ArrayList<Edge>> graph, int src) {
		PriorityQueue<primsHelper> que = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.size()];

		ArrayList<ArrayList<Edge>> myGraph = new ArrayList<>();

		for (int i = 0; i < graph.size(); ++i) {
			myGraph.add(new ArrayList<>());
		}

		que.add(new primsHelper(src, 0, -1));

		while (que.size() != 0) {
			primsHelper rem = que.remove();

			if (visited[rem.vertex]) {
				continue;
			} else {
				visited[rem.vertex] = true;
			}

			if (rem.parent != -1) {
				addEdge(myGraph, rem.parent, rem.vertex, rem.dist);
			}

			ArrayList<Edge> nbrs = graph.get(rem.vertex);

			for (Edge nbr : nbrs) {
				if (!visited[nbr.nbr]) {
					que.add(new primsHelper(nbr.nbr, nbr.wt, rem.vertex));
				}
			}

		}
		return myGraph;
	}

	public static class Kedge implements Comparable<Kedge> {
		int v1;
		int v2;
		int w;

		public Kedge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;

		}

		@Override
		public int compareTo(Kedge o) {
			return 0;
		}
	}

	public static ArrayList<ArrayList<Edge>> krushkal(ArrayList<ArrayList<Edge>> graph) {
		ArrayList<ArrayList<Edge>> myGraph = new ArrayList<>();

		for (int i = 0; i < graph.size(); ++i) {
			myGraph.add(new ArrayList<>());
		}

		int[] pa = new int[graph.size()];
		int[] ra = new int[graph.size()];

		Arrays.fill(ra, 1);
		for (int i = 0; i < pa.length; ++i) {
			pa[i] = i;
		}

		PriorityQueue<Kedge> que = new PriorityQueue<>();

		for (int i = 0; i < graph.size(); ++i) {
			for (int j = 0; j < graph.get(i).size(); ++i) {
				if (i < graph.get(i).get(j).nbr) {
					que.add(new Kedge(i, graph.get(i).get(j).nbr, graph.get(i).get(j).wt));
				}
			}
		}

		while (que.size() != 0) {

			Kedge rem = que.remove();

			int v1l = find(pa, rem.v1);
			int v2l = find(pa, rem.v2);

			if (v1l != v2l) {
				addEdge(myGraph, rem.v1, rem.v2, rem.w);
				merge(pa, ra, v1l, v2l);
			}

		}

		return myGraph;
	}

	private static void merge(int[] pa, int[] ra, int v1sl, int v2sl) {

		if (ra[v1sl] < ra[v2sl]) {
			pa[v1sl] = v2sl;
		} else if (ra[v2sl] < ra[v1sl]) {
			pa[v2sl] = v1sl;
		} else {
			pa[v1sl] = v2sl;
			ra[v2sl]++;
		}
	}

	private static int find(int[] pa, int v1) {
		if (pa[v1] == v1) {
			return v1;
		}
		return find(pa, pa[v1]);
	}

	public static void HamiltonionPathHelper(ArrayList<ArrayList<Edge>> graph, int src, int osrc,
			ArrayList<Integer> psf, boolean[] visited) {

		if (psf.size() == graph.size() - 1) {
			for (int x : psf) {
				System.out.print(x + " ");
			}
			System.out.print(src);

			int last = src;
			boolean isCycle = false;

			ArrayList<Edge> nbrs = graph.get(osrc);
			for (Edge nbr : nbrs) {
				if (nbr.nbr == last) {
					isCycle = true;
					break;
				}
			}

			if (isCycle) {
				System.out.println("*");
			} else {
				System.out.println(".");
			}

		}

		visited[src] = true;

		ArrayList<Edge> nbrs = graph.get(src);

		for (Edge nbr : nbrs) {
			if (!visited[nbr.nbr]) {
				psf.add(src);
				HamiltonionPathHelper(graph, nbr.nbr, osrc, psf, visited);
				psf.remove(psf.size() - 1);
			}
		}
		visited[src] = false;
	}

	public static int[][] floydWarshal(ArrayList<ArrayList<Edge>> graph) {
		int[][] rv = new int[graph.size()][graph.size()];

		for (int i = 0; i < rv.length; ++i)
			Arrays.fill(rv[i], Integer.MAX_VALUE);

		for (int i = 0; i < graph.size(); ++i) {
			rv[i][i] = 0;

			ArrayList<Edge> nbrs = graph.get(i);
			for (Edge nbr : nbrs) {
				rv[i][nbr.nbr] = nbr.wt;
			}
		}

		for (int i = 0; i < graph.size(); ++i) {
			for (int src = 0; src < graph.size(); ++src) {
				for (int dest = 0; dest < graph.size(); ++dest) {
					if (src == i || dest == i || src == dest || rv[i][dest] == Integer.MAX_VALUE
							|| rv[src][i] == Integer.MAX_VALUE)
						continue;
					else {
						rv[src][dest] = Math.min(rv[src][dest], rv[src][i] + rv[i][dest]);
					}
				}
			}
		}
		return rv;
	}

	public static void bellmanFord(ArrayList<ArrayList<Edge>> graph, int src) {
		int[] res = new int[graph.size()];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[src] = 0;

		ArrayList<Kedge> alledges = new ArrayList<>();

		for (int v = 0; v < graph.size(); ++v) {
			for (int n = 0; n < graph.get(v).size(); ++n) {
				Edge ne = graph.get(v).get(n);
				Kedge ke = new Kedge(v, ne.nbr, ne.wt);
				alledges.add(ke);
			}
		}

		for (int i = 0; i < graph.size() - 1; ++i) {
			for (int j = 0; j < alledges.size(); ++j) {
				Kedge ke = alledges.get(j);
				if (res[ke.v1] != Integer.MAX_VALUE) {
					if (res[ke.v1] + graph.get(ke.v1).get(ke.v2).wt < res[ke.v2]) {
						res[ke.v2] = res[ke.v1] + graph.get(ke.v1).get(ke.v2).wt;
					}
				}
			}
		}
		for (int j = 0; j < alledges.size(); ++j) {

			Kedge ke = alledges.get(j);

			if (res[ke.v1] != Integer.MAX_VALUE) {
				if (res[ke.v1] + graph.get(ke.v1).get(ke.v2).wt < res[ke.v2]) {
					res[ke.v2] = res[ke.v1] + graph.get(ke.v1).get(ke.v2).wt;
				}
			}

		}

	}

	public static void main(String[] args) {

		for (int i = 0; i < 7; ++i) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 5, 6, 3);
		addEdge(graph, 4, 6, 8);

		// for(int i=0;i<23;++i){
		// graph.add(new ArrayList<>());
		// }

		// addEdge(graph, 0,15,1);
		// addEdge(graph, 1,15,1);
		// addEdge(graph, 2,15,1);
		// addEdge(graph, 3,2,1);
		// addEdge(graph, 2,4,1);
		// addEdge(graph, 4,5,1);
		// addEdge(graph, 4,6,1);
		// addEdge(graph, 2,7,1);
		// addEdge(graph, 7,9,1);
		// addEdge(graph, 9,10,1);
		// addEdge(graph, 10,11,1);
		// addEdge(graph, 10,12,1);
		// addEdge(graph, 12,13,1);
		// addEdge(graph, 12,14,1);
		// addEdge(graph, 7,8,1);
		// addEdge(graph, 16,8,1);
		// addEdge(graph, 16,7,1);
		// addEdge(graph, 16,18,1);
		// addEdge(graph, 16,19,1);
		// addEdge(graph, 20,19,1);
		// addEdge(graph, 20,22,1);
		// addEdge(graph, 20,21,1);

		// display(graph);
		// System.out.println(hasPath(graph, 0, 6, new boolean[graph.size()]));
		// printAllPath(graph,0,6,new boolean[graph.size()],"");
		// kLargest(3,41,49);
		// System.out.println( BSF(graph,0,6));

		// ArrayList<String> list = connectedComponents(graph);

		// for(String str:list)
		// System.out.println(str);

		// System.out.println(isCyclic(graph));

		// int n=12;
		// int[] arr1={1,6,8,2,9,10,0};
		// int[] arr2={2,9,3,5,5,3,11};

		// // System.out.println(astro(n, arr1, arr2));

		// System.out.println(Bi_partrite(graph, 0));

		// Diaxtra(graph,0);

		// display(prims(graph, 0));

		// addEdge(graph, 2, 5, 1);
		// HamiltonionPathHelper(graph, 2, 2, new ArrayList<Integer>(), new
		// boolean[graph.size()]);

		ArrayList<ArrayList<Edge>> graph1 = new ArrayList<>();

		for (int i = 0; i < 7; ++i) {
			graph1.add(new ArrayList<>());
		}

		addDirectedEdge(graph1, 0, 1, 10);
		addDirectedEdge(graph1, 1, 2, 10);
		addDirectedEdge(graph1, 2, 3, 10);
		addDirectedEdge(graph1, 0, 3, 40);
		addDirectedEdge(graph1, 3, 4, 2);
		addDirectedEdge(graph1, 4, 5, 3);
		addDirectedEdge(graph1, 5, 6, 3);
		addDirectedEdge(graph1, 4, 6, 8);

		int[][] arr = floydWarshal(graph1);
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}