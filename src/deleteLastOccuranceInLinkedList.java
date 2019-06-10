
//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/last-occurrence-of-an-item/ojquestion
public class deleteLastOccuranceInLinkedList {

	public static Node func(Node head, int key) {
		Node x = null;
		Node temp = head;
		while (temp != null) {
			if (temp.data == key)
				x = temp;

			temp = temp.next;
		}

		if (x != null) {
			if (x.next == null) {
				Node bef = head, af = head.next;
				while (af.next != null) {
					bef = bef.next;
					af = af.next;
				}
				bef.next = null;
			} else {
				x.data = x.next.data;
				temp = x.next;
				x.next = x.next.next;
			}
		}
		return head;

	}

}
