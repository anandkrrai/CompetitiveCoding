import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class A {

	private static class DiaPair {
		int height;
		int diameter;

		public DiaPair() {
			height = 0;
			diameter = 0;
		}
	}

	public static class Node {
		ArrayList<Node> children;
		int val;

		public Node() {
			val = 0;
			children = new ArrayList<>();
		}
	}

	public static HashMap<Integer, DiaPair> diaMap;

	public static DiaPair diameter(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();

			bp.height = -1;
			bp.diameter = 0;

			return bp;
		}

//		if (diaMap.containsKey(node.val)) {
//			return diaMap.get(node.val);
//		}

		ArrayList<DiaPair> list = new ArrayList<>();

		for (Node child : node.children) {
			list.add(diameter(child));
		}

		DiaPair mp = new DiaPair();

		int h1 = -1, h2 = -1, d1 = -1, d2 = -1;

		for (DiaPair p : list) {

			if (h1 < p.height) {
				h2 = h1;
				h1 = p.height;
			} else if (h2 < p.height) {
				h2 = p.height;
			}

			if (d1 < p.diameter) {
				d2 = d1;
				d1 = p.diameter;
			} else if (d2 < p.diameter) {
				d2 = p.diameter;
			}
		}

		mp.height = h1 + 1;

		mp.diameter = Math.max(h1 + h2 + 2, Math.max(d1, d2));
		diaMap.put(node.val, mp);
		return mp;
	}

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
//		int q = scan.nextInt();
		int q = 1;
		diaMap = new HashMap<>();
		ArrayList<Integer> output = new ArrayList<Integer>();

		while (q-- > 0) {
//			int n = scan.nextInt();
			HashMap<Integer, Node> map = new HashMap<>();
			Node zn = new Node();
			zn.val = 0;
			map.put(0, zn);
			for (int n = 0; n < 100000000; ++n) {
				for (int i = 1; i <= n; ++i) {
					int p = i & (i - 1);
					Node parent = map.get(p);
					Node child = new Node();
					child.val = i;
					parent.children.add(child);
					map.put(i, child);
				}
				DiaPair p = diameter(zn);
				System.out.println(p.diameter);
				output.add(p.diameter);
				
			}
			System.out.println(output);
			
			for(int x : output)
				System.out.print(x+" ");
		}
	}
}
