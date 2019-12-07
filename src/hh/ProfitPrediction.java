package hh;

import java.util.*;

public class ProfitPrediction {
	public static class Node {
		int val, wt;
		double p;
		ArrayList<Node> children;

		public Node(int val, int weight, double p) {
			this.val = val;
			this.wt = weight;
			children = new ArrayList<>();
			this.p = p;
		}
	}

	public String toHexspeak(String num) {
		String str = Long.toHexString(Long.parseLong(num));
		str = str.toUpperCase();
		str = str.replace('0', 'O');
		str = str.replace('1', 'I');

		HashSet<Character> set = new HashSet<>();
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		set.add('E');
		set.add('F');
		set.add('I');
		set.add('O');

		for (int i = 0; i < str.length(); ++i)
			if (!set.contains(str.charAt(i)))
				return "ERROR";
		return str;
	}

	public static double ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ans = 0.0;
		String str = "dsf";
		Comparator<int[]> cmp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		map.put(1, new Node(1, 0, 0.0));
		while (n-- > 1) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int d = scan.nextInt();
			double p = scan.nextDouble();
			Node uu, vv = new Node(v, d, p);
			System.out.println(u + " " + v + " " + d + " " + p);
			map.put(v, vv);
			uu = map.get(u);
			uu.children.add(vv);
		}

		calc(map.get(1), 1, 0);
		System.out.println(ans);
		System.out.println(ans + "");
		scan.close();

	}

	private static void calc(Node node, double prob, int weight) {
		if (node.children.size() == 0) {
			ans = (double) (ans + prob * weight);
		} else {
			for (Node child : node.children) {
				calc(child, (double) prob * child.p, weight + child.wt);
			}
		}
	}

	
}
