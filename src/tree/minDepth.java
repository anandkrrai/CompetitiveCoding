package tree;

public class minDepth {
	public int minDepth(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		} else if (node.left == null) {
			return 1 + minDepth(node.right);
		} else if (node.right == null) {
			return 1 + minDepth(node.left);
		} else {
			return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
		}

	}
}
