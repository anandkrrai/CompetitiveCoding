//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/is-linked-list-palindrome/ojquestion
public class islInkedListPalindrome {
   	private static class HeapMover {
		Node node;
	}
	
     public static  boolean isPalindrome(Node head) {
		HeapMover left = new HeapMover();
		left.node = head;
		return IsPalin(left, head);
	}

	private static  boolean IsPalin(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalin(left, right.next);

		if (res == false) {
			return false;
		}

		if (left.node.data == right.data) {
			left.node = left.node.next;
			return true;
		} else {
			return false;
		}

	}
}
