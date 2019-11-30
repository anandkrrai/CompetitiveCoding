import java.math.BigInteger;
import java.util.Stack;

public class A {

	public static int area(int[] arr) {
		int area = 0, i = 0;
		Stack<Integer> stack = new Stack<>();
		while (i < arr.length) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			} else {
				int tp = stack.pop();
				int ar = arr[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				area = Math.max(ar, area);
			}
		}

		while (stack.size() > 0) {
			int tp = stack.pop();
			int ar = arr[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			area = Math.max(ar, area);

		}

		return area;
	}

	public static void main(String[] args) {

		int n = 64;
		BigInteger b = new BigInteger("2");
		StringBuilder sb = new StringBuilder("123456");
//		System.out.println(sb);
///		System.out.println(((n & n - 1) == 0) ? true : false);
	}
}
