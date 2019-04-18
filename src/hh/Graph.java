package hh;

import java.util.*;

public class Graph {

	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (containsVertex(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removeVertex(String vname) {
		if (containsVertex(vname)) {
			ArrayList<String> nbrnames = new ArrayList<>(vces.get(vname).keySet());
			for (String nbrname : nbrnames) {
				removeEdge(nbrname, vname);
			}

			vces.remove(vname);
		}

	}

	public int countEdges() {
		int count = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());

		for (String vname : vnames) {
			count += vces.get(vname).size();
		}

		return count / 2;
	}

	public boolean containEdge(String v1name, String v2name) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		} else {
			return false;
		}
	}

	public void addEdge(String v1name, String v2name, int wt) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void display() {

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		System.out.println("------------------------------------");
		for (String vname : vnames) {
			System.out.println(vname + "=" + vces.get(vname));
		}
	}

	public boolean hasPath(String src, String dest) {

		HashSet<String> visited = new HashSet<>();
		return hasPathHelper(src, dest, visited);

	}

	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {
		if (src.equals(dest)) {
			return true;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				boolean hpfntod = hasPathHelper(nbr, dest, visited);

				if (hpfntod == true) {
					return true;
				}
			}
		}
		return false;
	}

	public void printallPath(String src, String dest) {

		HashSet<String> visited = new HashSet<>();
		printallPathHelper(src, dest, visited, src);

	}

	private void printallPathHelper(String src, String dest, HashSet<String> visited, String psf) {
		if (src.equals(dest)) {
			System.out.println(psf);
			return;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				printallPathHelper(nbr, dest, visited, psf + nbr);
			}
		}
		visited.remove(src);

	}

	private String sp;
	private String lp;
	private String cp;
	private String fp;
	private int spw;
	private int lpw;
	private int cpw;
	private int fpw;

	public void multisolver(String s, String d, int cf, int ff) {
		spw = Integer.MAX_VALUE;
		lpw = Integer.MIN_VALUE;
		cpw = Integer.MAX_VALUE;
		fpw = Integer.MIN_VALUE;

		sp = "";
		lp = "";
		cp = "";
		fp = "";

		multisolver(s, d, new HashSet<>(), cf, ff, s, 0);
		System.out.println("Shortest = " + sp + "@" + spw);
		System.out.println("Longest = " + lp + "@" + lpw);
		System.out.println("Ceil = " + cp + "@" + cpw);
		System.out.println("Floor = " + fp + "@" + fpw);

	}

	private void multisolver(String s, String d, HashSet<String> visited, int cf, int ff, String psf, int wsf) {

		if (s.equals(d)) {

			System.out.println(psf + "@" + wsf);
			if (wsf < spw) {
				sp = psf;
				spw = wsf;
			}

			if (wsf > lpw) {
				lp = psf;
				lpw = wsf;
			}

			if (wsf > cf && wsf < cpw) {
				cp = psf;
				cpw = wsf;
			}

			if (wsf < ff && wsf > fpw) {
				fp = psf;
				fpw = wsf;
			}

		}

		visited.add(s);

		for (String nbr : vces.get(s).keySet()) {
			if (visited.contains(nbr) == false) {
				multisolver(nbr, d, visited, cf, ff, psf + nbr, wsf + vces.get(s).get(nbr));
			}
		}
		visited.remove(s);

	}

//	private PriorityQueue<pair> pq;

//	public void kthlargest(String s, String d, int k) {
//
//		pq = new PriorityQueue<>();
//		multisolver(s, d, new HashSet<>(), k, s, 0);
//		while (pq.size() > 0) {
//			pair x = pq.remove();
//			System.out.println(x.path + "@" + x.data);
//		}
//	}

//	private void multisolver(String s, String d, HashSet<String> visited, int k, String psf, int wsf) {

//		if (s.equals(d)) {
//			if (pq.size() < k) {
//				pair p = new pair();
//				p.data = wsf;
//				p.path = psf;
//				pq.add(p);
//			} else if (pq.peek().data < wsf) {
//				pair x = pq.remove();
//				x.data = wsf;
//				x.path = psf;
//				pq.add(x);
//			}
//		}
//		visited.add(s);
//		for (String nbr : vces.get(s).keySet()) {
//			if (visited.contains(nbr) == false) {
//				multisolver(nbr, d, visited, k, psf + nbr, wsf + vces.get(s).get(nbr));
//			}
//		}
//		visited.remove(s);
//
//	}

	private class Tpair implements Comparable<Tpair> {
		String v;
		String p;
		int w;

		public Tpair(String v, String p, int w) {
			this.v = v;
			this.p = p;
			this.w = w;
		}

		@Override
		public int compareTo(Tpair arg0) {
			return this.w - arg0.w;
		}

	}

	public boolean bfs(String s, String d) {

		LinkedList<Tpair> queue = new LinkedList<>();

		queue.add(new Tpair(s, s, 0));
		HashSet<String> visited = new HashSet<>();
		while (queue.size() > 0) {

			Tpair rem = queue.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + "@" + rem.p);

			if (rem.v.equals(d)) {
				return true;
			}
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {

					Tpair np = new Tpair(nbr, rem.p + nbr, rem.w + vces.get(rem.v).get(nbr));
					queue.addLast(np);
				}
			}

		}

		return false;
	}

	public boolean dfs(String s, String d) {

		LinkedList<Tpair> stack = new LinkedList<>();

		stack.add(new Tpair(s, s, 0));

		HashSet<String> visited = new HashSet<>();
		while (stack.size() > 0) {

			Tpair rem = stack.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + "@" + rem.p);

			if (rem.v.equals(d)) {
				return true;
			}
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {

					Tpair np = new Tpair(nbr, rem.p + nbr, rem.w + vces.get(rem.v).get(nbr));
					stack.addFirst(np);
				}
			}

		}

		return false;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> a = new ArrayList<>();

		HashSet<String> visited = new HashSet<>();

		for (String s : vces.keySet()) {
			if (visited.contains(s) == false) {
				a.add(connectedComponents(s, visited));
			}
		}
		return a;
	}

	public String connectedComponents(String s, HashSet<String> visited) {

		LinkedList<String> queue = new LinkedList<>();

		String comp = "";
		queue.add(s);

		while (queue.size() > 0) {
			// 1.Remove
			String rem = queue.removeFirst();

			// 2.Mark
			if (visited.contains(rem)) {
				continue;
			}
			visited.add(rem);

			// 3.Work
			comp += rem;

			// 4.Neighbour
			for (String nbr : vces.get(rem).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(nbr);

				}
			}

		}

		return comp;

	}

	public boolean iscyclic() {

		HashSet<String> visited = new HashSet<>();

		for (String s : vces.keySet()) {
			if (visited.contains(s) == false) {
				if (connectedComponents1(s, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean connectedComponents1(String s, HashSet<String> visited) {

		LinkedList<String> queue = new LinkedList<>();

		queue.add(s);

		while (queue.size() > 0) {
			// 1.Remove
			String rem = queue.removeFirst();

			// 2.Mark
			if (visited.contains(rem)) {
				return true;
			}
			visited.add(rem);

			for (String nbr : vces.get(rem).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(nbr);

				}
			}

		}

		return false;

	}

	public boolean isconnected() {

		ArrayList<String> arr = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		String s = isconnected(arr.get(0), visited);

		if (s.length() == arr.size()) {
			return true;
		} else {
			return false;
		}

	}

	public String isconnected(String s, HashSet<String> visited) {

		LinkedList<String> queue = new LinkedList<>();

		String comp = "";
		queue.add(s);

		while (queue.size() > 0) {
			// 1.Remove
			String rem = queue.removeFirst();

			// 2.Mark
			if (visited.contains(rem)) {
				continue;
			}
			visited.add(rem);

			// 3.Work
			comp += rem;

			// 4.Neighbour
			for (String nbr : vces.get(rem).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(nbr);

				}
			}

		}

		return comp;

	}

	public boolean isBipartite() {

		HashMap<String, Integer> visited = new HashMap<>();

		for (String s : vces.keySet()) {
			if (visited.containsKey(s) == false) {
				if (!isBipartite(s, visited)) {
					return false;
				}
			}
		}

		return true;

	}

	public boolean isBipartite(String s, HashMap<String, Integer> visited) {

		LinkedList<String> curr = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();

		int level = 0;

		String comp = "";
		curr.add(s);

		while (curr.size() > 0) {
			// 1.Remove
			String rem = curr.removeFirst();

			// 2.Mark
			if (visited.containsKey(rem)) {
				if (level % 2 != visited.get(rem) % 2) {

					return false;
				}
			}
			visited.put(rem, level);

			for (String nbr : vces.get(rem).keySet()) {
				if (visited.containsKey(nbr) == false) {
					next.addLast(nbr);

				}
			}

			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<>();
				level++;
			}

		}

		return true;
	}

	public void HamiltonianCycleandPath(String src) {

		HashSet<String> visited = new HashSet<>();
		HamiltonianCycleandPath(src, src, visited, src);

	}

	private void HamiltonianCycleandPath(String src, String s, HashSet<String> visited, String psf) {
		if (visited.size() == vces.keySet().size() - 1) {
			System.out.println(psf);
			if (containEdge(s, src)) {
				System.out.println("is Hamiltonial Cycle" + psf);
			}
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				HamiltonianCycleandPath(nbr, s, visited, psf + nbr);
			}
		}
		visited.remove(src);

	}

	private class Dpair implements Comparable<Dpair> {
		String v;
		String p;
		int w;

		public Dpair(String v, String p, int w) {
			this.v = v;
			this.p = p;
			this.w = w;
		}

		@Override
		public int compareTo(Dpair arg0) {
			return this.w - arg0.w;
		}

	}

	public void dijkstra(String s) {

		PriorityQueue<Dpair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();

		Dpair p = new Dpair(s, s, 0);
		pq.add(p);

		while (pq.size() > 0) {
			// 1.Remove
			Dpair rem = pq.remove();

			// 2.Mark
			if (visited.contains(rem.v)) {
				continue;
			}
			visited.add(rem.v);

			// 3.Work
			System.out.println(rem.v + " via " + rem.p + " @ " + rem.w);

			// 4.Neighbour
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {

					Dpair np = new Dpair(nbr, rem.p + nbr, rem.w + vces.get(rem.v).get(nbr));
					pq.add(np);
				}
			}

		}

	}

	private class Ppair implements Comparable<Ppair> {
		String v;
		String av;
		int aew;

		public Ppair(String v, String av, int aew) {
			this.v = v;
			this.av = av;
			this.aew = aew;
		}

		@Override
		public int compareTo(Ppair arg0) {
			return this.aew - arg0.aew;
		}

	}

	public Graph prims() {

		Graph mst = new Graph();
		PriorityQueue<Ppair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allvces = new ArrayList<>(vces.keySet());

		String s = allvces.get(0);

		Ppair p = new Ppair(s, null, 0);
		pq.add(p);

		while (pq.size() > 0) {
			// 1.Remove
			Ppair rem = pq.remove();

			// 2.Mark
			if (visited.contains(rem.v)) {
				continue;
			}
			visited.add(rem.v);

			// 3.Work
			mst.addVertex(rem.v);
			if (rem.av != null) {
				mst.addEdge(rem.v, rem.av, rem.aew);
			}
			// 4.Neighbour
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {

					Ppair np = new Ppair(nbr, rem.v, vces.get(rem.v).get(nbr));
					pq.add(np);
				}
			}

		}

		return mst;
	}

}