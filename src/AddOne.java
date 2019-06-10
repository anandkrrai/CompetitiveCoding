//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/add-one-to-linked-list/ojquestion
public class AddOne {

	public static int add(Node node) {
		if (node == null) {
			return 1;
		}

		int carry = add(node.next);
		node.data = node.data + carry;
		carry = node.data / 10;
		node.data = node.data % 10;

		return carry;

	}

	public static Node plusOne(Node n) {
		int carry = add(n);
		if (carry == 1) {
			Node head = new Node(1);
			head.next = n;
			return head;
		} else {
			return n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
