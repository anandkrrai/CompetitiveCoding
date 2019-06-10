//https://leetcode.com/problems/add-two-numbers/
//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/addition-of-two-linked-list/ojquestion
public class AdditionOfTwoLinkList {
	
    public static Node addTwoNumbers(Node l1, Node l2) {
        l1=reverse(l1);
        l2=reverse(l2);
		Node rv = new Node(0), temp = rv;
		int c1 = 0, sum;

		while (l1 != null || l2 != null) {
			sum = c1;
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}

			c1 = sum / 10;
			Node temp1 = new Node(sum % 10);
			temp.next = temp1;
			temp = temp1;
		}

		if (c1 != 0) {
			Node temp1 = new Node(c1);
			temp.next = temp1;
		}

		return reverse(rv.next);
	}
	
	public static Node reverse(Node node) { 
       Node prev = null; 
       Node current = node; 
       Node next = null; 
       while (current != null) { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
       } 
       node = prev; 
       return node; 
   } 
}
