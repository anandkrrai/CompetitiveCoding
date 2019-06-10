import java.util.Stack;

public class AdjacentTwins {
	public static void removeAdjTwins(String s) {

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (stack.size() != 0 && stack.peek() == s.charAt(i)) {
				stack.pop();
				++i;
			} else {
				stack.push(s.charAt(i));
				++i;

			}
		}

		String str = "";
		while (stack.size() != 0) {
			str = stack.pop() + str;
		}
		System.out.println(str);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
