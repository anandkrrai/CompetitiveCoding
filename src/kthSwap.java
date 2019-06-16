import java.util.Scanner;
import java.util.Stack;

public class kthSwap {

	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.size() == 0)
					return false;
				if (stack.peek() == '(')
					stack.pop();
			}
		}

		if (stack.size() != 0)
			return false;

		return true;
	}

	public static void main(String[] args) {
		
			System.out.println(isBalanced("(((()))))"));

//		Scanner scan = new Scanner(System.in);
//
//		int n = scan.nextInt();
//		int k = scan.nextInt();
//
//		int[] arr = new int[n];
//		for (int i = 0; i < n; ++i) {
//			arr[i] = scan.nextInt();
//		}
//
//		int temp = arr[k - 1];
//		arr[k - 1] = arr[n - k];
//		arr[n - k] = temp;
//
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
	}

}
