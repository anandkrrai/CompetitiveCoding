package iteratorExample;

import java.util.*;

public class preOrderIterator implements Iterator<Node> {

	private Stack<Node> stack;
	private boolean firstTime = true;
	private Node node;

	public preOrderIterator(Node root) {
		node = root;
	}

	@Override
	public boolean hasNext() {
		if (firstTime) {
			if (node == null)
				return false;
			stack = new Stack<Node>();
			firstTime = false;
			stack.add(node);
		}
		return !stack.isEmpty();
	}

	@Override
	public Node next() {
		Node rem = stack.pop();
		if (rem.right != null)
			stack.push(rem.right);
		if (rem.left != null)
			stack.push(rem.left);
		
		return rem;
	}

}
