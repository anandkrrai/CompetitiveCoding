import java.util.Stack;

public class BracketsReversal {

	public static int reversal(String str) {
		int rv = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);

			if (ch == '}') {
				if (stack.size() == 0) {
					++rv;
					stack.push('{');
				} else {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						stack.push('}');
					}
				}
			} else {
				stack.push('{');
			}
		}

		rv += stack.size() / 2;

		return rv;
	}

	public static void main(String[] args) {

		System.out.println(reversal("{{}}}}}}}"));
	}

}
