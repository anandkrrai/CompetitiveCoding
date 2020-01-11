package tree;

public class sumWithGrandParentEven {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumEvenGrandparent(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;

		if (root.val % 2 == 0) {
			if (root.left != null) {
				sum += root.left.left == null ? 0 : root.left.left.val;
				sum += root.left.right == null ? 0 : root.left.right.val;
			}
			if (root.right != null) {
				sum += root.right.left == null ? 0 : root.right.left.val;
				sum += root.right.right == null ? 0 : root.right.right.val;
			}
		}

		return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
