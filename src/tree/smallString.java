package tree;

public class smallString {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return "";
		}

		String l = smallestFromLeaf(root.left);
		String r = smallestFromLeaf(root.right);

		if (l.compareTo(r) < 0) {
			return l + (char) (root.val + 97);
		} else {
			return r + (char) (root.val + 97);
		}
	}
}
