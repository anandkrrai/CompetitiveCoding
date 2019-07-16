package iteratorExample;

public class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		String str = data + "->";
		if (left != null)
			str += left.data;
		str += ",";
		if (right != null)
			str += right.data;
		str += ".";
		return str;
	}
}
