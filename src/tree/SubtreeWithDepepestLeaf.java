package tree;

public class SubtreeWithDepepestLeaf {
	public int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		int depth = getDepth(root);
		return subtreeWithAllDeepest(root, depth - 1);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root, int depth) {
		if (depth == 0) {
			return root;
		}
		if (root == null)
			return null;

		TreeNode left = null, right = null;

		left = subtreeWithAllDeepest(root.left, depth - 1);
		right = subtreeWithAllDeepest(root.left, depth - 1);

		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return null;
		}

	}

}
