//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/remove-all-duplicate-nodes-in-sorted-linked-list/ojquestion
public class DeleteDuplicateNodeInSortedLinKEdList {

	public static Node removeDuplicates(Node head) {
		if (head == null || head.next == null)
			return head;

		Node prev = head, curr = head.next;

		while (curr != null) {
			if (curr.data == prev.data) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
