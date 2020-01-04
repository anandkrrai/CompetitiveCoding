package tree;

import java.util.*;

public class AllBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> rv = new ArrayList<>();

		for (int i = 1; i <= n; ++i) {
			List<TreeNode> temp = generateTrees(i, 1, n, new HashMap<Integer, List<TreeNode>>());
			for (TreeNode nn : temp)
				rv.add(nn);
		}

		return rv;

	}

	public List<TreeNode> generateTrees(int val, int lo, int hi, HashMap<Integer, List<TreeNode>> map) {
		if (map.containsKey(val))
			return map.get(val);
		List<TreeNode> list = new ArrayList<>();
		if (lo > hi) {
			list.add(null);
			return list;
		}
		if (lo == hi) {
			list.add(new TreeNode(lo));
			return list;
		}

		List<TreeNode> left = new ArrayList<>();
		List<TreeNode> right = new ArrayList<>();

		for (int x = lo; x < val; ++x) {
			List<TreeNode> temp = generateTrees(x, lo, val - 1, map);
			for (TreeNode n : temp) {
				left.add(n);
			}
		}
		for (int x = val + 1; x <= hi; ++x) {
			List<TreeNode> temp = generateTrees(x, val + 1, hi, map);
			for (TreeNode n : temp) {
				right.add(n);
			}
		}

		for (TreeNode l : left) {
			for (TreeNode r : right) {
				TreeNode nn = new TreeNode(val);
				nn.left = l;
				nn.right = r;
				list.add(nn);
			}
		}

		// map.put(val , list);
		return list;
	}
}
