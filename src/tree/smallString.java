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

	String ans;

	public String smallestFromLeaf(TreeNode root) {
		ans = "";
		dfs(root, new StringBuilder(""));
		return ans;
	}

	public void dfs(TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append((char) ('a' + node.val));

		if (node.left == null && node.right == null) {
			sb.reverse();
			String S = sb.toString();
			sb.reverse();

			if (S.compareTo(ans) < 0)
				ans = S;
		}

		dfs(node.left, sb);
		dfs(node.right, sb);
		sb.deleteCharAt(sb.length() - 1);
	}

	public String smallestFromLeaf1(TreeNode root) {
		if (root == null) {
			return "";
		} else if (root.left == null && root.right == null) {
			return (char) (root.val + 'a') + "";
		} else if (root.left == null) {
			String r = smallestFromLeaf(root.right);
			return r + (char) (root.val + 'a');
		} else if (root.right == null) {
			String l = smallestFromLeaf(root.left);
			return l + (char) (root.val + 'a');
		} else {
			String l = smallestFromLeaf(root.left);
			String r = smallestFromLeaf(root.right);
			if (l.compareTo(r) < 0) {
				return l + (char) (root.val + 'a');
			} else {
				return r + (char) (root.val + 'a');
			}
		}
	}
}
