package cc;

import java.util.ArrayList;

public class LCA {
	ArrayList<Node> ancestors(Node node, int n1) {
		if (node == null)
			return null;

		if (node.data == n1) {
			ArrayList<Node> list = new ArrayList<Node>();
			list.add(node);
			return list;
		}

		ArrayList<Node> rv = ancestors(node.left, n1);
		if (rv != null) {
			rv.add(node);
			return rv;
		}

		rv = ancestors(node.right, n1);
		if (rv != null) {
			rv.add(node);
			return rv;
		}
		return null;
	}

	Node LCA(Node node, int n1, int n2) {
		ArrayList<Node> l1 = ancestors(node, n1);
		ArrayList<Node> l2 = ancestors(node, n2);
		Node rv = l1.get(l1.size() - 1);
		while (l1.get(l1.size() - 1).data == l2.get(l2.size() - 1).data) {
			rv = l1.remove(l1.size() - 1);
			l2.remove(l2.size() - 1);
		}
		return rv;
	}

}
