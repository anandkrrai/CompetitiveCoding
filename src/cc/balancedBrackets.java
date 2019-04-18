package cc;

import java.util.Stack;

public class balancedBrackets {
	public static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			switch (ch) {
			case ')': {
				if (stack.pop() != '(')
					return "NO";
				else {
					break;
				}
			}
			case '}': {
				if (stack.pop() != '{')
					return "NO";
			}
			case ']': {
				if (stack.pop() != '[')
					return "NO";
			}
			default: {
				System.out.println(ch);
				stack.push(ch);
				break;
			}
			}
			++i;
		}

		return "YES";
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("}][}}(}][))]"));
	}

}
