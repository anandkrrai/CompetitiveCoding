//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/occurence-of-a-number-in-linked-list/ojquestion
public class NumberOfOccuranceInLinkedList {

	public static int frequency(Node node, int search) {
		int count = 0;
		// write your code here
		while (node != null) {
			if (node.data == search)
				++count;

			node = node.next;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
