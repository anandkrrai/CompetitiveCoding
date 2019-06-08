import java.util.Stack;

public class nextGreater {

	static void printNGE(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		int[] print = new int[n];

		for (int i = n - 1; i >= 0; --i) {

			while (stack.size() > 0 && stack.peek() <= arr[i])
				stack.pop();

			if (stack.size() == 0) {
				print[i] = -1;
			} else {
				print[i] = stack.peek();
			}

			stack.push(arr[i]);
		}

		for (int i : print) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4,4,4 };

		printNGE(arr, arr.length);
	}

}
