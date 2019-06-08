
public class nextGreaterElementInLinkedList {
//	public void fillArray(ListNode head, int[] arr, int count, Stack<Integer> stack) {
//
//		if (head.next == null) {
//			arr = new int[count + 1];
//			arr[count] = 0;
//			stack.push(arr[count]);
//			return;
//		}
//
//		fillArray(head.next, arr, count + 1, stack);
//		while (stack.size() > 0 && stack.peek() <= head.val) {
//			stack.pop();
//		}
//
//		if (stack.size() == 0) {
//			arr[count] = 0;
//		} else {
//			arr[count] = stack.peek();
//		}
//
//		stack.push(head.val);
//
//	}
//
//	public int[] nextLargerNodes(ListNode head) {
//		if (head == null)
//			return null;
//
//		int[] arr = null;
//
//		fillArray(head, arr, 0, new Stack<Integer>());
//		return arr;
//	}

	public static void main(String[] args) {
		int[] arr = null;
		fun(arr);
	}

	private static void fun(int[] arr) {
		arr = new int[2];
		System.out.println(arr[0]);
	}

}
