import java.util.Stack;

public class decodeString {

	public static int reverseNum(int n) {
		int rv = 0;
		while (n > 0) {
			int rem = n % 10;
			n /= 10;
			rv = rv * 10 + rem;
		}
		return rv;
	}

	public static String decode(String s) {
		s = "a" + s;
		Stack<String> stack = new Stack<>();

		int num = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			char ch = s.charAt(i);

			if (ch == ']') {
				stack.push("");
			} else if (ch >= 'a' && ch <= 'z') {
				if (num != 0) {
					String str = stack.pop(), pu = "";
					num = reverseNum(num);
					for (int k = 0; k < num; ++k) {
						pu += str;
					}

					stack.push(pu);
					num = 0;
				}
				stack.push(ch + stack.pop());
			} else if (ch == '[') {
				num = 0;
			} else {
				if (num == 0)
					num = Integer.parseInt(ch + "");
				else {
					num = num * 10 + Integer.parseInt(ch + "");
				}
			}

		}

		return stack.peek().substring(1);

	}

	public static void main(String[] args) {
//		System.out.println(reverseNum(1011));

		System.out.println(decode("3[a2[c]]"));
	}

}
