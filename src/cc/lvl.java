package cc;

import java.util.List;

public class lvl {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> rv = new List<>();

		List<Integer> list = new List<>();
		list.add(root.val);

		List<Integer> temp;

		while (list.size() != 0) {
			rv.add(list);
			temp = new List<>();
			while (list.size() != 0) {
				TreeNode node = list.remove();

				if (node.left != null)
					temp.add(node.left);
				if (node.right != null)
					temp.add(node.right);
			}
			list = temp;
		}

		return rv;

	}
}
