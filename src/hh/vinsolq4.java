package hh;

import java.util.*;

public class vinsolq4 {

	public static class Node {
		String data;
		int freq;
		Node left, right;

		public Node(String str, int freq) {
			this.data = str;
			this.left = null;
			this.right = null;
			this.freq = freq;
		}
	}

	public static class Pair {
		String ch;
		int freq;

		public Pair(String ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	private static void display(Node root) {
		if (root == null)
			return;
		String s = "";
		s += root.data + "->";
		if (root.left != null) {
			s += root.left.data + " ";
		}
		s += ',';
		if (root.right != null) {
			s += root.right.data + " ";
		}
		System.out.println(s);

		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {
		String file = "abbccc";

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < file.length(); ++i) {
			char ch = file.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Comparator<Pair> cmp = new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.freq - o2.freq;
			}
		};

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(cmp);

		for (char ch : map.keySet()) {
			Pair pair = new Pair(ch + "", map.get(ch));
			pq.add(pair);
		}

		HashMap<Pair, Node> nodesMap = new HashMap<Pair, Node>();

		while (pq.size() > 1) {
			Pair p1 = pq.remove();
			Pair p2 = pq.remove();

			String nstr = p1.ch + p2.ch;
			int nfreq = p1.freq + p2.freq;

			Pair p = new Pair(nstr, nfreq);
			pq.add(p);
			Node node = new Node(nstr, nfreq);

			Node np1 = nodesMap.getOrDefault(p1, new Node(p1.ch, p1.freq));
			Node np2 = nodesMap.getOrDefault(p2, new Node(p2.ch, p2.freq));

			nodesMap.put(p, node);
			node.left = np1;
			node.right = np2;

		}

		Node root = nodesMap.get(pq.remove());

		display(root);
	}

}
