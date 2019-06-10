import BasicCalculator.Node;

//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/delete-middle/ojquestion
public class deleteMiddleElementLinkedList {

	public static Node Delete(Node head) {
		if (head == null || head.next == null)
			return null;

		if (head.next.next == null) {
			head.next = null;
			return head;
		}
		// write your code here.
		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		slow.data = slow.next.data;
		slow.next = slow.next.next;

		return head;
	}

	static Node deleteMid(Node head) {
		// Base cases
		if (head == null||head.next==null)
			return null;

		Node slow_ptr = head;
		Node fast_ptr = head;
		Node prev = null;

		while (fast_ptr != null && fast_ptr.next != null) {
			fast_ptr = fast_ptr.next.next;
			prev = slow_ptr;
			slow_ptr = slow_ptr.next;
		}

		prev.next = slow_ptr.next;

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
