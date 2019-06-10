//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/modular-node-in-a-linked-list/ojquestion
public class ModularNodes {
	public static int moduarNode(Node head, int k) {
		int index = 1, rv = -1;
		while (head != null) {
			if (index % k == 0)
				rv = head.data;
			++index;
			head = head.next;
		}
		return rv;
	}
}
