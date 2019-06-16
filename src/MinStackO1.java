import java.util.Stack;

public class MinStackO1 {

	public static Stack<Integer> stack = new Stack<Integer>();
	public static int min;

	public static void push(int x) {
		if (stack.size() == 0) {
			stack.push(x);
			min = x;
		} else if (x < min) {
			stack.push(2 * x - min);
			min = x;
		} else {
			stack.push(x);
		}
	}

	public static int getMin() {
//		return Math.min(min, stack.peek());
		return min;
	}

	public static int pop() {
		if (stack.peek() < min) {
			int rv = min;
			min = 2 * min - stack.pop();
			return rv;
		} else {
			return stack.pop();
		}
	}

	public static void main(String[] args) {

		push(10);
		push(5);
		push(2);
		push(3);
		System.out.println("min " + min);
		System.out.print("popped " + pop());
		System.out.println("min " + min);
		System.out.print("popped " + pop());
		System.out.println("min " + min);
		System.out.print("popped " + pop());
		System.out.println("min " + min);
		System.out.print("popped " + pop());

	}

}
