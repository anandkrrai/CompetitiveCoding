import java.util.ArrayList;

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

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + maxArea(hist));

	}

}
