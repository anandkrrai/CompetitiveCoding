import java.util.ArrayList;
import java.util.Stack;

public class AreaUnderHistogram {

	public static int maxArea(int[] arr) {
		int maxArea = -1;
		int i = 0;
		ArrayList<Integer> stack = new ArrayList<>();

		while (i < arr.length) {
			if (stack.size() == 0 || arr[stack.get(stack.size() - 1)] <= arr[i]) {
				stack.add(i);
				++i;
			} else {
				int top = stack.remove(stack.size() - 1);
				int breadth = 1;
				if (stack.size() != 0) {
					breadth = i - stack.get(stack.size() - 1) - 1;
				}
				maxArea = Math.max(maxArea, arr[top] * breadth);

			}
		}
		while (stack.size() != 0) {
			int top = stack.remove(stack.size() - 1);
			int breadth = 1;
			if (stack.size() != 0) {
				breadth = i - stack.get(stack.size() - 1) - 1;
			}
			maxArea = Math.max(maxArea, arr[top] * breadth);

		}
		return maxArea;
	}

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
		int hist[] = { 1, 1, 6 };
		System.out.println("Maximum area is " + maxArea(hist));

	}

}
