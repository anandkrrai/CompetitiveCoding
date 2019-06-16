import java.util.Stack;

//https://leetcode.com/problems/simplify-path/
public class simplyPath {

	public static String simplifyPath(String path) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < path.length(); ++i) {
			char ch = path.charAt(i);

			if (ch == '/') {
				if (stack.size() == 0) {
					stack.push(ch);
				} else {
					if (stack.peek() == '/') {
						// do nothing
					} else if (stack.peek() == '.') {
						stack.pop();
					} else {
						stack.push(ch);
					}
				}
			} else if (ch == '.') {
				if (stack.peek() == '.') {
					if(stack.size()!=0)
					stack.pop();
					if(stack.size()!=0)
					stack.pop();
					if(stack.size()!=0)
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}

		}

		String rv = "";
		if (stack.size() > 0 && (stack.peek() == '.' || stack.peek() == '/'))
			stack.pop();

		while (stack.size() != 0) {
			rv = stack.pop() + rv;
		}

		if (rv.length() == 0)
			return "/";

		return rv;
	}

	public static void main(String[] args) {
		String str = "/h/////......";
		System.out.println(simplifyPath(str));
	}

}
