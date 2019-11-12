package arraysAndstrings;

import java.util.*;

public class DecodeString {

	public static String DecodeString(String str) {
		Stack<String> strStack = new Stack<String>();
		Stack<String> intStack = new Stack<String>();
		strStack.push("");
		StringBuilder sb = new StringBuilder(""), sb1 = new StringBuilder("");

		for (char ch : str.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				String s = stack.pop();
				stack.push(s+ch);
			} else if (ch == '[') {

			} else if (ch == ']') {

			} else {

			}
		}

		return stack.pop();
	}
}