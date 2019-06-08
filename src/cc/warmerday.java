package cc;

import java.util.Stack;

public class warmerday {
	public static int[] findWarmerTemp(int T[]) {

		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[T.length];

		arr[arr.length - 1] = 0;
		stack.push(T[arr.length - 1]);
		for (int i = T.length - 2; i >= 0; --i) {

			while (stack.size() > 0 && stack.peek() <= T[i])
				stack.pop();

			if (stack.size() == 0) {
				arr[i] = 0;
			} else {
				arr[i] = stack.peek();
			}

			stack.push(T[i]);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 73, 74, 75, 71, 69, 72, 76, 73 };

		int[] a = findWarmerTemp(arr);

		for (int x : a) {
			System.out.print(x);
		}
	}

}
