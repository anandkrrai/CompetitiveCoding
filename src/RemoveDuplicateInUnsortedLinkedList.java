//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/remove-duplicates-in-unsorted-linked-list/ojquestion
public class RemoveDuplicateInUnsortedLinkedList {
	public static Node removeDuplicates(Node head) {
		if (head == null)
			return head;
		HashSet<Integer> set = new HashSet<>();
		Node prev = head, curr = head.next;
		set.add(prev.data);

		while (curr != null) {
			if (set.contains(curr.data)) {
				prev.next = curr.next;
				curr = prev.next;
			} else {
				set.add(curr.data);
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

}
