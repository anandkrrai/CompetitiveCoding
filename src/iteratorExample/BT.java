package iteratorExample;

import java.util.Iterator;

public class BT implements Iterable<Node> {

	private Node root = null;

	public BT(int[] arr) {
		constructTree(arr);
	}

	public BT() {
	}

	public void constructTree(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int left, int right) {
		if (right < left)
			return null;
		else if (right == left) {
			Node node = new Node(arr[left]);
			return node;
		} else {
			int mid = (left + right) / 2;
			Node node = new Node(arr[mid]);
			node.left = construct(arr, left, mid - 1);
			node.right = construct(arr, mid + 1, right);
			return node;
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node root) {
		if (root == null) {
			return;
		}

		display(root.left);
		System.out.print(root.data + " ");
		display(root.right);
	}

	@Override
	public Iterator<Node> iterator() {
		return new preOrderIterator(root);
	}

}
