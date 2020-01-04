package tree;

import java.util.*;

public class allPossibleFullBt {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<TreeNode> allPossibleFBT(int n) {
		return allPossibleFBT(n, new HashMap<Integer, List<TreeNode>>());
	}

	public static List<TreeNode> allPossibleFBT(int n, HashMap<Integer, List<TreeNode>> map) {
		List<TreeNode> list = new ArrayList<>();
		if (n == 0) {
			return list;
		} else if (n == 1) {
			list.add(new TreeNode(0));
			return list;
		}
		if (map.containsKey(n))
			return map.get(n);
		int x = 1, y;

		while (x < n) {
			y=n-1-x;
			List<TreeNode> left = allPossibleFBT(x, map);
			List<TreeNode> right = allPossibleFBT(y, map);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode nn = new TreeNode(0);
					nn.left = l;
					nn.right = r;
					list.add(nn);
				}
			}
			x ++;
			
		}
		map.put(n, list);
		return list;
	}
	
	public static void print(TreeNode root) {
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.val+" ");
		print(root.right);
	}
	
	public static void main(String[] args) {
		List<TreeNode> list = allPossibleFBT(7);
		for(TreeNode node : list) {
			print(node);
			System.out.println();
		}
	}
}
