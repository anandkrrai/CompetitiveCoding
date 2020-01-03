package tree;

import java.util.*;

public class merge2BSTintoList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Pair {
		int status;
		TreeNode node;

		public Pair(TreeNode node, int status) {
			this.node = node;
			this.status = status;
		}
	}

	public Pair getNext(Stack<Pair> stack) {
		if (stack.size() == 0) {
			return null;
		} else {
			return stack.peek();
		}
	}

	public Pair hasNext(Stack<Pair> stack) {
		while (stack.size() != 0) {
			if (stack.peek().status == 0) {
				stack.peek().status++;
				if (stack.peek().node.left != null)
					stack.push(new Pair(stack.peek().node.left, 0));
			} else if (stack.peek().status == 1) {
				stack.peek().status++;
				return stack.peek();
			} else if (stack.peek().status == 2) {
				stack.peek().status++;
				if (stack.peek().node.right != null)
					stack.push(new Pair(stack.peek().node.right, 0));
			} else if (stack.peek().status == 3) {
				stack.pop();
			}
		}
		return null;
	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		Stack<Pair> stack1 = new Stack<>();
		Stack<Pair> stack2 = new Stack<>();
		if (root1 != null) {
			stack1.push(new Pair(root1, 0));
		}
		if (root2 != null) {
			stack2.push(new Pair(root2, 0));
		}
		List<Integer> list = new ArrayList<>();
		Pair p1 = hasNext(stack1);
		Pair p2 = hasNext(stack2);

		while (p1 != null && p2 != null) {

			if (p1.node.val < p2.node.val) {
				list.add(getNext(stack1).node.val);
				p1 = hasNext(stack1);
			} else {
				list.add(getNext(stack2).node.val);
				p2 = hasNext(stack2);
			}
		}

		while (p1 != null) {
			list.add(getNext(stack1).node.val);
			p1 = hasNext(stack1);
		}

		while (p2 != null) {
			list.add(getNext(stack2).node.val);
			p2 = hasNext(stack2);
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
