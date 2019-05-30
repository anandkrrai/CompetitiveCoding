package cc;

public class palin {
	boolean isPalindrome(Node head) {
		Node b = (checkPalim(head, head, head));

		return (b == null ? false : true);
	}

	Node checkPalim(Node first, Node last, Node head) {
		if (last == null) {
			return first;
		} else {
			first = checkPalim(first, last.next, head);
			if (first == null)
				return null;

			else if (last == head)
				return first;

			else if (first.data == last.data)
				return first.next;

			else
				return null;

		}
	}
}
