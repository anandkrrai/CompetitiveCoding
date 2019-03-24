package pep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			children = new ArrayList<Node>();
		}
	}

	public static Node construct(ArrayList<Integer> data_list) {
		Node root = null;
		ArrayList<Node> nList = new ArrayList<Node>();

		for (Integer data : data_list) {
			Node nn = new Node(data);

			if (data == -1) {
				nList.remove(nList.size() - 1);
			} else {
				if (nList.size() == 0) {
					root = nn;
				} else {
					Node lastn = nList.get(nList.size() - 1);
					lastn.children.add(nn);
				}

				nList.add(nn);
			}
		}

		return root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		} else {
			String output = node.data + "=>";

			for (Node child : node.children) {
				output += child.data + ",";
			}
			output += ".";
			System.out.println(output);
			for (Node child : node.children) {
				display(child);
			}
		}

	}

	public static int size(Node root) {
		int rv = 1;

		for (Node child : root.children) {
			rv += size(child);
		}
		return rv;
	}

	public static boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		boolean rv = false;
		for (Node child : node.children) {
			rv |= find(child, data);
		}

		return rv;

	}

	public static int max(Node node) {
		int rv = node.data;

		for (Node child : node.children) {
			rv = Math.max(rv, max(child));
		}

		return rv;
	}

	public static int depth(Node node) {

		int rv = 0;

		for (Node child : node.children) {
			rv = Math.max(rv, depth(child));
		}

		return rv + 1;

	}

	public static ArrayList<Integer> node2rootPath(Node root, int dtf) {
		if (root.data == dtf) {
			ArrayList<Integer> rv = new ArrayList<Integer>();
			rv.add(dtf);
			return rv;
		}

		ArrayList<Integer> rv = new ArrayList<Integer>();
		for (Node child : root.children) {
			rv = node2rootPath(child, dtf);
			if (rv.size() > 0) {
				rv.add(root.data);
				return rv;
			}
		}
		return rv;

	}

//	lca
	public static int leastCommonAncestor(Node root, int n1, int n2) {
		ArrayList<Integer> n1List = node2rootPath(root, n1);
		ArrayList<Integer> n2List = node2rootPath(root, n2);

		int ancestor = -1;
		while (n1List.size() > 0 && n2List.size() > 0) {
			if (n1List.get(n1List.size() - 1) != n2List.get(n2List.size() - 1)) {
				break;
			}
			ancestor = n1List.remove(n1List.size() - 1);
			n2List.remove(n2List.size() - 1);

		}

		return ancestor;
	}

//	distance
	public static int FindDistance(Node root, int n1, int n2) {
		ArrayList<Integer> n1List = node2rootPath(root, n1);
		ArrayList<Integer> n2List = node2rootPath(root, n2);
		int i, j, count = 0;

		for (i = n1List.size() - 1, j = n2List.size() - 1; i >= 0 && j >= 0; --i, --j) {
			if (n1List.get(i) != n2List.get(j)) {
				break;
			}
			++count;

		}

		return n1List.size() + n2List.size() - (2 * count) + 1;
	}

	public static distance_helper distance(Node root, int n1, int n2) {
		distance_helper mp = new distance_helper();
		if (root.data == n1) {
			mp.node1_dist = 0;
		}

		if (root.data == n2) {
			mp.node2_dist = 0;
		}

		for (Node child : root.children) {
			distance_helper rv = distance(child, n1, n2);
			if (rv.node1_to_node2 < mp.node1_to_node2) {
				return rv;
			}
			mp.node1_dist = Math.min(mp.node1_dist, rv.node1_dist + 1);
			mp.node2_dist = Math.min(mp.node2_dist, rv.node2_dist + 1);
			mp.node1_to_node2 = Math.min(mp.node1_dist + mp.node2_dist + 1, rv.node1_to_node2);

		}

		return mp;

	}

	public static class distance_helper {
		int node1_dist, node2_dist, node1_to_node2;

		public distance_helper() {
			node1_dist = 100000;
			node2_dist = 100000;
			node1_to_node2 = 100000;
		}
	}

	public static void mirror(Node root) {
		Collections.reverse(root.children);

		for (Node child : root.children) {
			mirror(child);
		}
	}

	public static void remove_leave(Node node) {
//
//		for (Node child : node.children) {
//			if (child.children != null && child.children.size() == 0) {
//				node.children.remove(child);
//			}
//		}
//		for (Node child : node.children) {
//			remove_leave(child);
//		}
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(i);
			} else {
				remove_leave(child);
			}
		}

	}

	public static void linearise(Node node) {
		for (int i = node.children.size() - 1; i >= 1; --i) {
			Node n = node.children.remove(i);
			node.children.get(i - 1).children.add(n);
		}
		
		for (Node child : node.children) {
			linearise(child);
		}

		
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110,
				-1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		Node root = construct(list);
//		display(root);
//		System.out.println(size(root));
//		System.out.println(find(root, 90));
//		System.out.println(find(root, 5));
//		System.out.println(max(root));
//		System.out.println(depth(root));

//		ArrayList<Integer> rv = node2rootPath(root, 90);
//		for (int x : rv) {
//			System.out.print(x + "->");
//		}

//		System.out.println();

//		System.out.println(distance(root, 70, 120).node1_to_node2);

//		System.out.println(FindDistance(root, 50, 120));

//		System.out.println(leastCommonAncestor(root, 50, 20));

//		display(root);
//		remove_leave(root);
//		System.out.println("=>>>>>>>>>>>>>>>>>>>>>>...................");
//		display(root);
		
		display(root);
		linearise(root);
		System.out.println("=>>>>>>>>>>>>>>>>>>>>>>...................");

		display(root);

	}

}
