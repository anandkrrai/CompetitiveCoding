//https://leetcode.com/problems/merge-two-sorted-lists/
//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/merge-sorted-linked-lists-in-reverse/ojquestion
public class mergeSortedLinkList {

	public static Node mergeResult(Node head1, Node head2) {
		Node rv = mergeTwoLists(head1, head2);
		rv = reverseList(rv);
		return rv;
	}

	public static Node reverseList(Node head) {
		if (head == null)
			return head;

		Node tail = head;

		while (tail.next != null) {
			tail = tail.next;
		}

		rev(head);

		Node temp = tail;
		tail = head;
		head = temp;
		tail.next = null;

		return head;
	}

	public static void rev(Node head) {
		if (head.next == null)
			return;

		rev(head.next);
		head.next.next = head;
	}

	public static Node mergeTwoLists(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		Node node = null, rv = null;

		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				if (node == null) {
					node = l1;
					rv = node;
				} else {
					node.next = l1;
					node = node.next;
				}
				l1 = l1.next;
			} else {
				if (node == null) {
					node = l2;
					rv = node;
				} else {
					node.next = l2;
					node = node.next;
				}
				l2 = l2.next;
			}
		}

		if (l1 != null)
			node.next = l1;

		if (l2 != null)
			node.next = l2;

		return rv;
	}

}
