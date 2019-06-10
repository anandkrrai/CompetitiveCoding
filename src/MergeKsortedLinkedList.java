//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/merge-multiple-sorted-linked-lists/ojquestion
//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKsortedLinkedList {
	public ListNode mergeKLists(ListNode[] list) {
		Comparator<ListNode> cmp = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		};
		ListNode rv = null, node = null;
		PriorityQueue<ListNode> q = new PriorityQueue<>(cmp);

		for (ListNode n : list) {
			if (n != null)
				q.add(n);
		}

		while (q.size() != 0) {
			ListNode rm = q.remove();

			if (rv == null) {
				rv = rm;
				node = rm;
			} else {
				node.next = rm;
				node = node.next;
			}
			if (rm.next != null)
				q.add(rm.next);
		}

		return rv;
	}
}
