import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

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

	// lca
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

	// distance
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

	public static Node linearise_btr(Node root) {
		if (root.children.size() == 0) {
			return root;
		}

		Node ol = root.children.get(root.children.size() - 1);
		Node alt = linearise_btr(ol);

		while (root.children.size() > 1) {
			Node sl = root.children.get(root.children.size() - 2);
			Node sklTail = linearise_btr(sl);

			Node ll = root.children.remove(root.children.size() - 1);

			sklTail.children.add(ll);

		}

		return alt;
	}

	public static boolean isSimilar(Node root1, Node root2) {
		if (root1.children.size() == root2.children.size()) {
			for (int i = 0; i < root1.children.size(); ++i) {
				Boolean rv = isSimilar(root1.children.get(i), root2.children.get(i));
				if (rv == false) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;
	}

	public static boolean isMirrorStructure(Node root1, Node root2) {
		if (root1.children.size() == root2.children.size()) {
			for (int i = 0; i < root1.children.size(); ++i) {
				Boolean rv = isMirrorStructure(root1.children.get(i),
						root2.children.get(root2.children.size() - i - 1));
				if (rv == false) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;

	}

	public static boolean isSymmetric(Node root) {
		for (int i = 0; i < root.children.size() / 2; ++i) {

			Node left = root.children.get(i);
			Node right = root.children.get(root.children.size() - i - 1);

			if (left.children.size() != right.children.size()) {
				return false;
			}
		}
		boolean rv = true;
		for (Node child : root.children) {
			rv &= isSymmetric(child);
		}

		return rv;
	}

	public static class Max_help {
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
	}

	public static void find_2nd_largest(Node root) {
		Max_help help = new Max_help();

		find2ndLargest(help, root);

		System.out.println(help.secMax);
	}

	private static void find2ndLargest(Max_help help, Node root) {
		if (root == null)
			return;

		for (Node child : root.children) {
			if (child.data > help.max) {
				help.secMax = help.max;
				help.max = child.data;
			} else if (child.data > help.secMax) {
				help.secMax = child.data;
			}
		}
		for (Node child : root.children) {
			find2ndLargest(help, child);
		}
	}

	public static class maxSolveHelper {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size = 0;
		int height = 0;
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;
	}

	public static void multiSolver(Node node, maxSolveHelper ms, int depth) {
		ms.min = Math.min(node.data, ms.min);
		ms.max = Math.max(node.data, ms.max);
		ms.size++;
		ms.height = Math.max(ms.height, depth);

		for (Node child : node.children) {
			multiSolver(child, ms, depth + 1);
		}
	}

	public static void multiSolver(Node node, maxSolveHelper ms, int depth, int data) {
		ms.min = Math.min(node.data, ms.min);
		ms.max = Math.max(node.data, ms.max);
		ms.size++;
		ms.height = Math.max(ms.height, depth);

		if (data < node.data && node.data < ms.ceil)
			ms.ceil = node.data;

		if (data > node.data && node.data > ms.floor)
			ms.floor = node.data;

		for (Node child : node.children) {
			multiSolver(child, ms, depth + 1, data);
		}
	}

	public static class pre_sucHelper {
		int pre = -1;
		boolean visited = false;
	}

	public static void succ_prede(Node root, int num, pre_sucHelper help) {

		if (help.visited) {
			System.out.println("successor:" + root.data);
			help.visited = false;
		}
		if (root.data == num) {
			System.out.println("pre:" + help.pre);
			help.visited = true;
		} else {
			help.pre = root.data;
			help.visited = false;
		}

		for (Node child : root.children) {
			succ_prede(child, num, help);
		}
	}

	public static int KthSmallest(Node root, int k) {
		int rv = Integer.MIN_VALUE;
		for (int i = 0; i < k; ++i) {
			maxSolveHelper ms = new maxSolveHelper();
			multiSolver(root, ms, 0, rv);
			rv = ms.ceil;
		}

		return rv;
	}

	public static int KthLargest(Node root, int k) {
		int rv = Integer.MAX_VALUE;
		for (int i = 0; i < k; ++i) {
			maxSolveHelper ms = new maxSolveHelper();
			multiSolver(root, ms, 0, rv);
			rv = ms.floor;
		}

		return rv;
	}

	public static void KthLargest_arrayList_helper(Node root, ArrayList<Integer> list) {
		list.add(root.data);

		for (Node child : root.children)
			KthLargest_arrayList_helper(child, list);
	}

	public static int KthSmallest_arrayList(Node root, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		KthLargest_arrayList_helper(root, list);
		Collections.sort(list);
		return list.get(k - 1);
	}

	public static class diameter_helper {
		int dia = 0;
		int depth = 0;
	}

	public static diameter_helper findDiameter(Node root) {
		if (root == null) {
			return new diameter_helper();
		}
		diameter_helper rv = new diameter_helper();

		ArrayList<diameter_helper> list = new ArrayList<>();

		for (Node child : root.children) {
			list.add(findDiameter(child));
		}

		for (int i = 0; i < list.size(); ++i) {
			rv.depth = Math.max(rv.depth, list.get(i).depth);
			rv.dia = Math.max(rv.dia, list.get(i).dia);
		}
		rv.depth += 1;

		for (int i = 0; i < list.size(); ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				rv.dia = Math.max(rv.dia, list.get(i).depth + list.get(j).depth + 1);
			}
		}

		return rv;
	}

	public static void level_order_lineWise(Node root) {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (list.size() > 0) {
			LinkedList<Node> temp = new LinkedList<Node>();

			while (list.size() > 0) {
				Node n = list.removeFirst();
				System.out.print(n.data + " ");
				for (Node child : n.children)
					temp.addLast(child);
			}
			System.out.println();
			list = temp;
		}
	}

	public static void level_order_zigzag(Node root) {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		boolean flag = true;
		while (list.size() > 0) {
			LinkedList<Node> temp = new LinkedList<Node>();
			LinkedList<Integer> stack = new LinkedList<Integer>();
			while (list.size() > 0) {

				Node n = list.removeFirst();
				if (flag) {
					stack.addFirst(n.data);
				} else {
					System.out.print(n.data + " ");
				}

				for (Node child : n.children)
					temp.addLast(child);
			}

			while (stack.size() != 0) {
				System.out.print(stack.removeFirst() + " ");
			}

			flag = !flag;
			System.out.println();
			list = temp;
		}
	}

	public static class pre_post_in_help {
		Node node;
		int status = 0;
	}

	public static void pre_post_in(Node root) {
		LinkedList<pre_post_in_help> stack = new LinkedList<>();
		pre_post_in_help ob = new pre_post_in_help();
		ob.node = root;
		stack.addLast(ob);

		while (stack.size() != 0) {
			pre_post_in_help temp = stack.removeLast();
			if (temp.status == 0) {
				System.out.println(temp.node.data + " pre");
				++temp.status;
				stack.addLast(temp);
			} else if (temp.status <= temp.node.children.size()) {
				// status-1th child
				pre_post_in_help child = new pre_post_in_help();
				child.node = temp.node.children.get(temp.status - 1);
				int child_processed=temp.status-1;
				if(child_processed>=1)
				System.out.println(temp.node.data + "In-" + child_processed);

				++temp.status;
				stack.addLast(temp);
				stack.addLast(child);
			} else if (temp.status == temp.node.children.size() + 1) {
				// post area
				System.out.println(temp.node.data + "post ");
				++temp.status;
				stack.addLast(temp);
			} else {
				// pop
			}

		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110,
				-1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));

		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110,
				-1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 200, -1, -1, -1));

		Node root = construct(list);
		Node root2 = construct(list);

		// display(root);
		// System.out.println(size(root));
		// System.out.println(find(root, 90));
		// System.out.println(find(root, 5));
		// System.out.println(max(root));
		// System.out.println(depth(root));

		// ArrayList<Integer> rv = node2rootPath(root, 90);
		// for (int x : rv) {
		// System.out.print(x + "->");
		// }

		// System.out.println();

		// System.out.println(distance(root, 70, 120).node1_to_node2);

		// System.out.println(FindDistance(root, 50, 120));

		// System.out.println(leastCommonAncestor(root, 50, 20));

		// display(root);
		// remove_leave(root);
		// System.out.println("=>>>>>>>>>>>>>>>>>>>>>>...................");
		// display(root);

		// display(root);
		// linearise_btr(root);
		// System.out.println("=>>>>>>>>>>>>>>>>>>>>>>...................");
		//
		// display(root);

		// mirror(root2);
		// System.out.println(isMirrorStructure(root, root2));
		// display(root2);
		// Node root3 = construct(list2);
		//
		// System.out.println(isSymmetric(root3));

		// find_2nd_largest(root);

		// maxSolveHelper ms = new maxSolveHelper();
		// multiSolver(root,ms,0,10);
		// System.out.println(ms.min+" "+ms.max+" "+ms.size+" ht:"+ms.height+"
		// ceil:"+ms.ceil+" floor:"+ms.floor);

		// pre_sucHelper help = new pre_sucHelper();
		// succ_prede(root,90,help);

		// System.out.println(KthLargest(root, 5));

		// System.out.println(KthSmallest_arrayList(root, 5));

		// level_order_lineWise(root);
		// level_order_zigzag(root);
		// diameter_helper result = findDiameter(root);
		// System.out.println("depth:"+result.depth+" dia:"+result.dia);

		pre_post_in(root);

	}
}